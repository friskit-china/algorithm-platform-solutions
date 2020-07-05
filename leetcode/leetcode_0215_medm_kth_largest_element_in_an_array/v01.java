package leetcode.leetcode_0215_medm_kth_largest_element_in_an_array;

public class v01 {
    static 
    class Solution {
        static int partition(int[] nums, int from, int to, int k){ // return: the pivot index
            int pivot = nums[from];
            int p = from - 1;
            int q = from - 1;
            int r = to + 1;
            while (q + 1 < r){
                if (nums[q + 1] == pivot){
                    q += 1;
                }else if (nums[q + 1] < pivot){
                    int t = nums[p + 1];
                    nums[p + 1] = nums[q + 1];
                    nums[q + 1] = t;
                    p += 1;
                    q += 1;
                }else{ // nums[q + 1] > pivot
                    int t = nums[r - 1];
                    nums[r - 1] = nums[q + 1];
                    nums[q + 1] = t;
                    r -= 1;
                }
            }

            if (k >= p + 1 && k <= r - 1){
                return k;
            }else{
                return p + 1;
            }
        }
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int from = 0;
            int to = nums.length - 1;
            
            while(true){
                int nk = partition(nums, from, to, k);
                if (nk < k){
                    from = nk + 1;
                }else if(nk > k){
                    to = nk - 1;
                }else{
                    return nums[k];
                }
            }
        }
    }

    public static void main(String[] argv){
        // System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
    
}