package leetcode.leetcode_0040_medm_combination_sum_ii;

import java.util.*;

public class v01 {
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

            // target > 0;
            for (int i = startPosition; i < candidates.length;){
                int currentNum = candidates[i];
                int j = i;
                while (j < candidates.length && candidates[j] == currentNum){
                    j += 1;
                }
                j -= 1;

                for (int a = i; a <= j; ++a){
                    for (int b = 1; b <= j - a + 1; ++b){
                        prefix.add(candidates[i]);
                    }
                    process(candidates, j + 1, target - (j - a + 1) * candidates[j], prefix);
                    for (int b = 1; b <= j - a + 1; ++b){
                        prefix.remove(prefix.size() - 1);
                    }
                }
                i = j + 1;
            }
        }
    }

    public static void main(String[] argv){
        // var result = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        // var result = new Solution().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
        var result = new Solution().combinationSum2(new int[]{1, 2, 2, 2, 5}, 5);
        // var result = new Solution().combinationSum2(new int[]{1, 1, 1, 3, 3, 5}, 8);

        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}