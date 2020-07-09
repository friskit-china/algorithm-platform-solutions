package leetcode.leetcode_0447_easy_number_of_boomerangs;

import java.util.*;

public class v01 {
    static
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int result = 0;
            for (int i = 0; i < points.length; ++i){
                int[] point_i = points[i];
                Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                for (int j = 0; j < points.length; ++j){
                    if (i == j){
                        continue;
                    }
                    int[] point_j = points[j];
                    int d = distance(point_i, point_j);
                    m.put(d, m.getOrDefault(d, 0) + 1);
                }
                for (var item: m.entrySet()){
                    if (item.getValue() >= 2){
                        result += item.getValue() * (item.getValue() - 1);
                    }
                }
            }
            return result;
        }
        private int distance(int[] pointA, int[] pointB){
            return (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
        }        
    }

    public static void main(String[] argv){
        System.out.println(new Solution().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
    
}