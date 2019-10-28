package com.yuan.inter.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 4};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i- 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
