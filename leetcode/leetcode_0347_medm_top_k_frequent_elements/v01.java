package leetcode.leetcode_0347_medm_top_k_frequent_elements;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> stat = new HashMap<>();
            stat.entrySet();
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> p, Map.Entry<Integer, Integer> q){
                    return p.getValue() - q.getValue();
                }
            });
            for (var i : nums){
                stat.put(i, stat.getOrDefault(i, 0) + 1);
            }

            for (var entry: stat.entrySet()){
                pq.add(entry);
                if (pq.size() > k){
                    pq.poll();
                }
            }
            
            int[] result = new int[pq.size()];
            for (int i = 0; i < result.length; ++i){
                result[i] = pq.poll().getKey();
            }
            return result;
        }
    }

    public static void main(String[] argv){
        // for (var i : new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)){
        //     System.out.println(i);
        // }

        for (var i : new Solution().topKFrequent(new int[]{1}, 1)){
            System.out.println(i);
        }
    }
    
}