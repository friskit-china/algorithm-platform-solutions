package leetcode.leetcode_0039_medm_combination_sum;

import java.util.*;

public class v01 {
    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<List<Integer>>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            process(candidates, target, new ArrayList<Integer>());
            return result;
        }

        private void process(int[] candidates, int target, List<Integer> selected){
            if (selected.size() >= 2 && selected.get(selected.size() - 1) < selected.get(selected.size() - 2)){
                return;
            }
            if (target < 0){
                return; 
            }
            if (target == 0){
                result.add(new ArrayList<>(selected));
                return;
            }

            // else > 0
            for (int i = 0; i < candidates.length; ++i){
                selected.add(candidates[i]);
                process(candidates, target - candidates[i], selected);
                selected.remove(selected.size() - 1);
            }
        }  
    }


    public static void main(String[] argv){
        var result = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}