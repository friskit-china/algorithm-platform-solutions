package leetcode.leetcode_0283_easy_move_zeroes;

import java.util.LinkedList;
import java.util.List;

public class v02 {
    static
    class Solution {
        public void moveZeroes(int[] nums) {
            List<Integer> non_zeros = new LinkedList<Integer>();
            int zero_count = 0;
            for (int i = 0; i < nums.length; ++i){
                if (nums[i] == 0){
                    zero_count += 1;
                }else{
                    non_zeros.add(nums[i]);
                }
            }
            int counter = 0;

            for (int i = 0; i < non_zeros.size(); ++i){
                nums[counter++] = non_zeros.get(i);
            }
            for (int i = 0; i < zero_count; ++i){
                nums[counter ++] = 0;
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