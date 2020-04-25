// https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int max_storage[arr.size()] = {0};
        max_storage[arr.size() - 1] = -1;
        for (int i = arr.size() - 2; i >= 0; -- i){
            max_storage[i] = max(arr[i + 1], max_storage[i + 1]);
        }
        cout<<sizeof max_storage<<" "<<sizeof max_storage[0]<<endl;;
        return vector<int> (max_storage, max_storage + arr.size());
    }
};
//submit end

int main(){
    Solution sl;
    vector<int> arr = {17, 18, 5, 4, 6, 1}; // 18 6 6 6 1 -1

    auto result = sl.replaceElements(arr);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}