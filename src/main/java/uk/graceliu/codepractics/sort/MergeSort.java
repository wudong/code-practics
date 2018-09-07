package uk.graceliu.codepractics.sort;

import java.util.*;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        int[] buffer = new int[array.length];
        //recursiveMergeSort(array, 0, array.length-1, buffer);
        iterativeMergeSort(array, 0, array.length-1, buffer);
    }

    public void recursiveMergeSort(int[] array, int start, int end, int[] buffer) {

        if (end-start<=0) { //zero or one element to sort.
            return;
        } else if (end-start==1) { //two element to sort,
            if (array[start]> array[end]) {
                ArrayUtil.swap(array, start, end);
            }
        }else{
            //find the middle.
            int middle = start + (int) Math.ceil((end-start) / (double) 2);

            recursiveMergeSort(array, start, middle-1, buffer);
            recursiveMergeSort(array, middle, end, buffer);
            merge(array, start, middle, end, buffer);
        }
    }

    public void iterativeMergeSort(int[] array, int start, int end, int[] buffer) {
        Deque<Pair> stack= new LinkedList<>();
        stack.push(new Pair(start, end));

        while(!stack.isEmpty()  ){
            sortWithStack(array, stack, buffer);
        }
    }

    public void sortWithStack(int[] array, Deque<Pair> stack, int[] buffer) {
        Pair peek = stack.pop();

        if (peek.children!=null){
            merge(array, peek.children.get(0).start,  peek.children.get(1).start,  peek.children.get(1).end, buffer);
        } else if (peek.end-peek.start<=0) { //zero element.
        } else if (peek.end-peek.start==1) { //two element to sort,
            if (array[peek.start]> array[peek.end]) {
                ArrayUtil.swap(array, peek.start, peek.end);
            }
        } else {
            //find the middle.
            int middle = peek.start + (int) Math.ceil((peek.end-peek.start) / (double) 2);
            Pair pair1 = new Pair(middle, peek.end);
            Pair pair = new Pair(peek.start, middle - 1);

            peek.children= Arrays.asList(pair, pair1);
            stack.push(peek);
            stack.push(pair1);
            stack.push(pair);
        }
    }

    //from bottom up approach to merge. merge 2/4/8/16 in group size.
    public void bottomUpMergeSort(int[] array, int start, int end, int[] buffer) {
        //TODO
    }

    /**
     * Merge the partially sorted two array into one single array
     *
     * @param array the array's region is going to be merged
     * @param start the start of the array region
     * @param middle the end of the array region (not include) and start of the second array region.
     * @param end the end of the second array region
     */
    public void merge(int[] array, int start, int middle, int end, int[] buffer) {
        int i=start; int j=middle;

        int bufferCounter = 0;

        while (bufferCounter < end-start +1) {
            if (j > end || (i < middle && array[i]<=array[j])){
                buffer[bufferCounter+start] = array[i];
                i++;
            } else {
                buffer[bufferCounter+start] = array[j];
                j++;
            }
            bufferCounter++;
        }

        System.arraycopy(buffer, start, array, start, end-start+1 );
    }
}
