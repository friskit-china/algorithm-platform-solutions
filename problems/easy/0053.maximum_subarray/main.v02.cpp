// https://leetcode-cn.com/problems/maximum-subarray/
#include <iostream>
#include <vector>
#include <limits>
using namespace std;

// submit start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int m = nums[0];
        for (int i = 1; i < nums.size(); ++i){
            nums[i] = max(nums[i], nums[i - 1] + nums[i]);
            m = max(m, nums[i]);
        }
        return m;
    }
};
// submit end

int main(){
    Solution sl;
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6
    cout<<sl.maxSubArray(nums)<<endl;
    return 0;
}