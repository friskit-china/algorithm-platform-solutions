package leetcode.leetcode_0020_easy_valid_parentheses;

import java.util.ArrayList;

class Solution {
    public boolean isValid(String s) {
        char[] str_char_array = s.toCharArray();
        ArrayList<Character> stack = new ArrayList<Character>();
        for (char ch: str_char_array){
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.add(ch);
            }else  if (ch == ')'){
                if (stack.size() != 0 && stack.get(stack.size() - 1) == '('){
                    stack.remove(stack.size() - 1);
                }else{
                    return false;
                }
            }else  if (ch == ']'){
                if (stack.size() != 0 && stack.get(stack.size() - 1) == '['){
                    stack.remove(stack.size() - 1);
                }else{
                    return false;
                }
            }else  if (ch == '}'){
                if (stack.size() != 0 && stack.get(stack.size() - 1) == '{'){
                    stack.remove(stack.size() - 1);
                }else{
                    return false;
                }
            }else if(ch == ' '){
                continue;
            }else{
                return false;
            }
        }
        if (stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.isValid("{()} "));
    }

}