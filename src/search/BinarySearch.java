package search;

/**
 * 借助二分查找来求一个数的平方根，保留指定小数位
 *
 * double与float：
 *   float和double的范围是由指数的位数来决定的。
     float的指数位有8位，而double的指数位有11位，分布如下：
         float：
            1bit（符号位） 8bits（指数位） 23bits（尾数位）
         double：
            1bit（符号位） 11bits（指数位） 52bits（尾数位）
    精度由尾数确定，因为2的23次方 = 8388608，共七位，所以float只能精确到6位
 *
 * */
public class BinarySearch {

    public static double binarySearch(int num) {
        double low = 0,high = num,mid = high/2;
        while (high>low) {
            if(mid * mid > num) {
                high = mid;
            } else if(mid * mid < num) {
                low = mid;
            } else {
                return mid;
            }

            if(Math.abs(mid*mid-num)<=0.000001) {
                //保留6位小数
                return ((double)Math.round(mid*1000000))/1000000;
            }
            mid = (high+low)/2;
        }
        return mid;
    }


    public static void main(String[] args) {
        System.out.println(binarySearch(101));
    }
}
