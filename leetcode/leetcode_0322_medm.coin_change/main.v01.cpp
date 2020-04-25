#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int MAX = INT32_MAX;
        int d[amount + 1];
        d[0] = 0;
        for (int i = 1; i <= amount; ++i){
            int current_result = MAX;
            for (int j = 0; j < coins.size(); ++j){
                if (i >= coins[j] && d[i - coins[j]] != MAX){
                    current_result = min(current_result, d[i - coins[j]]+1);
                }
            }
            d[i] = current_result;
        }
        return d[amount] == MAX ? -1 : d[amount];
    }
};


int main(){
    Solution sl;
    // vector<int> coins = {1, 2, 5};
    // int amount = 11;
    vector<int> coins = {2, 5, 7};
    int amount = 27;
    cout<<sl.coinChange(coins, amount);
    return 0;
}