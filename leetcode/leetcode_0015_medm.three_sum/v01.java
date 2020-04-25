import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; ++k){
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j){
                if (nums[k] + nums[i] + nums[j] < 0){
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]){
                        i += 1;
                    }
                    i += 1;
                    
                }else if(nums[k] + nums[i] + nums[j] > 0){
                    while (j > 1 && nums[j] == nums[j - 1]){
                        j -= 1;
                    }
                    j -= 1;
                }else if(nums[k] + nums[i] + nums[j] == 0){
                    result.add(Arrays.asList(new Integer[]{nums[k], nums[i], nums[j]}));
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]){
                        i += 1;
                    }
                    while (j > 1 && nums[j] == nums[j - 1]){
                        j -= 1;
                    }
                    i += 1;
                    j -= 1;
                }
            }
            while (k < nums.length - 1 && nums[k] == nums[k + 1]){
                k += 1;
            }
        }

        return result;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {0, 0, 0};
        int[] nums = {1, 1, 1};
        System.out.println(sl.threeSum(nums));
    }

}