package leetcode.leetcode_0075_medm_sort_colors;

public class v01 {
    static
    class Solution {
        public void sortColors(int[] nums) {
            int p = -1;
            int q = -1;
            int r = nums.length;
            while (q + 1 < r){
                if (nums[q + 1] == 0){
                    int t = nums[p + 1];
                    nums[p + 1] = nums[q + 1];
                    nums[q + 1] = t;
                    q += 1;
                    p += 1;
                }else if(nums[q + 1] == 1){
                    q += 1;
                }else{ // == 2
                    int t = nums[r - 1];
                    nums[r - 1] = nums[q + 1];
                    nums[q + 1] = t;
                    r -= 1;
                }
            }
        }
    }

    public static void main(String[] argv){
        int[] nums = new int[]{0, 1, 0};
        new Solution().sortColors(nums);
        for (int i = 0; i < nums.length; ++i){
            System.out.println(nums[i]);
        }
    }
    
}