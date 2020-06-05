package leetcode.leetcode_0048_medm_rotate_image;

public class v01 {
    static
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix.length == 1){
                return;
            }
            for (int i = 0; i < matrix.length; ++i){
                for (int j = i + 1; j < matrix[0].length; ++j){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }

            for (int r = 0; r < matrix.length; ++r){
                int i = 0, j = matrix[r].length - 1;
                while (i < j){
                    int t = matrix[r][i];
                    matrix[r][i] = matrix[r][j];
                    matrix[r][j] = t;
                    i+=1;
                    j-=1;
                }
            }
        }
    }
    public static void main(String[] argv){
        Solution sl = new Solution();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        sl.rotate(matrix);
        for (int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}