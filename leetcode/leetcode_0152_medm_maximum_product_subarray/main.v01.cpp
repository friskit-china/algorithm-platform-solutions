#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int length = nums.size();
        int f[length];  // max
        int g[length];  // min
        f[0] = nums[0];
        g[0] = nums[0];

        for (int i = 1; i < nums.size(); ++i){
            f[i] = max(nums[i], max(nums[i] * f[i - 1], nums[i] * g[i - 1]));
            g[i] = min(nums[i], min(nums[i] * f[i - 1], nums[i] * g[i - 1]));
        }
        int m = INT32_MIN;
        for (int i = 0; i < nums.size(); ++i){
            m = max(f[i], m);
        }
        return m;
    }
};

int main(){
    Solution sl;
    vector<int> nums = {2, 3, -2, 4};
    cout<<sl.maxProduct(nums)<<endl;
    return 0;
}