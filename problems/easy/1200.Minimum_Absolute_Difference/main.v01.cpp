// https://leetcode-cn.com/problems/minimum-absolute-difference/
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <cmath>
using namespace std;

// submit start
class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int>> result;
        sort(arr.begin(), arr.end());
        int min_val = INT_MAX;
        for (auto it = arr.begin() + 1; it != arr.end(); ++it){
            int diff = abs(*it - *(it - 1));
            min_val = min(diff, min_val);
        }
        for (auto it = arr.begin() + 1; it != arr.end(); ++it){
            int diff = abs(*it - *(it - 1));
            if (diff == min_val){
                result.push_back(vector<int>{*(it - 1), *it});
            }
        }
        return result;
    }
};
// submit end

int main(){
    Solution sl;
    // vector<int> arr = {4, 2, 1, 3};
    // vector<int> arr = {1, 3, 6, 10, 15};
    vector<int> arr = {3, 8, -10, 23, 19, -4, -14, 27};
    auto result = sl.minimumAbsDifference(arr);
    for (auto i = result.begin(); i != result.end(); ++i){
        cout<<i->at(0)<<" "<<i->at(1)<<endl;
    }
    return 0;
}