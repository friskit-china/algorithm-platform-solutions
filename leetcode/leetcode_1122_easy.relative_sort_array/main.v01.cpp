// https://leetcode-cn.com/problems/relative-sort-array/
#include <iostream>
#include <vector>
using namespace std;


// start submit
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> result;
        int counter[1001] = {0}; 
        for (auto it = arr1.begin(); it != arr1.end(); ++it){
            counter[*it] ++;
        }
        for (auto it = arr2.begin(); it != arr2.end(); ++it){
            for (auto i=0; i < counter[*it]; ++i){
                result.push_back(*it);
            }
            counter[*it] = 0;
        }
        for (auto i = 0; i < 1001; ++i){
            if (counter[i] != 0){
                for (auto j=0; j < counter[i]; ++j){
                    result.push_back(i);
                }
            }
        }
        return result;
    }
};
//end submit

int main(){
    Solution solu;
    vector<int> arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    vector<int> arr2 = {2,1,4,3,9,6};
    auto result = solu.relativeSortArray(arr1, arr2);
    for(auto it = result.begin(); it != result.end(); ++ it){
        cout<<*it<<" ";
    }
    return 0;
}