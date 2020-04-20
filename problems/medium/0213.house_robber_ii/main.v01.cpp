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

        int f_keep[nums.size() + 1];
        int f_drop[nums.size() + 1];

        f_keep[0] = 0;
        f_keep[1] = nums[0];

        f_drop[0] = 0;
        f_drop[1] = 0;

        for (int i = 2; i < nums.size() + 1; ++i){
            if (i != nums.size()){
                f_keep[i] = max(f_keep[i - 1], f_keep[i - 2] + nums[i - 1]);
            }else{
                f_keep[i] = f_keep[i - 1];
            }
            f_drop[i] = max(f_drop[i - 1], f_drop[i - 2] + nums[i - 1]);
        }
        return max(f_keep[nums.size()], f_drop[nums.size()]);
    }
};

int main(){
    Solution sl;
    // vector<int> nums = {2, 3, 2};  // 3
    vector<int> nums = {1, 2, 3, 1}; // 4

    cout<<sl.rob(nums)<<endl;
    return 0;
}