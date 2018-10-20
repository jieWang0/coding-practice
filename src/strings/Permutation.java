package strings;

import java.util.*;

public class Permutation {
    public static ArrayList<String> getPermutation(String A) {
        // write code here
        int n = A.length();
        ArrayList<String> result = new ArrayList<>();
        if (n == 1) {
            result.add(A);
            return result;
        }
        for (int i = 0; i < n; i++) {
            char index = A.charAt(i);
            String left = A.substring(0, i) + A.substring(i + 1, n);
            List<String> list = getPermutation(left);
            for (int j = 0; j < list.size(); j++) {
                result.add(index + list.get(j));
            }
        }
        result.sort((s1,s2)->{
            char[] ss1 = s1.toCharArray();
            char[] ss2 = s2.toCharArray();
            for(int i =0;i<ss1.length;i++) {
                if((int)ss1[i]>(int)ss2[i])
                    return 1;
                else if((int)ss1[i]<(int)ss2[i])
                    return -1;
            }
            return -1;
        });

        return result;
    }

    public static void main(String[] args) {
        String s = "EMJ";
        getPermutation(s);
    }
}