package leetcode.leetcode_0345_easy_reverse_vowels_of_a_string;

public class v01 {
    static
    class Solution {
        public String reverseVowels(String s) {
            char[] char_array = s.toCharArray();
            int l = 0;
            int r = char_array.length - 1;
            while (l <= r){
                if (!is_vowel(char_array[l])){
                    l += 1;
                    continue;
                }
                if (!is_vowel(char_array[r])){
                    r -= 1;
                    continue;
                }

                char t = char_array[l];
                char_array[l] = char_array[r];
                char_array[r] = t;
                l += 1;
                r -= 1;
            }
            return String.valueOf(char_array);
        }

        private boolean is_vowel(char c){
            if (c != 'a' && c !='e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] argv){
        System.out.println(new Solution().reverseVowels("hello"));
    }
    
}