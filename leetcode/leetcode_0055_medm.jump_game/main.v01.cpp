#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        bool result[nums.size()];
        int n = nums.size();
        result[0] = true;
        for (int i = 1; i < n; ++i){
            result[i] = false;
            for (int j = 0; j < i; ++j){
                if (result[j] == true &&i - j <= nums[j]){
                    result[i]=true;
                    break;
                }
            }
        }
        return result[n-1];
    }
};

int main(){
    Solution sl;
    // vector<int> nums = {2,3,1,1,4}; // true
    vector<int> nums = {3,2,1,0,4}; // false
    cout<<sl.canJump(nums)<<endl;
    return 0;
}
