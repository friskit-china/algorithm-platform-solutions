#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i){
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }

        int f[nums.size() + 1][sum / 2 + 1];
        f[0][0] = true;
        for (int i = 1; i < sum / 2 + 1; ++i){
            f[0][i] = false;
        }

        for(int i = 1; i < nums.size() + 1; ++i){
            for (int j = 0; j <= sum / 2; ++j){
                f[i][j] = f[i - 1][j] || (nums[i - 1] <= j ? f[i - 1][j - nums[i - 1]] : false);
            }
        }

        return f[nums.size()][sum / 2];
    }
};

int main(){
    Solution sl;
    vector<int> nums = {1,5,11,5};
    cout<<sl.canPartition(nums)<<endl;
    return 0;
}