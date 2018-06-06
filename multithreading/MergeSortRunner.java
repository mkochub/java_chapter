package com.appiancorp.core.expr.fn.info;

import java.util.Random;

public class MergeSortRunner {

  // set to 10000000 later
  public static final int COUNT = 10000000;

  public static void main(String[] args) {
    int[] arr = new int[COUNT];
    Random random = new Random();
    for(int i=0;i<arr.length;i++) {
      arr[i] = random.nextInt();
    }

    int[] copyArr1 = arr.clone();
    int[] copyArr2 = arr.clone();

    long mergeAvg = 0;
    long multiMergeAvg = 0;
    long betterMergeAvg = 0;

    MergeSort mergeSort = new MergeSort();
    MultithreadedMergeSort multithreadedMergeSort = new MultithreadedMergeSort();
    BetterMultithreadedMergeSort betterMultithreadedMergeSort = new BetterMultithreadedMergeSort();

    long start = System.currentTimeMillis();
    mergeSort.sort(arr, 0, arr.length - 1);

    mergeAvg = System.currentTimeMillis() - start;
    System.out.println("Single threaded merge sort: " + mergeAvg);

    //    start = System.currentTimeMillis();
    //    multithreadedMergeSort.sort(copyArr1, 0, copyArr1.length - 1);
    //    multiMergeAvg += System.currentTimeMillis() - start;
    //    System.out.println("Multi threaded merge sort: " + multiMergeAvg);

    start = System.currentTimeMillis();
    betterMultithreadedMergeSort.sort(copyArr2, 0, copyArr2.length - 1, 2);
    betterMergeAvg += System.currentTimeMillis() - start;

    System.out.println("Better Multi threaded merge sort: " + betterMergeAvg);
  }
}
