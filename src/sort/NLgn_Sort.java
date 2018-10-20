package sort;


/**
 * 利用快速排序查找数组第k大的元素
 * */
public class NLgn_Sort {
    public static int quickSort(int[] array,int begin,int end,int k) {
        if(begin>=end) {
            return -1;
        }

        int index = array[end];
        int i =begin,j=end;
        while(i<j) {

            while (i<j && array[i]<index) {
                i++;
            }
            if(i<j){
                array[j--] = array[i];
            }

            while (i<j && array[j]>index) {
                j--;
            }
            if(i<j) {

                //最后一步赋值的是array[j]，所以white循环走完时中间位置是j
                array[i++] = array[j];
            }

        }

        array[j] = index;
        if(j == k) {
            return index;
        }

        if(j<k) {
            return quickSort(array,j+1,end,k);
        } else {
            return quickSort(array,begin,j-1,k);
        }
    }


    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        System.out.println("quickSort:"+quickSort(a,0,a.length-1,4));
    }
}
