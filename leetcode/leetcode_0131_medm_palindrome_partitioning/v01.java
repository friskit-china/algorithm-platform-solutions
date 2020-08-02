package leetcode.leetcode_0131_medm_palindrome_partitioning;


import java.util.*;

public class v01 {
    static
    class Solution {
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.length() == 0){
                return result;
            }

            process(s, 0, new ArrayList<>());
            return result;
        }

        private void process(String str, int startIndex, List<String> prefix){
            if (startIndex == str.length()){ // prefix are all palindrome
                // store the result
                result.add(prefix);
            }else{
                for (int i = startIndex; i < str.length(); ++i){
                    String subStr = str.substring(startIndex, i + 1);
                    if (isPalindrome(subStr)){
                        var newPrefix = new ArrayList<String>(prefix);
                        newPrefix.add(subStr);
                        process(str, i + 1, newPrefix);
                    }
                }
            }
        }

        private boolean isPalindrome(String str){
            if (str == null || str.length() == 0){
                return false;
            }
            if (str.length() == 1){
                return true;
            }

            char[] sc = str.toCharArray();

            int i = 0;
            int j = sc.length - 1;
            while (i <= j){
                if (sc[i] != sc[j]){
                    return false;
                }
                i += 1;
                j -= 1;
            }

            return true;
        }
    }


    public static void main(String[] argv){
        var result = new Solution().partition("aab");
        for (var i : result){
            for (var j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
    
}