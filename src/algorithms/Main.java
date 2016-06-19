/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.sort.SortUtil;
import java.util.Arrays;

/**
 *
 * @author ilmir
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int[] arr = SortUtil.getRandomArray(6, -10, 10);
    int[] selectionSort = SortUtil.selectionSort(arr);
    System.out.println(Arrays.toString(arr) + " -> "
            + Arrays.toString(selectionSort) + " selection sort");

    int[] bubbleSort = SortUtil.bubbleSort(arr);
    System.out.println(Arrays.toString(arr) + " -> "
            + Arrays.toString(bubbleSort) + " bubble sort");

    int[] insertionSort = SortUtil.insertionSort(arr);
    System.out.println(Arrays.toString(arr) + " -> "
            + Arrays.toString(insertionSort) + " insertion sort");

    int[] mergeSort = SortUtil.mergeSort(arr);
    System.out.println(Arrays.toString(arr) + " -> "
            + Arrays.toString(mergeSort) + " merge sort");

    int[] randomArray = SortUtil.getRandomArray(300000, -1000, 1000);

    for (Sort s : Sort.values()) {
      System.out.println(s.toString() + " : " + calcSortTime(randomArray, s));
    }
  }

  private static String calcSortTime(int[] randomArray, Sort sort) {
    long start = System.currentTimeMillis();
    switch (sort) { // array of 300 000 elements
      case INSERTION: // 71 392 ms
        SortUtil.insertionSort(randomArray);
        break;
      case SELECTION: // 266 997 ms
        SortUtil.selectionSort(randomArray);
        break;
      case BUBBLE:  // 47 072 ms
        SortUtil.bubbleSort(randomArray);
        break;
      case MERGE: // 35 512 ms
        SortUtil.mergeSort(randomArray);

        break;
      default:
        throw new AssertionError();
    }
    SortUtil.selectionSort(randomArray);
    long end = System.currentTimeMillis();
    return String.valueOf(end - start);
  }

}

enum Sort {
  SELECTION, BUBBLE, INSERTION, MERGE;
}
