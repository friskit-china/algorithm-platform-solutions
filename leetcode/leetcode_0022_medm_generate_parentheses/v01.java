package leetcode.leetcode_0022_medm_generate_parentheses;

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> f = new ArrayList<List<String>>();
        f.add(Arrays.asList(new String[] {""}));
        // f.add(Arrays.asList(new String[] {"()"}));
        for (int i = 1; i < n + 1; ++i){
            List<String> current_result = new ArrayList<String>();
            for (int j = 0; j < i; ++j){
                List<String> str_left = f.get(j);
                List<String> str_right = f.get(i - j - 1);
                for (String s_left: str_left){
                    for (String s_right: str_right){
                        current_result.add("(" + s_left + ")" + s_right);
                    }
                }
            }
            f.add(current_result);
        }
        return f.get(n);
    }
}

public class v01 {

    public static void main(String[] argv){
        Solution sl = new Solution();
        var result = sl.generateParenthesis(0);
        for (var r : result){
            System.out.println(r);
        }
    }

}