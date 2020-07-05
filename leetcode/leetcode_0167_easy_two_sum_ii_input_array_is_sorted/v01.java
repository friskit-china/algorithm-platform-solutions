package leetcode.leetcode_0167_easy_two_sum_ii_input_array_is_sorted;

public class v01 {
    static
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (true){
                if (numbers[i] + numbers[j] < target){
                    i += 1;
                }else if(numbers[i] + numbers[j] > target){
                    j -= 1;
                }else{ //  numbers[i] + numbers[j] == target
                    return new int[]{i + 1, j + 1};
                }
            }
        }
    }
    public static void main(String[] argv){
        int[] result = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}