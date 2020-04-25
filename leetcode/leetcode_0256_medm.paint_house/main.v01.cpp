#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if (costs.size() == 0){
            return 0;
        }
        int f[costs.size()][costs[0].size()];
        for (int j = 0; j < costs[0].size(); ++j){
            f[0][j] = costs[0][j];
        }
        for (int i = 1; i < costs.size(); ++i){
            for (int j = 0; j < costs[0].size(); ++j){
                int t = INT32_MAX;
                for (int k = 0; k < costs[0].size(); ++k){
                    if (j == k){ // skip the same color
                        continue;
                    }
                    t = min(t, f[i - 1][k]);
                }
                f[i][j] = t + costs[i][j];
            }
        }
        
        int m = INT32_MAX;
        for (int j = 0; j < costs[0].size(); ++j){
            m = min(m, f[costs.size() - 1][j]);
        }
        return m;
    }
};

int main(){
    Solution sl;
    vector<vector<int>> costs = {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    cout<<sl.minCost(costs)<<endl;
    return 0;
}