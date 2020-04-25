package leetcode.leetcode_0013_easy_roman_to_integer;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> value_map = new HashMap<Character, Integer>();
        char[] s_list = s.toCharArray();
        value_map.put('I', 1);
        value_map.put('V', 5);
        value_map.put('X', 10);
        value_map.put('L', 50);
        value_map.put('C', 100);
        value_map.put('D', 500);
        value_map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; ++i){
            if (value_map.get(s_list[i]) >= value_map.get(s_list[i + 1])){
                result += value_map.get(s_list[i]);
            }else{
                result -= value_map.get(s_list[i]);
            }
        }
        result += value_map.get(s_list[s.length() - 1]);
        return result;
    }
}

public class v01{
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.romanToInt("III")); // 3
        System.out.println(sl.romanToInt("IV")); // 4
        System.out.println(sl.romanToInt("IX")); // 9
        System.out.println(sl.romanToInt("LVIII")); // 58
        System.out.println(sl.romanToInt("MCMXCIV")); // 1994
    }
}