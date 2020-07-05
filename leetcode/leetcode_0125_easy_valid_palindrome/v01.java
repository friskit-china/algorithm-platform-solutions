package leetcode.leetcode_0125_easy_valid_palindrome;

public class v01 {
    static
    class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i <= j){

                if (!Character.isLetterOrDigit(chars[i])){
                    i += 1;
                    continue;
                }

                if (!Character.isLetterOrDigit(chars[j])){
                    j -= 1;
                    continue;
                }

                if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])){
                    i += 1;
                    j -= 1;
                }else{
                    return false;    
                }
            }
            return true;
        }
    }


    public static void main(String[] argv){
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }
    
}