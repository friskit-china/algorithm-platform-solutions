package leetcode.leetcode_0290_easy_word_pattern;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            Map<Character, String> forward_map = new HashMap<Character, String>();
            Map<String, Character> backward_map = new HashMap<String, Character>();

            String[] str_list = str.split(" ");
            char[] pattern_list = pattern.toCharArray();

            if (str_list.length != pattern_list.length){
                return false;
            }
            
            for (int i = 0; i < pattern_list.length; ++i){
                char pattern_i = pattern_list[i];
                String str_i = str_list[i];
                if(forward_map.containsKey(pattern_i)){
                    if (!forward_map.get(pattern_i).equals(str_i)){
                        return false;
                    }
                }else{
                    forward_map.put(pattern_i, str_i);
                }

                if (backward_map.containsKey(str_i)){
                    if (!backward_map.get(str_i).equals(pattern_i)){
                        return false;
                    }
                }else{
                    backward_map.put(str_i, pattern_i);
                }
            }
            return true;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));  // false
    }
    
}