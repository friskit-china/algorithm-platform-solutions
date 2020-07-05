package leetcode.leetcode_0076_hard_minimum_window_substring;

import java.util.*;

public class v01 {
    static
    class Solution {
        public String minWindow(String s, String t) {
            int result_left_ptr = -1;
            int result_right_ptr = -1;
            int min_length = Integer.MAX_VALUE;

            Map<Character, Integer> dict = new HashMap<Character, Integer>();
            int distance = 0;
            

            int left_ptr = 0;
            int right_ptr = -1;

            char[] char_s = s.toCharArray();
            char[] char_t = t.toCharArray();

            for (int i = 0; i < char_t.length; ++i){
                char c = char_t[i];
                if (!dict.containsKey(c)){
                    dict.put(c, 0);
                }
                dict.put(c, dict.get(c) - 1);
                distance += 1;
            }

            while (right_ptr < char_s.length){
                if (distance != 0){ // put new char on the right
                    right_ptr += 1;
                    if (right_ptr >= char_s.length){
                        break;
                    }
                    char c = char_s[right_ptr];
                    if (dict.containsKey(c)){
                        if (dict.get(c) < 0){ // distance - 1 if not > threshold
                            distance -= 1;
                        }
                        dict.put(c, dict.get(c) + 1);
                        
                    }
                }else{ // remove new char from the left
                    // save current status first
                    int current_length = right_ptr - left_ptr + 1;
                    if (current_length < min_length){
                        min_length = current_length;
                        result_left_ptr = left_ptr;
                        result_right_ptr = right_ptr;
                    }

                    char c = char_s[left_ptr];
                    if (dict.containsKey(c)){
                        dict.put(c, dict.get(c) - 1);
                        if (dict.get(c) < 0){
                            distance += 1;
                        }
                    }
                    left_ptr += 1;
                }
            }
            

            if (min_length == Integer.MAX_VALUE){
                return "";
            }else{
                char[] new_char = new char[min_length];
                int idx = 0;
                for (int i = result_left_ptr; i <= result_right_ptr; ++i){
                    new_char[idx] = char_s[i];
                    idx += 1;
                }
                return String.valueOf(new_char);
            }
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        // System.out.println(new Solution().minWindow("babb", "baba"));
    }
    
}