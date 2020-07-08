package leetcode.leetcode_0451_easy_sort_characters_by_frequency;

import java.util.*;

public class v02 {
    static
    class Solution {
        public String frequencySort(String s) {
            var map = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
            maxHeap.addAll(map.keySet());
            StringBuilder res = new StringBuilder();
            while(!maxHeap.isEmpty()){
                char key = maxHeap.poll();
                int value = map.get(key);
                for (int i = 0; i < value; ++i){
                    res.append(key);
                }
            }

            return res.toString();
        }
    }


    public static void main(String[] argv){
        System.out.println(new Solution().frequencySort("tree"));
    }
    
}