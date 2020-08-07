package leetcode.leetcode_0078_medm_subsets;

import java.util.*;

public class v01 {
    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            for (int i = 0; i <= nums.length; ++i){
                process(nums, 0, new ArrayList<>(), i);
            }
            return result;
        }

        public void process(int[] elements, int startPos, List<Integer> prefix, int size){
            if (prefix.size() == size){
                result.add(new ArrayList<>(prefix));
                return;
            }

            for (int i = startPos; i < elements.length; ++i){
                prefix.add(elements[i]);
                process(elements, i + 1, prefix, size);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] argv){
        var result = new Solution().subsets(new int[]{1, 2, 3});
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}