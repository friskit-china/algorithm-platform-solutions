package leetcode.leetcode_0080_medm_remove_duplicates_from_sorted_array_ii;

public class v01 {
    static
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }else if (nums.length == 1){
                return 1;
            }

            int last_num = nums[0];
            int counter = 1;
            int next_position = 1;
            for (int i = 1; i < nums.length; ++i){
                if (nums[i] == last_num){ // current num == prev num
                    counter += 1;
                    if (counter <= 2){ // still have space to store this num
                        nums[next_position] = last_num;
                        next_position += 1;
                    }else{ // more than 2 nums appears

                    }
                }else{ // meets a new num
                    nums[next_position] = nums[i];
                    next_position += 1;
                    last_num = nums[i];
                    counter = 1;
                }
            }
            return next_position;
        }
    }

    public static void main(String[] argv){
        Solution sl = new Solution();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(sl.removeDuplicates(nums));

    }
    
}