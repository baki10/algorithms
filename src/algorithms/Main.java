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
    
    System.out.println("max int = " + Integer.MAX_VALUE);
    System.out.println("max int + 1 = " + (Integer.MAX_VALUE + 1));
  }
  
}
