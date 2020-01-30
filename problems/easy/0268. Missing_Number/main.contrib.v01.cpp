// https://leetcode-cn.com/problems/missing-number/
#include <iostream>
#include <vector>
using namespace std;

// start submit
// inspired by https://leetcode-cn.com/problems/missing-number/comments/7005
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int x = 0;
        int i = 0;
        for (; i < nums.size(); ++i){
            x = x ^ nums[i];
            x = x ^ i;
        }
        x = x ^ i;
        return x;
    }
};
// end submit

int main(){
    Solution sl;
    // vector<int> nums = {3, 0, 1}; // 2
    vector<int> nums = {9, 6, 4, 2, 3, 5, 7, 0, 1}; //8
    cout<<sl.missingNumber(nums)<<endl;
    return 0;
}