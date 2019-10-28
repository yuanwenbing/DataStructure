package com.yuan.inter.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(new BinarySearch().binarySearch(arr, 3));
    }


    public int binarySearch(int[] arr, int val) {
//        return recursiveBinarySearch(arr, val, 0, arr.length - 1);
        return loopBinarySearch(arr, val);
    }

    private int recursiveBinarySearch(int[] arr, int val, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/ 2;
        if (arr[mid] > val) {
            high = mid - 1;
            return recursiveBinarySearch(arr, val, low, high);
        } else if (arr[mid] < val) {
            low = mid + 1;
            return recursiveBinarySearch(arr, val, low, high);
        } else {
            return mid;
        }
    }

    private int loopBinarySearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
