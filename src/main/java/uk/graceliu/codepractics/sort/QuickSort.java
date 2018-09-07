package uk.graceliu.codepractics.sort;

import java.util.*;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] array){
        iterativeSort(array, 0, array.length-1);
    }

    //sorting from start, to end (not including end)
    public void recursiveSort(int[] array, int start, int end){
        if (end - start < 1 ) return; //has 1 or zero element to sort.
        else if (end - start  == 1) { // has 2 elements.
            if (array[start] > array[start+1]){
                ArrayUtil.swap(array, start, start+1);
            }
        }  else { //3 or more.
            int lastValue = array[end];

            int i = getPivatolIndex(array, lastValue, start, end-1);

            if (array[i] > lastValue) {
                ArrayUtil.swap(array, i, end);
                recursiveSort(array, start, i-1);
                recursiveSort(array, i+1, end);
            } else {
                ArrayUtil.swap(array, i+1, end);
                recursiveSort(array, start, i);
                recursiveSort(array, i+2, end);
            }
        }
    }

    public void iterativeSort(int[] array, int start, int end) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, end));
        while (!queue.isEmpty()){
            sort(array, queue);
        }
    }

    private void sort(int[] array, Queue<Pair> queue) {
        Pair pair = queue.remove();

        if (pair.end - pair.start < 1 ) return; //has 1 or zero element to sort.
        else if (pair.end - pair.start  == 1) { // has 2 elements.
            if (array[pair.start] > array[pair.start+1]){
                ArrayUtil.swap(array, pair.start, pair.start+1);
            }
        }  else { //3 or more.
            int lastValue = array[pair.end];
            int i = getPivatolIndex(array, lastValue, pair.start, pair.end-1);

            if (array[i] > lastValue) {
                ArrayUtil.swap(array, i, pair.end);
                queue.add(new Pair(pair.start, i-1));
                queue.add(new Pair(i+1, pair.end));
            } else {
                ArrayUtil.swap(array, i+1, pair.end);
                queue.add(new  Pair(pair.start, i));
                queue.add(new Pair(i+2, pair.end));
            }
        }
    }

    private int getPivatolIndex(int[] array, int lastValue, int i, int j) {
        while (i < j) {
            while (array[i] < lastValue && i < j) i++; //find at i that is bigger than last value
            if (i == j) break;
            while (array[j] >= lastValue && j > i) j--; //find at j that is smaller than last value
            if (i == j) break;
            ArrayUtil.swap(array, i, j);
        }
        return i;
    }


}
