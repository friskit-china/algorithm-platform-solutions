package leetcode.leetcode_0088_easy_merge_sorted_array;

public class v01 {
    static
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p = m + n - 1;
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 && j >= 0){
                if (nums1[i] > nums2[j]){
                    nums1[p] = nums1[i];
                    i -= 1;
                }else{
                    nums1[p] = nums2[j];
                    j -= 1;
                }
                p -= 1;
            }
            for (int k = i; k >= 0; --k, --p){
                nums1[p] = nums1[k];
            }

            for (int k = j; k >= 0; --k, --p){
                nums1[p] = nums2[k];
            }
        }
    }
    public static void main(String[] argv){
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        new Solution().merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; ++i){
            System.out.println(nums1[i]);
        }
    }
    
}