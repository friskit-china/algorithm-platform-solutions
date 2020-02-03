// https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> result;
        for (int i = - (n / 2); i <= n / 2; i += 1){
            if (n % 2 == 0 and i == 0){
                continue;
            }
            result.push_back(i);
        }
        return result;
    }
};
//submit end

int main(){
    Solution sl;
    int n = 1;
    auto result = sl.sumZero(n);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}