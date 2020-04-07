#include <iostream>
#include <vector>
using namespace std;

// DP
class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }
        int result[nums.size()];
        for (int i = 0; i < nums.size(); ++i){
            result[i] = 1;
            if (i > 0 && nums[i] > nums[i - 1]){
                result[i] = max(result[i], result[i - 1] + 1);
            }
        }
        int m = 0;
        for (int i = 0; i < nums.size(); ++i){
            m = max(m, result[i]);
        }
        return m;
    }
};

int main(){
    Solution sl;
    vector<int> nums = {1,3,5,4,7};
    cout<<sl.findLengthOfLCIS(nums)<<endl;
    return 0;
}