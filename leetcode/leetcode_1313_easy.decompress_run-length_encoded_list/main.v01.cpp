// https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    vector<int> decompressRLElist(vector<int>& nums) {
        vector<int> result;
        for (auto it = nums.begin(); it != nums.end(); it+=2){
            for (int i = 0; i < *it; ++i){
                result.push_back(*(it + 1));
            }
        }
        return result;
    }
};
// submit end

int main(){
    Solution sl;
    vector<int> nums = {1, 2, 3, 4};
    auto result = sl.decompressRLElist(nums);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}