package leetcode.leetcode_0216_medm_combination_sum_iii;

import java.util.*;

public class v01 {

    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            process(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, n, k, new ArrayList<Integer>());
            return result;
        }

        private void process(int[] digits, int startPos, int target, int space, List<Integer> prefix){
            if (target == 0 && space == 0){
                result.add(new ArrayList<Integer>(prefix));
            }

            if (target < 0 || space < 0){
                return;
            }

            for (int i = startPos; i < digits.length; ++i){
                prefix.add(digits[i]);
                process(digits, i + 1, target - digits[i], space - 1, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] argv){
        var result = new Solution().combinationSum3(3, 9);
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}