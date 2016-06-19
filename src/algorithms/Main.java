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

    int[] randomArray = SortUtil.getRandomArray(10000, -1000, 1000);

    for (Sort s : Sort.values()) {
      System.out.println(s.toString() + " : " + calcSortTime(randomArray, s));
    }

    System.out.println("-----------bit operations-----------");
    byte x = 7; 
    System.out.println("byte x\t\t00000111\t" + x);
    System.out.println("x >> 1\t\t00000011\t" + (x >>= 1));
    System.out.println("x << 1\t\t00000110\t" + (x <<= 1));
    System.out.println("x << 5\t\t11000000\t" + (x <<= 5));
    System.out.println("x >> 2\t\t11110000\t" + (x >>= 2));
    System.out.println("------------------------------------");
    
    System.out.println("----------Swapping numbers with using bit XOR operation---------");
    int a = 12;
    int b = 139;
    System.out.println("a = " + a + ", b = " + b);
    a = a^b;
    System.out.println("a = a^b " + a);
    b = a^b;
    System.out.println("b = a^b " + b);
    a = a^b;
    System.out.println("a = a^b " + a);
    System.out.println("-----------------------------------");
  }

  private static String calcSortTime(int[] randomArray, Sort sort) {
    long start = System.currentTimeMillis();
    switch (sort) { // array of 300 000 elements
      case SELECTION: // 71 392 ms
        SortUtil.selectionSort(randomArray);
        break;
      case BUBBLE:  // 266 997 ms
        SortUtil.bubbleSort(randomArray);
        break;
      case INSERTION: // 47 072 ms
        SortUtil.insertionSort(randomArray);
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
