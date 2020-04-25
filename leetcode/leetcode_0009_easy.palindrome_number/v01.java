class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }

        int invert = 0;
        int ori = x;
        while(ori != 0){
            invert = invert * 10 + ori % 10;
            ori = ori / 10;
        }
        return invert == x;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.isPalindrome(121)); // true
        System.out.println(sl.isPalindrome(-121)); // false
        System.out.println(sl.isPalindrome(10)); // false
    }
}