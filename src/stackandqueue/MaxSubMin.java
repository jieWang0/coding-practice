package stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class MaxSubMin {

    public static int getAll(int[] array,int k) {
        List<Integer> listMax = new ArrayList<>();
        List<Integer> listMin = new ArrayList<>();
        int len = array.length;
        int result =0;
        for(int i =0;i<len-1;i++) {
            listMax.add(i);
            listMin.add(i);
            int j=i+1;
            for(;j<len;j++) {

                //下面两段是重点：利用队列来实现O(1)的复杂度获取数组最大值与最小值
                //修改listMax（元素对应的下标映射到数组元素是递增的）
                while (!listMax.isEmpty() && array[listMax.get(0)]<=array[j]){
                    listMax.remove(0);
                }
                listMax.add(0,j);

                //修改listMin（元素对应的数组下标映射到数组元素是递减的）
                while (!listMin.isEmpty() && array[listMin.get(0)]>=array[j]){
                    listMin.remove(0);
                }
                listMin.add(0,j);

                if(array[listMax.get(listMax.size()-1)] - array[listMin.get(listMin.size()-1)] >k)
                    break;
            }
            if(j>i+1) {
                result+=(j-i);
                System.out.println(i+"-"+(j-1));
            }
            listMax.clear();
            listMin.clear();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,6,4,9,1};
        System.out.println(getAll(test,3));
    }
}
