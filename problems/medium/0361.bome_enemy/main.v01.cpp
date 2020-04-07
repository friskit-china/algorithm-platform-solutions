#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxKilledEnemies(vector<vector<char>>& grid) {
        int m = grid.size();
        if (m == 0){
            return 0;
        }
        int n = grid[0].size();
        if (n == 0){
            return 0;
        }
        int up[m][n];
        int down[m][n];
        int left[m][n];
        int right[m][n];

        //up
        for (int i = 0; i < n; ++i){
            up[0][i] = 0;
            if (grid[0][i] == 'E'){
                up[0][i] = 1;
            }
        }
        for (int r = 1; r < m; ++r){
            for (int c = 0; c < n; ++c){
                if(grid[r][c] == '0'){
                    up[r][c] = up[r - 1][c];
                }else if(grid[r][c] == 'E'){
                    up[r][c] = up[r - 1][c] + 1;
                }else if(grid[r][c] == 'W'){
                    up[r][c] = 0;
                }
            }
        }

        //down
        for (int i = 0; i < n; ++i){
            down[m - 1][i] = 0;
            if (grid[m - 1][i] == 'E'){
                down[m - 1][i] = 1;
            }
        }

        for (int r = m - 2; r >= 0; --r){
            for (int c = 0; c < n; ++c){
                if(grid[r][c] == '0'){
                    down[r][c] = down[r + 1][c];
                }else if(grid[r][c] == 'E'){
                    down[r][c] = down[r + 1][c] + 1;
                }else if(grid[r][c] == 'W'){
                    down[r][c] = 0;
                }
            }
        }

        //left
        for (int i = 0; i < m; ++i){
            left[i][0] = 0;
            if (grid[i][0] == 'E'){
                left[i][0] = 1;
            }
        }

        for (int c = 1; c < n; ++c){
            for (int r = 0; r < m; ++r){
                if(grid[r][c] == '0'){
                    left[r][c] = left[r][c - 1];
                }else if(grid[r][c] == 'E'){
                    left[r][c] = left[r][c - 1] + 1;
                }else if(grid[r][c] == 'W'){
                    left[r][c] = 0;
                }
            }
        }

        //right
        for (int i = 0; i < m; ++i){
            right[i][n - 1] = 0;
            if (grid[i][n - 1] == 'E'){
                right[i][n - 1] = 1;
            }
        }

        for (int c = n - 2; c >= 0; --c){
            for (int r = 0; r < m; ++r){
                if(grid[r][c] == '0'){
                    right[r][c] = right[r][c + 1];
                }else if(grid[r][c] == 'E'){
                    right[r][c] = right[r][c + 1] + 1;
                }else if(grid[r][c] == 'W'){
                    right[r][c] = 0;
                }
            }
        }

        // aggregate
        int current_max = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == '0'){
                    current_max = max(current_max, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return current_max;
    }
};

int main(){
    Solution sl;
    vector<vector<char>> grid = {
        {'0', 'E', '0', '0'},
        {'E', '0', 'W', 'E'},
        {'0', 'E', '0', '0'}
    };
    cout<<sl.maxKilledEnemies(grid)<<endl;
    return 0;
}