// https://leetcode-cn.com/problems/relative-sort-array/
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

// sort by argument
// start submit
int arguments[1001];
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        // prepare argument
        fill_n(arguments, 1001, 9999);
        int counter = -1001;
        for (auto it = arr2.begin(); it != arr2.end(); ++it){
            arguments[*it] = counter;
            counter ++;
        }

        // sort
        sort(arr1.begin(), arr1.end(), [](const int & a, const int & b) -> bool{
            int arg_a = arguments[a] != 9999 ? arguments[a] : a;
            int arg_b = arguments[b] != 9999 ? arguments[b] : b;
            return arg_a < arg_b;
        });

        return arr1;
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