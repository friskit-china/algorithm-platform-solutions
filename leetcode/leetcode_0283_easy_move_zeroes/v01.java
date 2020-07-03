package leetcode.leetcode_0283_easy_move_zeroes;

public class v01 {
    static
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 0 || nums.length == 1){
                return;
            }
            for (int i = 0; i < nums.length; ++i){
                if (nums[i] != 0){
                    for (int j = i; j > 0; --j){
                        if (nums[j - 1] == 0){
                            int t = nums[j];
                            nums[j] = nums[j - 1];
                            nums[j - 1] = t;
                        }
                    }
                }
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