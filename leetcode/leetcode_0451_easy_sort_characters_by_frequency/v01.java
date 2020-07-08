package leetcode.leetcode_0451_easy_sort_characters_by_frequency;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Map.Entry;

public class v01 {
    static
    class Solution {
        public String frequencySort(String s) {
            char[] s_arr = s.toCharArray();
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < s_arr.length; ++i){
                if (map.containsKey(s_arr[i])){
                    map.put(s_arr[i], map.get(s_arr[i]) + 1);
                }else{
                    map.put(s_arr[i], 1);
                }
            }

            String result_str = "";
            List<Map.Entry<Character, Integer>> sorted = map
                .entrySet()
                .stream()
                .sorted(
                    Collections.reverseOrder(Map.Entry.comparingByValue())
                )
                .collect(Collectors.toList());

            // Iterator<Entry<Character, Integer>> iter = sorted.iterator();
            for(Entry<Character, Integer> item: sorted){
                for (int i = 0; i < item.getValue(); ++i){
                    result_str += item.getKey();
                }
            }
            
            return result_str;
        }
    }


    public static void main(String[] argv){
        System.out.println(new Solution().frequencySort("tree"));
    }
    
}