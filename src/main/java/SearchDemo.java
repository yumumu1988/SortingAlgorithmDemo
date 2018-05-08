public class SearchDemo {

    private static int[] arrays = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args){
        int number = 16;
        System.out.println(binarySearch(arrays, 0, arrays.length - 1, number));
    }

    private static int binarySearch(int[] array, int begin, int end, int number){

        if (begin > end){
            return -1;
        }

//        int pivot = (int) Math.floor((end - begin + 1) / 2) + begin;
        int pivot = (begin + end) >>> 1;

        if (array[pivot] == number){
            return pivot;
        }

        if (array[pivot] > number){

            return binarySearch(array, begin, pivot - 1, number);

        }

        if (array[pivot] < number){

            return binarySearch(array, pivot + 1, end, number);

        }

        return -1;
    }
}
