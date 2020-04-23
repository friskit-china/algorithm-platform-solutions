import java.util.HashMap;

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> mapping = new HashMap<>();
        mapping.put(1000, "M");
        mapping.put(900, "CM");
        mapping.put(500, "D");
        mapping.put(400, "CD");
        mapping.put(100, "C");
        mapping.put(90, "XC");
        mapping.put(50, "L");
        mapping.put(40, "XL");
        mapping.put(10, "X");
        mapping.put(9, "IX");
        mapping.put(5, "V");
        mapping.put(4, "IV");
        mapping.put(1, "I");

        int[] value_list = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int current_curser = 0;
        String result_str = "";
        while (num != 0){
            if (num >= value_list[current_curser]){
                num -= value_list[current_curser];
                result_str += mapping.get(value_list[current_curser]);
            }else{
                current_curser += 1;
            }
        }
        return result_str;
    }
}


public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.intToRoman(3)); // III
        System.out.println(sl.intToRoman(4)); // IV
        System.out.println(sl.intToRoman(9)); // IX
        System.out.println(sl.intToRoman(58)); // LVII
        System.out.println(sl.intToRoman(1994)); // MCMXCIV
    }
}