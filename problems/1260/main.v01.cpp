// https://leetcode-cn.com/problems/shift-2d-grid/

#include <iostream>
#include <vector>
using namespace std;

// start submit
class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        int total = m * n;
        int arr[total] = {};
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                arr[i * n + j] = grid[i][j];
            }
        }

        for (int counter = 0; counter < m * n; ++counter){
            int i = counter / n;
            int j = counter % n;
            grid[i][j] = arr[((total - k % total) + counter) % total];
        }
        return grid;
    }
};
// end submit

int main(){
    Solution sl;

    // vector<vector<int>> grid = {{1,2,3}, {4,5,6}, {7,8,9}};
    // int k = 1;

    vector<vector<int>> grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
    int k = 4;

    // vector<vector<int>> grid = {{1,2,3}, {4,5,6}, {7,8,9}};
    // int k = 9;


    auto result = sl.shiftGrid(grid, k);
    for(auto it_1 = result.begin(); it_1 != result.end(); ++it_1){
        for (auto it_2 = it_1->begin(); it_2 != it_1->end(); ++it_2){
            cout<<*it_2<<" ";
        }
        cout<<endl;
    }
    return 0;
}