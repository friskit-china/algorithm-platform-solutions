// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
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
        int max_price = 0;
        for (int i = 0; i < prices.size() - 1; ++i){
            for (int j = i + 1; j < prices.size(); ++j){
                int profit = prices[j] - prices[i];
                max_price = profit > max_price ? profit : max_price;
            }
        }
        return max_price;
    }
};
//submit end

int main(){
    Solution sl;
    // vector<int >prices = {7, 1, 5, 3, 6, 4}; // 5
    vector<int >prices = {7, 6, 4, 3, 1}; // 0
    cout<<sl.maxProfit(prices)<<endl;
    return 0;
}