#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if (costs.size() == 0){
            return 0;
        }
        int paint_r[costs.size()];
        int paint_b[costs.size()];
        int paint_g[costs.size()];
        paint_r[0] = costs[0][0];
        paint_b[0] = costs[0][1];
        paint_g[0] = costs[0][2];
        for (int i=1; i< costs.size(); ++i){
            paint_r[i] = min(paint_b[i-1], paint_g[i-1]) + costs[i][0];
            paint_b[i] = min(paint_r[i-1], paint_g[i-1]) + costs[i][1];
            paint_g[i] = min(paint_r[i-1], paint_b[i-1]) + costs[i][2];
        }
        return min(paint_r[costs.size()-1], min(paint_g[costs.size() - 1], paint_b[costs.size() - 1]));
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