package leetcode.leetcode_0028_easy_implement_strstr;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystack_char_array = haystack.toCharArray();
        char[] needle_char_array = needle.toCharArray();
        if (needle_char_array.length > haystack_char_array.length){
            return -1;
        }

        if (needle.equals("")){
            return 0;
        }

        for (int i = 0; i <= haystack_char_array.length - needle_char_array.length; ++i){
            if (haystack_char_array[i] == needle_char_array[0]){
                boolean result = true;
                for (int j = 0; j < needle_char_array.length; ++j){
                    if (haystack_char_array[i + j] != needle_char_array[j]){
                        result = false;
                        break;
                    }
                }
                if(result == true){
                    return i;
                }
            }
        }
        return -1;
    }   
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        // System.out.println(sl.strStr("hello", "ll"));
        // System.out.println(sl.strStr("aaaaa", "bba"));
        System.out.println(sl.strStr("", ""));
    }

}