package leetcode.leetcode_0040_medm_combination_sum_ii;

import java.util.*;

public class v02 {
    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 1 ){
                if (candidates[0] == target){
                    result.add(Arrays.asList(new Integer[]{target}));
                }
                return result;
            }
            
            Arrays.sort(candidates);
            process(candidates, 0, target, new ArrayList<Integer>());
            return result;
        }

        private void process(int[] candidates, int startPosition, int target, List<Integer> prefix){
            if (target == 0){
                result.add(new ArrayList<>(prefix));
                return;
            }

            if (target < 0){
                return;
            }

            if (startPosition >= candidates.length){
                return;
            }

            for (int i = startPosition; i < candidates.length; ++i){
                if (i > startPosition && candidates[i] == candidates[i - 1]){
                    continue;
                }
                prefix.add(candidates[i]);  
                process(candidates, i + 1, target - candidates[i], prefix);
                prefix.remove(prefix.size() - 1);
            }

        }
    }

    public static void main(String[] argv){
        // var result = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        var result = new Solution().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
        // var result = new Solution().combinationSum2(new int[]{1, 2, 2, 2, 5}, 5);
        // var result = new Solution().combinationSum2(new int[]{1, 1, 1, 3, 3, 5}, 8);

        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}