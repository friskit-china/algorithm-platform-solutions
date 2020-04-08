// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
#include <iostream>
#include <vector>
using namespace std;

// 动态规划版
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0){
            return 0;
        }
        int min_price = prices[0];
        int f[prices.size() + 1];
        f[0] = 0;
        for (int i = 1; i < prices.size() + 1; ++i){
            min_price = min(min_price, prices[i - 1]);
            f[i] = max(f[i - 1], prices[i - 1] - min_price);
        }
        return f[prices.size()];
    }
};
//submit end

int main(){
    Solution sl;
    vector<int >prices = {7, 1, 5, 3, 6, 4}; // 5
    // vector<int >prices = {7, 6, 4, 3, 1}; // 0
    cout<<sl.maxProfit(prices)<<endl;
    return 0;
}