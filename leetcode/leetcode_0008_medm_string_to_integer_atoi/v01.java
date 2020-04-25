package leetcode.leetcode_0008_medm_string_to_integer_atoi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
class Solution {
    public class FSM{
        private int current_number = 0;
        private int sign = 1;
        private boolean is_overflow = false;
        private boolean is_underflow = false;
        private String current_state = "start";

        private Map<String, Integer> action_mapping_list = Stream.of(new Object[][]{
            {"space", 0},
            {"sign", 1},
            {"number", 2},
            {"other", 3}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        private Map<String, List<String>> state_action_mapping = Stream.of(new Object[][]{
            //                            input:   space     sign     number   other 
            {"start",  Arrays.asList(new String[]{"start", "signed", "number", "end"})},
            {"signed", Arrays.asList(new String[]{"end",   "end",    "number", "end"})},
            {"number", Arrays.asList(new String[]{"end",   "end",    "number", "end"})},
            {"end",    Arrays.asList(new String[]{"end",   "end",    "end",    "end"})}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (List<String>) data[1]));

        public int get_final_result(){
            if(is_overflow){
                return Integer.MAX_VALUE;
            }else if(is_underflow){
                return Integer.MIN_VALUE;
            }
            return current_number * sign;
        }


        public void step(char ch){
            String action;
            if (ch == '+' || ch == '-'){
                action = "sign";
            }else if(Character.isDigit(ch)){
                action = "number";
            }else if(Character.isWhitespace(ch)){
                action = "space";
            }else{
                action = "other";
            }

            // update state
            this.current_state = state_action_mapping.get(current_state).get(this.action_mapping_list.get(action));

            if (this.current_state == "number"){
                int digit = ch - '0';
                if (current_number * sign > Integer.MAX_VALUE / 10 || current_number * sign == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10){
                    this.is_overflow = true;
                    this.current_state = "end";
                }else if (current_number * sign < Integer.MIN_VALUE / 10 || current_number * sign == Integer.MIN_VALUE / 10 && -digit < Integer.MIN_VALUE % 10) {
                    this.is_underflow = true;
                    this.current_state = "end";
                }else{
                    this.current_number = this.current_number * 10 + digit;
                }
            }else if(this.current_state == "signed"){
                this.sign = ch == '+' ? 1 : -1;
            }
        }
    }
    public int myAtoi(String str) {
        var fsm = new FSM();
        var str_char_array= str.toCharArray();
        for (int i = 0; i < str_char_array.length; ++i){
            fsm.step(str_char_array[i]);
        }
        return fsm.get_final_result();
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.myAtoi("4193 with words"));
    }
}