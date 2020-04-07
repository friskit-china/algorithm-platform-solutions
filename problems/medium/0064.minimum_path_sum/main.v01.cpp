#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        if (m == 0){
            return 0;
        }
        int n = grid[0].size();
        if (n == 0){
            return 0;
        }
        for (int i = 1; i < n; ++i){
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; ++i){
            grid[i][0] += grid[i - 1][0];
        }
        
        for (int r = 1; r < grid.size(); ++r){
            for (int c = 1; c < grid[0].size(); ++c){
                grid[r][c] += min(grid[r - 1][c], grid[r][c - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
};

int main(){
    Solution sl;
    vector<vector<int>> grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    cout<<sl.minPathSum(grid)<<endl; // 7
    return 0;
}