// https://leetcode-cn.com/problems/missing-number/
#include <iostream>
#include <vector>
using namespace std;

// start submit
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sum_all = 0;
        int sum_num = 0;
        int i = 0;
        for (; i < nums.size(); ++i){
            sum_all += i;
            sum_num += nums[i];
        }
        sum_all += i;
        return sum_all - sum_num;
    }
};
// end submit

int main(){
    Solution sl;
    vector<int> nums = {3, 0, 1}; // 2
    // vector<int> nums = {9, 6, 4, 2, 3, 5, 7, 0, 1}; //8
    cout<<sl.missingNumber(nums)<<endl;
    return 0;
}