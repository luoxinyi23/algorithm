package com.luoxinyi.base.sort;

import java.util.Arrays;
import java.util.Objects;

public class BubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 排序趟数，一次排好一个数
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每趟比较的次数
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        // 1.开辟空间
        /*
        Math.random() [0, 1)
        maxSize * Math.random() [0, maxSize)
        (int)(maxSize * Math.random()) [0, maxSize-1]
         */
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        // 2.赋值
        for (int index = 0; index < arr.length; ++index) {
            /*
            (int)((maxValue + 1) * Math.random()) [0, maxValue]
            (int)(maxValue * Math.random()) [0, maxValue -1]
             [-maxValue+1, maxValue]
             */
            arr[index] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (Objects.isNull(arr)) {
            return null;
        }

        int[] res = new int[arr.length];
        for (int index = 0; index < arr.length; ++index) {
            res[index] = arr[index];
        }

        return res;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        //还剩两种情况，同时为空，同时不为空，所以&&后边的条件是没有必要的
        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void comparator(int[] arr) {
        if (arr == null) {
            return;
        }

        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTimes = 50000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTimes; ++i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            sort(arr1);
            comparator(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;

                printArray(arr1);
                printArray(arr2);

                break;
            }
        }
        System.out.println("succeed: " + succeed);

        int[] arr1 = generateRandomArray(maxSize, maxValue);
        System.out.println("before selection sort: ");
        printArray(arr1);

        sort(arr1);

        System.out.println("after selection sort: ");
        printArray(arr1);
    }
}
