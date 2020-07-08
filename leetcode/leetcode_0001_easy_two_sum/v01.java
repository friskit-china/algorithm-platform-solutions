package leetcode.leetcode_0001_easy_two_sum;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i){
                if (map.containsKey(target - nums[i])){
                    return new int[]{i, map.get(target - nums[i])};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{0, 0};
        }
    }

    public static void main(String[] argv){
        for (var i: new Solution().twoSum(new int[]{3, 2, 4}, 6)){
            System.out.println(i);
        }
    }
    
    
}