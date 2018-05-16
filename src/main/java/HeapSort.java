import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args){
        int[] array = new int[]{12, 36, 24, 85, 47, 30, 53, 91};
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortArray(int[] array) {
        int arrayLength = array.length;
        /*
        * 构建第一个最大堆
        * 非叶子节点不小于其左右子节点
        * 最后一个非叶子节点下标为arrayLength/2-1
        * 从后往前依次判断转换，生成一个最大堆
        * */
        for (int i = arrayLength / 2 - 1; i >= 0; i--){
            buildHeap(array, i, arrayLength);
        }

        // 输出创建的最大堆
        System.out.println(Arrays.toString(array));

        /*
        * 将所得最大堆的堆首和堆尾交换
        * 从前往后依次判断转化，重新生成一个次最大堆（无堆尾的最大堆，此时堆尾为最大值）
        * 循环上面的步骤至结束，得到有序数组
        * */
        for (int i = arrayLength-1; i > 0; i--){
            // 交换首位
            swap(array, 0, i);
            // 构建最大堆
            buildHeap(array, 0, i);
        }
    }

    private static void buildHeap(int[] array, int index, int arrayLength) {
        int maxIndex = arrayLength - 1;
        int lastIndex = index;
        /*
        * 当前节点的左子节点下标为2*index+1
        * 其右子节点下标为2*index+2
        * 判断过程中，确保其左/右子节点存在，即不越界
        * */
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = leftChildIndex + 1;
        if (leftChildIndex <= maxIndex && array[index] < array[leftChildIndex]){
            lastIndex = leftChildIndex;
        }
        if (rightChildIndex <= maxIndex && array[lastIndex] < array[rightChildIndex]){
            lastIndex = rightChildIndex;
        }
        /*
        * 如过当前节点小于其左/右子节点，则需要交换。并确保此子节点对应的堆依旧是最大堆，因此递归判断
        * */
        if (lastIndex != index){
            swap(array, index, lastIndex);
            buildHeap(array, lastIndex, arrayLength);
        }
    }

    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}
