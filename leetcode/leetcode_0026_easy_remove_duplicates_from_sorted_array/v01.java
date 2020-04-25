package leetcode.leetcode_0026_easy_remove_duplicates_from_sorted_array;

//O(n^2)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return 1;
        }
        int size = nums.length;
        int counter = 0;
        for (int i = 1; i < size - counter; ++i){
            if (nums[i - 1] == nums[i]){
                for (int j = i; j < size - 1; ++j){
                    nums[j] = nums[j + 1];
                }
                counter += 1;
                i -= 1;
            }
        }
        return size - counter;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

}