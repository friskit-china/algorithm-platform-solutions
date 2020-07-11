package leetcode.leetcode_0219_easy_contains_duplicate_ii;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k == 0){
                return false;
            }
            
            Set<Integer> set = new HashSet<>();
            int l = 0;
            int r = 0;
            while (r < nums.length){
                if (set.contains(nums[r])){
                    return true;
                }
                if (r - l < k){
                    set.add(nums[r]);
                    r += 1;
                }else{
                    set.remove(nums[l]);
                    l += 1;
                }
            }

            return false;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));   // true
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));      // true
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));  // false
    }
    
}