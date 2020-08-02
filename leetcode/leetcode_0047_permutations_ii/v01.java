package leetcode.leetcode_0047_permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class v01 {
    static
    class Solution {
        private HashSet<List<Integer>> result = new HashSet<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0){
                return result.stream().collect(Collectors.toList());
            }
            
            process(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>());
            return result.stream().collect(Collectors.toList());
        }

        private void process(List<Integer> nums, List<Integer> prefix){
            if (nums.size() != 0){
                for (int i = 0; i < nums.size(); ++i){
                    var newPrefix = new ArrayList<Integer>(prefix);
                    newPrefix.add(nums.get(i));
                    var newNums = new ArrayList<Integer>(nums);
                    newNums.remove(i);
                    process(newNums, newPrefix);
                }
            }else{ // the prefix is the result
                result.add(prefix);
            }
        }
    }



    public static void main(String argv[]){
        var result = new Solution().permuteUnique(new int[]{1, 1, 2});
        for (var i : result){
            for (var j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}