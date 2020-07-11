package leetcode.leetcode_0220_medm_contains_duplicate_iii;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k == 0){
                return false;
            }

            TreeSet<Long> set = new TreeSet<>();
            int l = 0;
            int r = 0;
            while (r < nums.length){
                if (set.ceiling((long)nums[r] - (long)t) != null && set.ceiling((long)nums[r] - (long)t) <= (long)nums[r] + (long)t){
                    return true;
                }
                if (r - l < k){
                    set.add((long)nums[r]);
                    r += 1;
                }else{
                    set.remove((long)nums[l]);
                    l += 1;
                }
            }

            return false;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));  // true
    }
    
}