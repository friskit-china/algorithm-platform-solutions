package leetcode.leetcode_0017_medm_letter_combinations_of_a_phone_number;


import java.util.*;

public class v02 {

    static
    class Solution {
        String[] mapping = new String[]{
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz", //9
        };

        private List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0){
                return result;
            }

            char[] digitsCharArray = digits.toCharArray();
            process(digitsCharArray, 0, "");
            return result;
        }

        public void process(char[] digits, int index, String prefix){

            if (index == digits.length){
                result.add(prefix);
                return;
            }

            var mappingStr = mapping[Integer.parseInt(digits[index] + "")];
            for (var c : mappingStr.toCharArray()){
                process(digits, index + 1, prefix + c);
            }
            return;
        }
    }


    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.letterCombinations("23"));
    }
    
}