package strings;

import java.util.ArrayList;
import java.util.List;

public class Joseph {
    public static int getResult(int n, int m) {
        // write code here
        List<Integer> list = new ArrayList<>();
        int i=1;
        while(i<=n) {
            list.add(i);
            i++;
        }
        int index =0;
        while(list.size()>1) {
            int l = list.size();
            int c = (m-1+index)%l;
            list.remove(c);
            index = c;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(getResult(5,3));
    }
}
