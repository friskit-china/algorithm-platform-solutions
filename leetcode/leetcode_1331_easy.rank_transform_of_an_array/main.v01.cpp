// https://leetcode-cn.com/problems/rank-transform-of-an-array/
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int> result;
        vector<int> new_arr = arr;
        map<int, int> rank_map;

        sort(new_arr.begin(), new_arr.end());
        
        int last = -1e9 - 1;
        int i = 1;
        for (auto it = new_arr.begin(); it != new_arr.end(); ++it){
            if (*it == last){
                continue;
            }
            rank_map[*it] = i;
            last = *it;
            i += 1;
        }
        for (auto it = arr.begin(); it != arr.end(); ++it){
            result.push_back(rank_map[*it]);
        }
        return result;
    }
};

int main(){
    Solution sl;
    // vector<int> arr = {40, 10, 20, 30}; // [4, 1, 2, 3]
    // vector<int> arr = {100, 100, 100}; // [1, 1, 1]
    vector<int> arr = {37, 12, 28, 9, 100, 56, 80, 5, 12}; // [5, 3, 4, 2, 8, 6, 7, 1, 3]
    auto result = sl.arrayRankTransform(arr);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}