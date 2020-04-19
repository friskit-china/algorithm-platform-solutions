// https://leetcode-cn.com/problems/maximum-subarray/
#include <iostream>
#include <vector>
#include <limits>
using namespace std;

// submit start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum_max = nums[0];
        int sum_cur = nums[0];
        for (int i = 1; i < nums.size(); i += 1){
            if (sum_cur > 0){
                sum_cur += nums[i];
            }else{
                sum_cur = nums[i];
            }
            sum_max = max(sum_max, sum_cur);
        }
        return sum_max;
    }
};
// submit end

int main(){
    Solution sl;
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout<<sl.maxSubArray(nums)<<endl;
    return 0;
}