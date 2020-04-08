#include <iostream>
#include <vector>
using namespace std;

// 下面方法为O(n*k*k)，并不符合题目要求
class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        int n = costs.size();
        if (n == 0){
            return 0;
        }
        int k = costs[0].size();
        if (k == 0){
            return 0;
        }

        int f[n][k];

        for (int j = 0; j < k; ++j){
            f[0][j] = costs[0][j];
        }  

        for (int i = 1; i < n; ++i){
            for (int j = 0; j < k; ++j){
                int current_min = INT32_MAX;
                for (int l = 0; l < k; ++l){
                    if (j == l){
                        continue;
                    }
                    current_min = min(current_min, f[i - 1][l] + costs[i][j]);
                }
                f[i][j] = current_min;
            }
        }

        int current_min = f[n - 1][0];
        for (int i = 1; i < k; ++i){
            current_min = min(current_min, f[n - 1][i]);
        }
        return current_min;
    }
};

int main(){
    Solution sl;
    // vector<vector<int>> costs = {
    //     {1, 5, 3},
    //     {2, 9, 4}
    // };
    vector<vector<int>> costs = {
        {15, 17, 15, 20, 7, 16, 6, 10, 4, 20, 7, 3, 4},
        {11, 3, 9, 13, 7, 12, 6, 7, 5, 1, 7, 18, 9}
    };
    cout<<sl.minCostII(costs)<<endl;
    return 0;
}