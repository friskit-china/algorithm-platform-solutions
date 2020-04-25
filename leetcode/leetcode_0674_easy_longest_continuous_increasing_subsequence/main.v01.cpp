#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }
        int current_max = 1;
        int current_length = 1;
        for (int i = 1; i < nums.size(); ++i){
            if (nums[i] > nums[i - 1]){
                current_length += 1;
            }else{
                current_max = max(current_max, current_length);
                current_length = 1;
            }
            current_max = max(current_max, current_length);
        }
        return current_max;
    }
};

int main(){
    Solution sl;
    vector<int> nums = {1,3,5,4,7};
    cout<<sl.findLengthOfLCIS(nums)<<endl;
    return 0;
}