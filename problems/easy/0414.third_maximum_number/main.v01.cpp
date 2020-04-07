#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int64_t big_1 = LONG_MIN;
        int64_t big_2 = LONG_MIN;
        int64_t big_3 = LONG_MIN;
        int64_t max = LONG_MIN;
        for (auto it = nums.begin(); it != nums.end(); ++it){
            if ((*it) > max){
                max = *it;
            }
            if ((*it) == big_1 || (*it) == big_2 || (*it) == big_3){
                continue;
            }

            if ((*it) > big_3){
                big_3 = (*it);
            }
            if (big_3 > big_2){
                auto tmp = big_2;
                big_2 = big_3;
                big_3 = tmp;
            }
            if (big_2 > big_1){
                auto tmp = big_1;
                big_1 = big_2;
                big_2 = tmp;
            }
        }

        if (big_3 != LONG_MIN){
            return big_3;
        }else {
            return max;
        }
    }
};

int main(){
    Solution sl;
    // vector<int> nums = {3,2,1};
    // vector<int> nums = {1,2};
    // vector<int> nums = {2,2,3,1};
    vector<int> nums = {1,2,-2147483648};
    cout<<sl.thirdMax(nums)<<endl;
    return 0;
}