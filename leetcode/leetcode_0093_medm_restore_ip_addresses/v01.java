package leetcode.leetcode_0093_medm_restore_ip_addresses;

import java.util.*;

public class v01 {

    static
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            process(s, 3, "");
            return result;
        }

        public void process(String str, int dotCount, String prefix){
            if (dotCount == 0){
                if (str.length() > 3){
                    return;
                }
                int currentInt = Integer.parseInt(str);
                if (currentInt >=0 && currentInt <= 255 && (currentInt + "").length() == str.length()){
                    result.add(prefix + str);
                }
            }else{
                for (int i = 0; i < str.length() - 1; ++i){ // a str with l chars, l-1 point positions
                    String subStr = str.substring(0, i + 1);
                    if (subStr.length() > 3){
                        break;
                    }
                    int currentInt = Integer.parseInt(subStr);
                    if (currentInt >= 0 && currentInt <= 255  && (currentInt + "").length() == subStr.length()){ // a valid ip segment
                        process(str.substring(i + 1), dotCount - 1, prefix + subStr + ".");
                    }else{ // cut 
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] argv){
        for (var i : new Solution().restoreIpAddresses("25525511135")){
            System.out.println(i);
        }
    }
    
}