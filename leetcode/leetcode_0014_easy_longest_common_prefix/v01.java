package leetcode.leetcode_0014_easy_longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String result_str = "";
        int current_idx = 0;
        while (true){
            String current_p = null;
            for (String s : strs){
                if (current_idx == s.length()){
                    return result_str;
                }
                if (current_p == null){
                    current_p = "" + s.charAt(current_idx);
                }
                if (!current_p.equals("" + s.charAt(current_idx))){
                    return result_str;
                }
            }
            result_str += current_p;
            current_idx += 1;
        }
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        // String[] strs = {"flower", "flow", "flight"}; // "fl"
        String[] strs = {"dog", "racecar", "car"}; // ""
        System.out.println(sl.longestCommonPrefix(strs));
    }

}