package uk.graceliu.codepractics.sort;

import java.util.Random;

public class ArrayUtil {

    public static void shuffle(int[] array) {
        Random rnd = new Random();
        int size = array.length;
        for (int i = size; i > 1; --i) {
            swap(array, i - 1, rnd.nextInt(i));
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j] = temp;
    }
}
