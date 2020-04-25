// https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
#include <iostream>
#include <vector>
using namespace std;

// submit start
// inspired by https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/comments/210425
class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int max_num = -1;
        for (int i = arr.size() - 1; i >= 0; --i){
            int tmp = max(arr[i], max_num);
            arr[i] = max_num;
            max_num = tmp;
        }
        return arr;
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