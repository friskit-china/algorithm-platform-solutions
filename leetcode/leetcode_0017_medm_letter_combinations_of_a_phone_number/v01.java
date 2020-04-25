package leetcode.leetcode_0017_medm_letter_combinations_of_a_phone_number;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result_list = new ArrayList<String>();
        HashMap<Character, List<Character>> digit_mapping = new HashMap<Character, List<Character>>();
        digit_mapping.put('2', Arrays.asList(new Character[]{'a', 'b', 'c'}));
        digit_mapping.put('3', Arrays.asList(new Character[]{'d', 'e', 'f'}));
        digit_mapping.put('4', Arrays.asList(new Character[]{'g', 'h', 'i'}));
        digit_mapping.put('5', Arrays.asList(new Character[]{'j', 'k', 'l'}));
        digit_mapping.put('6', Arrays.asList(new Character[]{'m', 'n', 'o'}));
        digit_mapping.put('7', Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        digit_mapping.put('8', Arrays.asList(new Character[]{'t', 'u', 'v'}));
        digit_mapping.put('9', Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));


        char[] digit_list = digits.toCharArray();
        for (int i = 0; i < digit_list.length; ++i){
            if (result_list.size() == 0){
                var append_list = digit_mapping.get(digit_list[i]);
                for (Character c: append_list){
                    result_list.add("" + c);
                }
            }else{
                var new_result_list = new ArrayList<String>();
                for (String prefix: result_list){
                    var append_list = digit_mapping.get(digit_list[i]);
                    for (Character c: append_list){
                        new_result_list.add(prefix + c);
                    }
                }
                result_list = new_result_list;
            }
        }
        return result_list;
    }
}


public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.letterCombinations("23"));
    }

}