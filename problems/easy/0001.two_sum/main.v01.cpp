#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mp;
        for (int i = 0; i < nums.size(); ++i){
            auto r = mp.find(target - nums[i]);
            if (r == mp.end()){
                mp[nums[i]] = i;
            }else{
                return vector<int> {i, r->second};
            }
        }
        return vector<int>{0};
    }
};

int main(){
    Solution sl;
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    auto result = sl.twoSum(nums, target);
    cout<<result[0]<<" "<<result[1]<<endl;
    return 0;
}