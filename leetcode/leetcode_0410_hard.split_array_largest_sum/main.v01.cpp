#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        if (m == 0 || nums.size() == 0){
            return 0;
        }
        long f[m + 1][nums.size() + 1];
        long sum[nums.size()][nums.size()];
        // int sum[5][5];
        for (int i = 0; i < nums.size(); ++i){
            long acc = 0;
            for (int j = i; j < nums.size(); ++j){
                acc += nums[j];
                sum[i][j] = acc;
            }
        }

        f[0][0] = 0;
        for (int i = 1; i <= nums.size(); ++i){
            f[0][i] = INT32_MAX;
        }
        for (int i = 0; i < m; ++i){
            f[i][0] = 0;
        }

        for (int k = 1; k <= m; ++k){
            for (int i = 1; i <= nums.size(); ++i){
                long t_min = INT32_MAX;
                for (int j = 0; j < i; ++j){
                    t_min = min(t_min, max(f[k - 1][j], sum[j][i - 1]));
                }
                f[k][i] = t_min;
            }
        }

        return f[m][nums.size()];
    }
};

int main(){
    Solution sl;
    vector<int> nums = {7,2,5,10,8};
    cout<<sl.splitArray(nums, 2)<<endl;
    return 0;
}