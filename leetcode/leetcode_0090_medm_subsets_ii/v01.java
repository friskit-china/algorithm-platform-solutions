package leetcode.leetcode_0090_medm_subsets_ii;

import java.util.*;

public class v01 {
    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<List<Integer>>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length; ++i){
                process(nums, 0, i, new ArrayList<Integer>());
            }
            return result;
        }

        private void process(int[] nums, int startPos, int size, List<Integer> prefix){
            if (prefix.size() == size){        
                result.add(new ArrayList<>(prefix));
                return;
            }

            for (int i = startPos; i < nums.length; ++i){
                if (i > startPos && nums[i] == nums[i - 1]){
                    continue;
                }
                prefix.add(nums[i]);
                process(nums, i + 1, size, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] argv){
        var result = new Solution().subsetsWithDup(new int[]{1, 2, 2});
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}