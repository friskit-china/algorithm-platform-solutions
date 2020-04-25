#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }
        vector<int> result = {};
        for (int i = 0; i < nums.size(); ++i){
            result.push_back(1);
            for (int j = 0; j < i; j += 1){
                if (nums[j] < nums[i]){
                    result[i] = max(result[i], result[j] + 1);
                }
            }
        }
        int m = -1;
        for (int i = 0; i < nums.size(); ++i){
            m = max(m, result[i]);
        }
        return m;
    }
};

int main(){
    Solution sl;
    vector<int> nums = {1, 3, 6, 7, 9, 4, 10, 5, 6}; // 6
    // vector<int> nums = {10, 9, 2, 5, 3, 7, 101, 18}; // 4
    cout<<sl.lengthOfLIS(nums)<<endl;
    return 0;
}