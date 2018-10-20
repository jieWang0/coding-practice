package strings;

import java.util.*;

public class Coins {
    public static int countWays(int n) {
        if(n<5)
            return 1;

        if(n == 5)
            return 2;
        // write code here
        int result =0 ;
        if(n>25) {
            while(n> 25) {
                n = n-25;
                result = result + countWays(n);
            }
            result+= countWays(n);
        }else if(n>10 ) {
            while(n> 10) {
                n = n-10;
                result = result + countWays(n);
            }
            result+= countWays(n);
        }else if(n>5) {
            while(n> 5) {
                n = n-5;
                result = result + countWays(n);
            }
            result+= countWays(n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countWays(10));
    }
}
