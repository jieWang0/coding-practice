package stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class MaxWindown {


    //构造的list中下标对
    public static void getList(int[] array, List<Integer> list,int len) {
        for(int i = 0;i<array.length;i++) {
            if(list.isEmpty()) {
                list.add(i);
                if(i>=2) {
                    System.out.println(array[i]);
                }
                continue;
            }
            if( array[i]>array[list.get(0)]){
                while (!list.isEmpty() && array[i]>array[list.get(0)]) {
                    list.remove(0);
                }
                list.add(i);
            } else {
                list.add(0,i);
            }
            while (!list.isEmpty()&&  i>=len && list.get(list.size()-1) <= i-len) {
                list.remove(list.size()-1);
            }
            if(i>=2)
              System.out.println(array[list.get(list.size()-1)]);

        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,3,5,4,3,3,6,7};
        List<Integer> list = new ArrayList<>();
        getList(array,list,3);
    }
}
