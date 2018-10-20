package sort;

public class N2_Sort {

    public static void bubbleSort(int[] array) {
        int len = array.length;
        for(int i =0;i<len;i++) {
            for(int j =len-1;j>i;j--) {
                if(array[j]<array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("bubbleSort:");
        for (int a:array) { System.out.print(a); }
    }

    public static void insertSort(int[] array) {
        int len = array.length;
        for (int i =1;i<len;i++) {
            for(int j=i;j>0;j--) {
                if(array[j]<array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } else {
                    break;
                }
            }
        }

        System.out.println("insertSort:");
        for (int a:array) { System.out.print(a); }
    }

    public static void chooseSort(int[] array) {
        int len = array.length;
        for(int i =0;i<len-1;i++) {
            int index = i;
            for(int j=i+1;j<len;j++) {
                if(array[j]<array[index]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        System.out.println("chooseSort:");
        for (int a:array) { System.out.print(a); }
    }



    public static void main(String[] args) {
        int[] a = {2,3,4,1,7,0,9};
        bubbleSort(a);
        insertSort(a);
        chooseSort(a);
    }
}
