package leetcode.leetcode_0209_medm_minimum_size_subarray_sum;

public class v01 {
    static
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int l = 0;
            int r = -1;
            int sum = 0;
            int current_min = Integer.MAX_VALUE;
            while (l < nums.length){
                if (r + 1 < nums.length && sum < s ){
                    r += 1;
                    sum += nums[r];
                }else{
                    sum -= nums[l];
                    l += 1;
                }
                if (sum >= s){
                    current_min = Integer.min(current_min, r - l + 1);
                }
            }
            if (current_min == Integer.MAX_VALUE){
                return 0;
            }
            return current_min;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
    
}