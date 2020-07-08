package leetcode.leetcode_0202_easy_happy_number;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> s = new HashSet<Integer>();
            int number = n;
            while (true){
                int new_sum = 0;
                while (number != 0){
                    int remainder = number % 10;
                    new_sum += remainder * remainder;
                    number /= 10;
                }
                if (new_sum == 1){
                    return true;
                }
                if (s.contains(new_sum)){
                    return false;
                }else{
                    s.add(new_sum);
                }
                number = new_sum;
            }
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isHappy(19));
    }
    
}