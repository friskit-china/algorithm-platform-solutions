// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0){
            return 0;
        }
        int accumulate = 0;
        for (auto it = prices.begin(); it != prices.end() - 1; ++it){
            int diff = *(it + 1) - (*it);
            if (diff > 0){
                accumulate += diff;
            }
        }
        return accumulate;
    }
};
// submit end

int main(){
    Solution sl;
    // vector<int> prices = {7, 1, 5, 3, 6, 4}; // 7
    // vector<int> prices = {1, 2, 3, 4, 5}; // 4
    vector<int> prices = {7, 6, 4, 3, 1}; // 0
    cout<<sl.maxProfit(prices)<<endl;
    return 0;
}