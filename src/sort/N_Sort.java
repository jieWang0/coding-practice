package sort;


import java.util.*;

/**
 * 桶排序 ： 额外的存储空间作为桶，遍历待排序数组并入对应的桶，遍历一遍入桶，各个桶之前是有序的，再对桶内部进行排序，
 *          如果n个数据分m个桶，m越大，桶内排序时间越接近常数。如果n个数据都是唯一不重复的，那直接定义n个桶，那遍历一遍入桶就有序了。
 *        要求：桶的数量较小，数据对各个桶的分布最好均匀，如果都分到一个桶里，就没效果了
 *
 *基数排序 ：数据的排序可以分成一个一个部分进行，如比较大位数的数据，用桶不行，但是由于高位大的数肯定大，加上稳定排序的思想，可以先排低位，再排高位，如8位数，进行8次针对每位的桶排序就可以了
 *         还有如长字符串排序等。这里注意这种比较部分的方法要求每个数据是一样长的，所以如果不一样长的话可以进行补0或“0”(所有字母ASCII都大于“0”)
 * */

public class N_Sort {

    //对10w个手机号进行排序(桶+基数)
    public static void bucketSort(String array[],int index) {
        if(index<0) {
            return;
        }

        //初始化10个桶，对应0-9十个字符
        Map<Integer,List<String>> bucket = new LinkedHashMap<>();
        for(int i =0;i<10;i++) {
            List<String> temp = new ArrayList<>();
            bucket.put(i,temp);
        }

        //遍历一遍数组入对应的桶
        int len = array.length;
        for(int i=0;i<len;i++) {
            bucket.get(Integer.parseInt(String.valueOf(array[i].charAt(index)))).add(array[i]);
        }

        //将桶中数据拿出来，第一遍最低位排序结束
        int j =0;
        for (Integer item :bucket.keySet()) {
            for (String k:bucket.get(item)) {
                array[j] = k;
                j++;
            }

        }

        //排高位
        bucketSort(array,index-1);
    }

    public static void main(String[] args) {
       // String[] array = {"12345678987","12323332221","34567876544","34567876545","34567876547","34567876540","42223333334"};

        String[] array = new String[100000];
        Random random = new Random();
        for(int i=0;i<100000;i++) {
            String k = String.valueOf(random.nextInt(89999)+10000) + String.valueOf(random.nextInt(899999)+100000);
            array[i] = k;
        }
        long begin = new Date().getTime();
        bucketSort(array,8);
        long end = new Date().getTime();

        for(String s:array) { System.out.println(s); }
        System.out.println("use time --"+ (end-begin));
    }
}
