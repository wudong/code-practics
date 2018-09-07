package uk.graceliu.codepractics.sort;

import java.util.*;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        int[] buffer = new int[array.length];
        recursiveMergeSort(array, 0, array.length-1, buffer);
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
        LinkedList<Pair> queue= new LinkedList<>();
        queue.push(new Pair(start, end));
        while(!queue.isEmpty()){
            sortWithQueue(array, queue);
        }
    }

    public void sortWithQueue(int[] array, Queue<Pair> queue) {
        Pair peek = queue.remove();

        if (peek.end-peek.start<=0) {
        } else if (peek.end-peek.start==1) { //two element to sort,
            if (array[peek.start]> array[peek.end]) {
                ArrayUtil.swap(array, peek.start, peek.end);
            }
        }else{
            //find the middle.
            int middle = peek.start + (int) Math.ceil((peek.end-peek.start) / (double) 2);
            Pair pair1 = new Pair(middle, peek.end);
            Pair pair = new Pair(peek.start, middle - 1);

            queue.add(pair1);
            queue.add(pair);

            //how to do the merge here?
        }
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
