package leetcode.leetcode_0016_medm_three_sum_closest;

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; ++k){
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j){
                if (Math.abs(nums[k] + nums[i] + nums[j] - target) < closest){
                    closest = Math.abs(nums[k] + nums[i] + nums[j] - target);
                    sum = nums[k] + nums[i] + nums[j];
                }
                if (nums[k] + nums[i] + nums[j] - target < 0){
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]){
                        i += 1;
                    }
                    i += 1;
                }else if(nums[k] + nums[i] + nums[j] - target > 0){
                    while (j > 1 && nums[j] == nums[j - 1]){
                        j -= 1;
                    }
                    j -= 1;
                }else if(nums[k] + nums[i] + nums[j] - target == 0){
                    return target;
                }
            }
            while (k < nums.length - 1 && nums[k] == nums[k + 1]){
                k += 1;
            }    
        }
        return sum;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();

        // int[] nums = {-1, 2, 1, -4};
        // int target = 1;

        int[] nums = {0,0,0};
        int target = 1;

        // int[] nums = {1, 1, 1, 0};
        // int target = -100;
        System.out.println(sl.threeSumClosest(nums, target));
    }

}