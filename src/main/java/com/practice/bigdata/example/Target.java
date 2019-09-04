package com.practice.bigdata.example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kasun on 9/4/19.
 */
public class Target {

    public static void main(String[] args) {

        Integer target = 10;
        Integer[] array = new Integer[]{1, 5, 6, 4, 7};

        int[] arraySum = new int[2];

        List<Integer> numbers = Arrays.asList(array);

        boolean found = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (i != j && array[i] + array[j] == target) {
                    arraySum[0] = i + 1;
                    arraySum[1] = j + 1;
                    found = true;
                    break;
                }
                if (found) {
                    break;
                }
            }
        }
        for (int i = 0; i < arraySum.length; i++) {
            System.out.print(" " + arraySum[i]);
        }
    }
}
