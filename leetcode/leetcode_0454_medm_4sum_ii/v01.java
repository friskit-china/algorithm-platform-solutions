package leetcode.leetcode_0454_medm_4sum_ii;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int result = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < C.length; ++i){
                for (int j = 0; j < D.length; ++j){
                    m.put(C[i] + D[j], m.getOrDefault(C[i] + D[j], 0) + 1);
                }
            }

            for (int i = 0; i < A.length; ++i){
                for (int j = 0; j < B.length; ++j){
                    result += m.getOrDefault(-(A[i] + B[j]), 0);
                }
            }
            return result;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    
}