package leetcode.leetcode_0217_easy_contains_duplicate;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i: nums){
                if (set.contains(i)){
                    return true;
                }
                set.add(i);
            }
            return false;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().containsDuplicate(new int[]{1, 2, 3, 1}));    // true
        System.out.println(new Solution().containsDuplicate(new int[]{1, 2, 3, 4}));    // false
        System.out.println(new Solution().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));    // true
    }
    
}