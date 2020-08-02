package leetcode.leetcode_0077_medm_combinations;

import java.util.*;

public class v01 {

    static
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {

            process(n, k, 1, new ArrayList<Integer>());
            return result;
        }

        private void process(int n, int k, int start, List<Integer> prefix){
            if (prefix.size() == k){
                result.add(new ArrayList<>(prefix));
                return;
            }

            for (int i = start; i <= n; ++i){
                prefix.add(i);
                process(n, k, i + 1, prefix);
                prefix.remove(prefix.size() - 1);
            }
            
        }
    }

    public static void main(String argv[]){
        var result = new Solution().combine(4, 2);
        for (var i : result){
            for (var j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
    
}