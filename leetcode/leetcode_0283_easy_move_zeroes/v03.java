package leetcode.leetcode_0283_easy_move_zeroes;

public class v03 {
    static
    class Solution {
        public void moveZeroes(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; ++i){
                if (nums[i] != 0){
                    nums[k++] = nums[i];
                }
            }
            for (; k < nums.length; ++k){
                nums[k] = 0;
            }
        }
    }
    public static void main(String[] argv){
        Solution sl = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        sl.moveZeroes(nums);
        for (int i = 0; i < nums.length; ++i){
            System.out.println(nums[i]);
        }
    }
    
}