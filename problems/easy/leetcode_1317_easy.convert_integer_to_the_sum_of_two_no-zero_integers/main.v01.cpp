// https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
#include <iostream>
#include <vector>
using namespace std;

//submit start
class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        for (int i = 1; i < n; ++i){
            if (!include_zero(i) and !include_zero(n - i)){
                return vector<int>({i, n-i});
            }
        }
        return vector<int>();
    }
    bool include_zero(int n){
        while (n != 0){
            if (n % 10 == 0){
                return true;
            }
            n /= 10;
        }
        return false;
    }
};
//submit end

int main(){
    Solution sl;
    // int n = 2; // 1, 1
    // int n = 10000; // 1 9999
    // int n = 69; // 1 68
    int n = 1010; // 11 999
    auto result = sl.getNoZeroIntegers(n);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}