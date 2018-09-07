package uk.graceliu.codepractics.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static uk.graceliu.codepractics.sort.ArrayUtil.*;

class QuickSortTest {

    @org.junit.jupiter.api.Test
    void quickSort() {
        int testSize = 10000;
        int [] ints1 = new int[testSize];
        int [] ints2 = new int[testSize];
        for (int i=0;i<testSize; i++){
            ints1[i]=i;
            ints2[i]=i;
        }

        shuffle(ints1);

        new QuickSort().sort(ints1);
       // System.out.println(Arrays.toString(ints1));
        assertArrayEquals(ints2, ints1);
    }



    @org.junit.jupiter.api.Test
    void quickSort2() {
         int [] ints1 = {1,3,2};
        new QuickSort().sort(ints1);
        System.out.println(Arrays.toString(ints1));
     }



}