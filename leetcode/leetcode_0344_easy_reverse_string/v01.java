package leetcode.leetcode_0344_easy_reverse_string;

public class v01 {
    static
    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length / 2; ++i){
                char c = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = c;
            }
        }
    }

    public static void main(String[] argv){
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o', 'o'};
        new Solution().reverseString(s);
        for (int i = 0; i < s.length; ++i){
            System.out.println(s[i]);
        }
    }
}