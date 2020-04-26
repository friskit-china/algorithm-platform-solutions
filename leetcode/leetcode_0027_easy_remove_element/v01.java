package leetcode.leetcode_0027_easy_remove_element;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j){
            if (nums[j] != val){
                nums[i] = nums[j];
                i += 1;
            }
        }
        return i;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}