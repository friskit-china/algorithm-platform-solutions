// https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
#include <iostream>
#include <vector>
using namespace std;

// start submit
class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int total_count = arr.size();
        int current_counter = 0;
        int current_num = 0;
        for(auto it = arr.begin(); it != arr.end(); ++it){
            if ((*it) == current_num){
                current_counter += 1;
            }else{
                current_num = (*it);
                current_counter = 1;
            }
            // if (current_counter > total_count / 4){
            // inspired by https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/solution/you-xu-shu-zu-zhong-chu-xian-ci-shu-chao-guo-25de-/
            if (current_counter * 4 > total_count){
                return current_num;
            }
        }
        return 0;
    }
};
// end submit

int main(){
    Solution sl;
    vector<int> arr = {1, 2, 2, 6, 6, 6, 7, 10};
    cout<<sl.findSpecialInteger(arr)<<endl;
    return 0;
}