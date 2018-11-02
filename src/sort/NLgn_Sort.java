package sort;

import java.util.Arrays;
import java.util.Stack;

public class NLgn_Sort {

    /**
     * 利用快速排序查找数组第k大的元素
     * @param array
     * @param begin
     * @param end
     * @param k
     * @return
     */
    public static int quickSort(int[] array, int begin, int end, int k) {
        if (begin >= end) {
            return -1;
        }

        int index = array[end];
        int i = begin, j = end;
        while (i < j) {

            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }

            while (i < j && array[j] > index) {
                j--;
            }
            if (i < j) {
                //最后一步赋值的是array[j]，所以white循环走完时中间位置是j
                array[i++] = array[j];
            }

        }

        array[j] = index;
        if (j == k) {
            return index;
        }

        if (j < k) {
            return quickSort(array, j + 1, end, k);
        } else {
            return quickSort(array, begin, j - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println("quickSort:" + quickSort(a, 0, a.length - 1, 4));

        int[] b = {6, 5, 4, 3, 2, 1,5, 4, 3, 2, 1,5, 4, 3, 2, 1,5, 4, 3, 2, 1,5, 4, 3, 2, 1,5, 4, 3, 2, 1,};
        Non_recursion_quickSort(b);
        Arrays.asList(b).forEach(System.out::println);
    }


    /**
     * 快速排序的非递归实现
     * ---利用栈实现
     *        因为快速排序的原理就是每趟排序根据上下边界查找一个中间值，所以可以使用栈来保存上下边界
     * @param array
     */
    public static void Non_recursion_quickSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int start = 0, end = len - 1;
        stack.push(end);
        stack.push(start);
        int middle;
        while (!stack.isEmpty()) {
            start = stack.pop();
            end = stack.pop();
            middle = quickSort_find_middle(start, end, array);
            if (middle > start) {
                stack.push(middle-1);
                stack.push(start);
            }
            if (middle < end) {
                stack.push(end);
                stack.push(middle+1);
            }
        }
    }

    /**
     * 快速排序一遍排序获取中间值的核心代码
     * @param start
     * @param end
     * @param array
     * @return
     */
    private static int quickSort_find_middle(int start, int end, int[] array) {
        if (start == end) {
            return start;
        }
        int index = array[end];
        while (start < end) {
            while (array[start] < index && start < end) {
                start++;
            }

            if (start < end) {
                array[end] = array[start];
                end--;
            }

            while (array[end] > index && start < end) {
                end--;
            }

            if (start < end) {
                array[start] = array[end];
                start++;
            }

        }
        array[end] = index;
        return end;
    }

}
