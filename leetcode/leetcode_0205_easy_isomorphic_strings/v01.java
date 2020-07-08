package leetcode.leetcode_0205_easy_isomorphic_strings;

import java.util.*;

public class v01 {
    static 
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.equals(t) || (s.length() == 0 && t.length() == 0)){
                return true;
            }

            Map<Character, Character> forward_map = new HashMap<Character, Character>();
            Map<Character, Character> backward_map = new HashMap<Character, Character>();
            char[] s_arr = s.toCharArray();
            char[] t_arr = t.toCharArray();

            for (int i = 0; i < s_arr.length; ++i){
                if (forward_map.containsKey(s_arr[i])){
                    if (forward_map.get(s_arr[i]) != t_arr[i]){
                        return false;
                    }
                }else{
                    forward_map.put(s_arr[i], t_arr[i]);
                }
            }

            for (int i = 0; i < s_arr.length; ++i){
                if (backward_map.containsKey(t_arr[i])){
                    if (backward_map.get(t_arr[i]) != s_arr[i]){
                        return false;
                    }
                }else{
                    backward_map.put(t_arr[i], s_arr[i]);
                }
            }

            return true;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isIsomorphic("egg", "add"));        // true
        System.out.println(new Solution().isIsomorphic("foo", "bar"));        // false
        System.out.println(new Solution().isIsomorphic("paper", "title"));    // true
        System.out.println(new Solution().isIsomorphic("ab", "aa"));    // true
    }
    
}