package leetcode.leetcode_0350_easy_intersection_of_two_arrays_ii;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums1.length; ++i){
                int num = nums1[i];
                if (!m1.containsKey(num)){
                    m1.put(num, 1);
                }else{
                    m1.put(num, m1.get(num) + 1);
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0 ; i < nums2.length; ++i){
                int num = nums2[i];
                if (m1.containsKey(num) && m1.get(num) >0){
                    result.add(num);
                    m1.put(num, m1.get(num) - 1);
                }
            }

            int[] r = new int[result.size()];
            for (int i = 0; i < r.length; ++i){
                r[i] = result.get(i);
            }
            return r;
        }
    }

    public static void main(String[] argv){
        int[] result = new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0 ; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
    
}