class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l != r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l += 1;
            }else{
                r -= 1;
            }
        }
        return max;
    }
}

public class leetcode_0011_v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(sl.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6})); // 17
    }
}