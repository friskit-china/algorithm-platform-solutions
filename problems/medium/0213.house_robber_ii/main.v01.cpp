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

        int result_true[nums.size() + 1];
        int result_false[nums.size() + 1];

        result_true[0] = 0;
        result_true[1] = nums[0];
        result_true[2] = nums[0];

        result_false[0] = 0;
        result_false[1] = 0;
        result_false[2] = nums[1];
        
        for (int i = 3; i < nums.size() + 1; ++i){
            if (i != nums.size()){
                result_true[i] = max(result_true[i - 1], result_true[i - 2] + nums[i - 1]);
                result_false[i] = max(result_false[i - 1], result_false[i - 2] + nums[i - 1]);
            }else{
                result_true[i] = result_true[i - 1];
                result_false[i] = max(result_false[i - 1], result_false[i - 2] + nums[i - 1]);
            }
        }
        return max(result_true[nums.size()], result_false[nums.size()]);
    }  
};

int main(){
    Solution sl;
    // vector<int> nums = {2, 3, 2};  // 3
    vector<int> nums = {1, 2, 3, 1}; // 4

    cout<<sl.rob(nums)<<endl;
    return 0;
}