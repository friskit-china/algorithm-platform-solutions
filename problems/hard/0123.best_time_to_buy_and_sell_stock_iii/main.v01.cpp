#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0){
            return 0;
        }
        int f[prices.size() + 1][5];
        f[0][0] = 0;
        f[0][1] = f[0][2] = f[0][3] = f[0][4] = INT32_MIN / 2;  // small but not overflow
        f[1][0] = 0;
        f[1][1] = 0;
        f[1][2] = f[1][3] = f[1][4] = INT32_MIN / 2;
        for (int i = 2; i < prices.size() + 1; ++i){
            f[i][0] = f[i - 1][0];
            f[i][1] = max(f[i - 1][1] + prices[i - 1] - prices[i - 2], f[i - 1][0]);
            f[i][2] = max(f[i - 1][2], f[i - 1][1] + prices[i - 1] - prices[i - 2]);
            f[i][3] = max(f[i - 1][3] + prices[i - 1] - prices[i - 2], f[i - 1][2]);
            f[i][4] = max(f[i - 1][4], f[i - 1][3] + prices[i - 1]- prices[i - 2]);
        }
        return max(max(f[prices.size()][0], f[prices.size()][2]), f[prices.size()][4]);
    }
};

int main(){
    Solution sl;
    // vector<int> prices = {3,3,5,0,0,3,1,4}; // 6
    // vector<int> prices = {1,2,3,4,5}; // 4
    vector<int> prices = {7, 6, 4, 3, 1}; // 
    cout<<sl.maxProfit(prices)<<endl;
    return 0;
}