package leetcode.leetcode_0028_easy_implement_strstr;

// KMP version
public class v02 {
    static
    class Solution {
        class KMP{
            private int[][] dp;
            private String pat;
            public KMP(String pat){
                this.pat = pat;
                int M = pat.length();
                dp = new int[M][256];
                dp[0][pat.charAt(0)] = 1;
                int X = 0;
                for(int j = 1; j < M; ++j){
                    for (int c = 0; c < 256; ++c){
                        if (pat.charAt(j) == c){
                            dp[j][c] = j + 1;
                        }else{
                            dp[j][c] = dp[X][c];
                        }
                    }
                    X = dp[X][pat.charAt(j)];
                }
            }

            public int search(String txt){
                int M = this.pat.length();
                int N = txt.length();
                int j = 0;
                for (int i = 0; i < N; ++i){
                    j = dp[j][txt.charAt(i)];
                    if (j == M) return i - M + 1;
                }
                return -1;
            }
        }
        public int strStr(String haystack, String needle) {
            if (needle.equals("")){
                return 0;
            }
            KMP kmp = new KMP(needle);
            return kmp.search(haystack);
        }
    }

    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.strStr("hello", "ll"));
        System.out.println(sl.strStr("aaaaa", "bba"));
        System.out.println(sl.strStr("a", "a"));
    }
}