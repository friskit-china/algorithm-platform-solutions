package leetcode.leetcode_0438_medm_find_all_anagrams_in_a_string;

import java.util.*;

public class v01 {
    static
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<Integer>();
            if (s.isEmpty()){
                return result;
            }
            if (p.length() > s.length()){
                return result;
            }

            char[] char_s = s.toCharArray();
            char[] char_p = p.toCharArray();
            int[] dict = new int[26];
            int distance = 0;
            for (int i = 0; i < char_p.length; ++i){
                dict[char_p[i] - 'a'] += 1;
                distance += 1;
            }

            for (int i = 0; i < char_p.length; ++i){
                if (dict[char_s[i] - 'a'] > 0){
                    distance -= 1;
                }else{
                    distance += 1;
                }
                dict[char_s[i] - 'a'] -= 1;
            }

            if (distance == 0){
                result.add(0);
            }

            for (int i = 1; i < char_s.length - char_p.length + 1; ++i){
                if (dict[char_s[i + char_p.length - 1] - 'a'] > 0){
                    distance -= 1;
                }else{
                    distance += 1;
                }
                dict[char_s[i + char_p.length - 1] - 'a'] -= 1;

                if (dict[char_s[i - 1] - 'a'] < 0){
                    distance -= 1;
                }else{
                    distance += 1;
                }
                dict[char_s[i - 1] - 'a'] += 1;

                if (distance == 0){
                    result.add(i);
                }
            }
            
            return result;
        }
    }

    public static void main(String[] argv){
        List<Integer> result = new Solution().findAnagrams("cbaebabacd", "abc");
        for (int i = 0; i < result.size(); ++i){
            System.out.println(result.get(i));
        }
    }
    
}