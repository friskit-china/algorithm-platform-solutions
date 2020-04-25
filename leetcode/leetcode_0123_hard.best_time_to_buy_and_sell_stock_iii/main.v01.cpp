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
        

        for (int i = 1; i < prices.size() + 1; ++i){
            for (int j = 0; j < 5; ++j){
                if (j % 2 == 0){ // current don't hold stock
                    f[i][j] = max(f[i - 1][j], j >= 1 && i >= 2? f[i - 1][j - 1] + prices[i - 1] - prices[i - 2] : INT32_MIN / 2);
                }else{ // current hold stock
                    f[i][j] = max(i >= 2? f[i - 1][j] + prices[i - 1] - prices[i - 2]: INT32_MIN / 2, j >= 1 ? f[i][j - 1] : INT32_MIN / 2);
                }
            }
        }
        return max(max(f[prices.size()][0], f[prices.size()][2]), f[prices.size()][4]);
    }
};

int main(){
    Solution sl;
    vector<int> prices = {3,3,5,0,0,3,1,4}; // 6
    // vector<int> prices = {1,2,3,4,5}; // 4
    // vector<int> prices = {7, 6, 4, 3, 1}; // 0
    cout<<sl.maxProfit(prices)<<endl;
    return 0;
}