// https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
#include <iostream>
#include <vector>
using namespace std;


// submit start
class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int counter = 0;
        for (auto it = nums.begin(); it != nums.end(); ++it){
            int num = *it;
            if (num == 0){
                continue;
            }
            bool flag = true;
            while(num != 0){
                num = num / 10;
                flag = !flag;
            }
            if (flag == true){
                counter += 1;
            }
        }
        return counter;
    }
};
//submit end

int main(){
    Solution sl;
    // vector<int> nums = {12, 345, 2, 6, 7896};
    // vector<int> nums = {555, 901, 482, 1771};
    vector<int> nums = {0};
    cout<<sl.findNumbers(nums)<<endl;
    return 0;
}