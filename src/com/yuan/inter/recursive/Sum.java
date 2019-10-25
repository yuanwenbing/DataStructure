package com.yuan.inter.recursive;

public class Sum {
    public static void main(String[] args) {
        int sum = new Sum().sum(new int[]{1, 2, 3, 4});
        System.out.println(sum);
    }

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }
}
