package leetcode.leetcode_0242_easy_valid_anagram;

import java.util.*;

public class v01 {
    static
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> m = new HashMap<Character, Integer>();
            char[] char_s = s.toCharArray();
            char[] char_t = t.toCharArray();
            for (int i = 0 ; i < char_s.length; ++i){
                if (m.containsKey(char_s[i])){
                    m.put(char_s[i], m.get(char_s[i]) + 1);
                }else{
                    m.put(char_s[i], 1);
                }
            }

            for (int i = 0; i < char_t.length; ++i){
                if (m.containsKey(char_t[i])){
                    if (m.get(char_t[i]) <= 0){
                        return false;
                    }else{
                        m.put(char_t[i], m.get(char_t[i]) - 1);
                    }
                }else{
                    return false;
                }
            }

            Iterator<Character> r = m.keySet().iterator();
            while(r.hasNext()){
                if (m.get(r.next()) != 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
    
}