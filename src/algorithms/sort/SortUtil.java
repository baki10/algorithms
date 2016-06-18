package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ilmir
 */
public class SortUtil {

  /**
   * Find the smallest unsorted element of array and swap it with the first
   * element of unsorted part of array
   *
   * @param in array of integers
   * @return new sorted array of integers
   */
  public static int[] selectionSort(int[] in) {
    int[] arr = Arrays.copyOf(in, in.length);
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = findMinIndex(arr, i, arr.length);
      swap(arr, i, minIndex);
    }
    return arr;
  }

  /**
   * repeat while swapped: 1)set swapped to false 2)look at each adjacent pair
   * if not ordered,swap them and set swapped to true
   *
   * @param in array to be sorted
   * @return sorted array with bubble sort
   */
  public static int[] bubbleSort(int[] in) {
    int[] arr = Arrays.copyOf(in, in.length);
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          swapped = true;
          swap(arr, i, i + 1);
        }
      }
    } while (swapped);
    return arr;
  }

  /**
   * Call the first element of the array "sorted". Repeat until all elements are
   * sorted: look at the next unsorted element. insert into the "sorted" portion
   * by shifting the required number of elements.
   *
   * @param in array of integer
   * @return sorted array
   */
  public static int[] insertionSort(int[] in) {
    int[] arr = Arrays.copyOf(in, in.length);

    int j;                  // the number of items sorted so far
    int key;                // the item to be inserted
    int i;

    for (j = 1; j < arr.length; j++) {// Start with 1 (not 0)
      key = arr[j];
      for (i = j - 1; i >= 0 && arr[i] > key; i--) {// Bigger values are moving up
        arr[i + 1] = arr[i];
      }
      arr[i + 1] = key;    // Put the key in its proper location
    }
    return arr;
  }

  /**
   * Using recursion sort the left half, sort the right half, merge the two
   * halves together
   *
   * @param in array
   * @return sorted array
   */
  public static int[] mergeSort(int[] in) {
    int[] arr = Arrays.copyOf(in, in.length);
    return mergeSortRecursion(arr);
  }

  private  static int[] mergeSortRecursion(int[] list) {
    if (list.length <= 1) {
      return list;
    }

    // Split the array in half
    int[] leftHalf = new int[list.length / 2];
    int[] rightHalf = new int[list.length - leftHalf.length];
    System.arraycopy(list, 0, leftHalf, 0, leftHalf.length);
    System.arraycopy(list, leftHalf.length, rightHalf, 0, rightHalf.length);

    // Sort each half
    mergeSortRecursion(leftHalf);
    mergeSortRecursion(rightHalf);

    // Merge the halves together, overwriting the original array
    merge(leftHalf, rightHalf, list);
    return list;
  }

  private static void merge(int[] first, int[] second, int[] result) {
    // Merge both halves into the result array
    // Next element to consider in the first array
    int iFirst = 0;
    // Next element to consider in the second array
    int iSecond = 0;

    // Next open position in the result
    int j = 0;
    // As long as neither iFirst nor iSecond is past the end, move the
    // smaller element into the result.
    while (iFirst < first.length && iSecond < second.length) {
      if (first[iFirst] < second[iSecond]) {
        result[j] = first[iFirst];
        iFirst++;
      } else {
        result[j] = second[iSecond];
        iSecond++;
      }
      j++;
    }
    // copy what's left
    System.arraycopy(first, iFirst, result, j, first.length - iFirst);
    System.arraycopy(second, iSecond, result, j, second.length - iSecond);
  }

  private static int findMinIndex(int[] arr, int start, int end) {
    int smallest = start;
    for (int i = start; i < end; i++) {
      if (arr[i] < arr[smallest]) {
        smallest = i;
      }
    }
    return smallest;
  }

  private static void swap(int[] arr, int i, int j) {
    if (i < arr.length && j < arr.length) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  public static int[] getRandomArray(int size, int start, int end) {
    int[] arr = new int[size];
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(end - start) + start;
    }
    return arr;
  }

}
