package leetcode.leetcode_0049_medm_group_anagrams;

import java.util.*;

public class v01 {
    static
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            for (var str: strs){
                var str_arr = str.toCharArray();
                Arrays.sort(str_arr);
                var sb = new StringBuilder();
                sb.append(str_arr);
                var key = sb.toString();
                // var value_list = map.getOrDefault(key, new ArrayList<String>());
                // value_list.add(str);
                // map.put(key, value_list);

                // for java 8 and later
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }

            List<List<String>> result = new ArrayList<List<String>>();
            for (var item: map.entrySet()){
                List<String> t = new ArrayList<String>();
                for (var str: item.getValue()){
                    t.add(str);
                }
                result.add(t);
            }
            return result;
        }
    }

    public static void main(String[] argv){
        var result = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (var row: result){
            for (var column: row){
                System.out.print(column + " ");
            }
            System.out.println("");
        }
    }
}