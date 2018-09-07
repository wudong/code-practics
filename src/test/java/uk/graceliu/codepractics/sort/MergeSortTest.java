package uk.graceliu.codepractics.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @org.junit.jupiter.api.Test
    public void testMerge() {
        int[] array = {1,3,5,7,9, 2,4,6};
        int[] buffer = new int[array.length];

        new MergeSort().merge(array, 0, 5, 7, buffer);
        assertArrayEquals(array, new int[]{1,2,3,4,5,6,7,9});
    }

    @org.junit.jupiter.api.Test
    public void testMergeSortSimple() {
        int[] array = {1,5,3,2 };

        new MergeSort().sort(array);
        assertArrayEquals(array, new int[]{1,2,3,5});
    }

    @org.junit.jupiter.api.Test
    public void testMergeSortSimple2() {
        int[] array = {1,5,3,2 ,4};

        new MergeSort().sort(array);
        assertArrayEquals(array, new int[]{1,2,3,4,5});
    }


    @org.junit.jupiter.api.Test
    void testMergeSort() {
        int testSize = 1000;
        int [] ints1 = new int[testSize];
        int [] ints2 = new int[testSize];
        for (int i=0;i<testSize; i++){
            ints1[i]=i;
            ints2[i]=i;
        }

        ArrayUtil.shuffle(ints1);
        new MergeSort().sort(ints1);
        System.out.println(Arrays.toString(ints1));

        assertArrayEquals(ints2, ints1);
    }
}