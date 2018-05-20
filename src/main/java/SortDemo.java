import java.util.Arrays;
import java.util.Random;

public class SortDemo {

    private static int[] arrays = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    private static int quickProcessCount = 0;

    public static void main(String[] args) {

//        BubbleSort(arrays);

//        BubbleSort2(arrays);

//        quickProcessCount = 0;
//        QuickSort(arrays, 0, arrays.length - 1);
//        System.out.println(Arrays.toString(arrays));
//        System.out.println(quickProcessCount);

//        SelectionSort(arrays);

        InsertionSort(arrays);
    }

    private static void BubbleSort(int[] array) {
        int length = array.length;
        int processCount = 0;
        while (length > 0) {
            int swapCount = 0;
            for (int i = 0; i < length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapCount++;
                }
                processCount++;
            }
            if (swapCount == 0) {
                break;
            }
            length--;
        }

        System.out.println(Arrays.toString(array));
        System.out.println("ProcessCount: " + processCount);
    }

    private static void BubbleSort2(int[] array) {
        int index = array.length - 1;
        int processCount = 0;
        while (index > 0) {
            int pos = 0;
            for (int i = 0; i < index; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    pos = i;
                }
                processCount++;
            }
            index = pos;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("ProcessCount: " + processCount);
    }

    private static void QuickSort(int[] array, int begin, int end){
        if (begin >= end){
            return;
        }
        int i = begin;
        int j = end;
        int pivot = i;
        while (i < j){
            while (i < j){
                //从右往左
                quickProcessCount++;
                if (array[pivot] > array[j]){
                    int temp = array[pivot];
                    array[pivot] = array[j];
                    array[j] = temp;
                    pivot = j;
                    break;
                }
                j--;
            }

            while (i < j){
                //从左往右
                quickProcessCount++;
                if (array[pivot] < array[i]){
                    int temp = array[pivot];
                    array[pivot] = array[i];
                    array[i] = temp;
                    pivot = i;
                    break;
                }
                i++;
            }
        }

        QuickSort(array, begin, pivot - 1);
        QuickSort(array, pivot + 1, end);
    }

    private static void SelectionSort(int[] array){
        quickProcessCount=0;
        for (int i = 0; i < array.length; i++){

            int min = array[i];
            int minPosition = i;
            for (int j = i; j < array.length; j++){
                quickProcessCount++;
                if (min > array[j]){
                    minPosition = j;
                    min = array[j];
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minPosition] = temp;

        }

        System.out.println(Arrays.toString(array));
        System.out.println(quickProcessCount);
    }

    private static void InsertionSort(int[] array){

        if (array.length <= 1){
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i = 1; i < array.length; i++){

            int index = i;

            for (int j = i - 1; j >= 0; j--){

                if (array[index] < array[j]){
                    int temp = array[index];
                    array[index] = array[j];
                    array[j] = temp;
                    index = j;
                } else {
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(array));
    }
}
