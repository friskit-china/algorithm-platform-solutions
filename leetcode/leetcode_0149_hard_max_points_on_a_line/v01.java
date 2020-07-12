package leetcode.leetcode_0149_hard_max_points_on_a_line;

import java.util.*;

public class v01 {
    static
    class Solution {
        private static class Pair<T1, T2>{
            public T1 A;
            public T2 B;

            public Pair(T1 a, T2 b){
                this.A = a;
                this.B = b;
            }

            @Override
            public boolean equals(Object o){
                if (this == o){
                    return true;
                }

                if (o == null | getClass() != o.getClass()){
                    return false;
                }
                @SuppressWarnings("unchecked")
                Pair<T1, T2> pair = (Pair<T1, T2>) o;
                if (A != null ? !A.equals(pair.A) : pair.A != null) return false;
                if (B != null ? !B.equals(pair.B) : pair.B != null) return false;

                return true;
            }

            @Override
            public int hashCode(){
                int result = A != null ? A.hashCode() : 0;
                result = 31 * result + (B != null ? B.hashCode() : 0);
                return result;
            } 
            
        }
        public int maxPoints(int[][] points) {
            if (points.length == 0){
                return 0;
            }

            int max = 0;
            for (int i = 0; i < points.length; ++i){
                Map<Pair<Integer, Integer>, Integer> map = new HashMap<Pair<Integer, Integer>, Integer>();
                int self = 0;
                for (int j = 0; j < points.length; ++j){
                    if (i == j){
                        continue;
                    }
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                        self += 1;
                    }else{
                        Pair<Integer, Integer> key = getK(points[i], points[j]);
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                }
                var iter = map.entrySet().iterator();
                int t = 0;
                while (iter.hasNext()){
                    var item = iter.next();
                    t = Math.max(t, item.getValue());
                }
                max = Math.max(max, t + self);
            }
            return max + 1;
        }

        private Pair<Integer, Integer> getK(int[] pA, int[] pB){
            int dx = pA[0] - pB[0];
            int dy = pA[1] - pB[1];
            int r = gcd(dx, dy);
            if(dx == 0){
                return new Pair<Integer, Integer>(-1, 0);
            }else if (dy == 0){
                return new Pair<Integer, Integer>(0, -1);
            }else{
                return new Pair<Integer, Integer>(dx / r, dy / r);
            }
        }

        private int gcd(int a, int b){
            while (b != 0){
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }
    }


    public static void main(String[] argv){
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}})); //3
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}})); // 4
    }
    
}