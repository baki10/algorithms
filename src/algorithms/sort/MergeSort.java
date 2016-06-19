package algorithms.sort;

import java.util.Arrays;

/**
 *
 * @author ilmir
 */
public class MergeSort {

  private int[] numbers;
  private int[] helper;
  private int size;
  
  public int[] sort(int[] in) {
    this.numbers = Arrays.copyOf(in, in.length);
    size = numbers.length;
    this.helper = new int[size];
    mergeSort(0, size - 1);
    return numbers;
  }

  private void mergeSort(int low, int high) {
    // check if low is smaller than high, if not then the array is sorted
    if (low < high) {
      int middle = low + (high - low) / 2;
      // sort halves
      mergeSort(low, middle);
      mergeSort(middle + 1, high);
      // Combine them both
      merge(low, middle, high);
    }
  }

  private void merge(int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
      numbers[k] = helper[i];
      k++;
      i++;
    }

  }
}
