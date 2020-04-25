package leetcode.leetcode_0018_medm_four_sum;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        if (nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; ++k){
            for (int s = k + 1; s < nums.length - 2; ++s){
                int i = s + 1;
                int j = nums.length - 1;
                while (i < j){
                    int sum = nums[k] + nums[s] + nums[i] + nums[j];
                    if (sum == target){
                        result.add(Arrays.asList(new Integer[]{nums[k], nums[s], nums[i], nums[j]}));
                        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i += 1;
                        i += 1;
                        while (j > 1 && nums[j] == nums[j - 1]) j -= 1;
                        j -= 1;
                        
                    }else if (sum < target){
                        while (i < nums.length - 1 &&nums[i] == nums[i + 1]) i += 1;
                        i += 1;
                    }else if (sum > target){
                        while (j > 1 && nums[j] == nums[j - 1]) j -= 1;
                        j -= 1;
                    }
                }
                while (s < nums.length - 2 && nums[s] == nums[s + 1]) s += 1;
            }
            while (k < nums.length - 3 && nums[k] == nums[k + 1]) k += 1;
        }
        return result;
    }
}


public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        // System.out.println(sl.fourSum(new int[] {0, 0, 0, 0}, 1));
    }

}