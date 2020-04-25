#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }else if (nums.size() == 1){
            return nums[0];
        }else if (nums.size() == 2){
            return max(nums[0], nums[1]);
        }
        
        int result[nums.size() + 1];
        result[0] = 0;
        result[1] = nums[0];
        result[2] = max(nums[0], nums[1]);
        for (int i = 3; i < nums.size() + 1; ++i){
            result[i] = max(result[i - 1], result[i - 2] + nums[i - 1]);
        }
        return result[nums.size()];
    }
};

int main(){
    Solution sl;
    // vector<int> nums = {1, 2, 3, 1}; // 4
    vector<int> nums = {2, 7, 9, 3, 1}; // 12
    cout<<sl.rob(nums)<<endl;
    return 0;
}