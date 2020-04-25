package leetcode.leetcode_0026_easy_remove_duplicates_from_sorted_array;

// O(n)
public class v02 {
    static
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }else if(nums.length == 1){
                return 1;
            }
            
            int p = 0, q = 0;
            while (q < nums.length){
                if(nums[p] == nums[q]){
                    q += 1;
                }else{
                    p += 1;
    
                    int t = nums[p];
                    nums[p] = nums[q];
                    nums[q] = t;
                    q += 1;
    
                }
            }
            return p + 1;
        }
    }
    
    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

}