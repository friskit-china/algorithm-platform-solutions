package leetcode.leetcode_0349_easy_intersection_of_two_arrays;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> s1 = new HashSet<Integer>();
            HashSet<Integer> s2 = new HashSet<Integer>();

            for (int i = 0; i < nums1.length; ++i){
                s1.add(nums1[i]);
            }

            for (int i = 0; i < nums2.length; ++i){
                s2.add(nums2[i]);
            }

            s1.retainAll(s2);

            int[] result = new int[s1.size()];
            Iterator<Integer> iter = s1.iterator();
            int i = 0;
            while (iter.hasNext()){
                result[i++] = iter.next().intValue();
            }
            return result;
        }
    }

    public static void main(String[] argv){
        int[] result = new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0 ; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
    
}