// https://leetcode-cn.com/problems/play-with-chips/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    int minCostToMoveChips(vector<int>& chips) {
        int count_a = 0;
        int count_b = 0;
        for (auto it = chips.begin(); it != chips.end(); ++ it){
            int num = *it;
            count_a += num % 2;
            count_b += (num + 1) % 2;

        }
        return min(count_a, count_b);
    }
};
// submit end

int main(){
    Solution sl;
    vector<int> chips = {1, 2, 3};       // 1
    // vector<int> chips = {2, 2, 2, 3, 3}; // 2
    cout<<sl.minCostToMoveChips(chips)<<endl;
    return 0;
}