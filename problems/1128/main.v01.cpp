// https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

// start submit
class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int matrix[10][10] = {0};
        int counter = 0;
        for (auto it = dominoes.begin(); it != dominoes.end(); ++ it){
            int a = 0;
            int b = 0;
            if ((*it)[0] < (*it)[1]){
                a = (*it)[0];
                b = (*it)[1];
            }else{
                a = (*it)[1];
                b = (*it)[0];
            }
            matrix[a][b] ++;
        }
        for (int i = 1; i <= 9; ++i){
            for (int j = i; j <= 9; ++j){
                if (matrix[i][j] >= 2){
                    counter += (matrix[i][j] * (matrix[i][j] - 1)) / 2;
                }
            }
        }
        return counter;
    }
};
// end submit


int main(){
    Solution obj;
    vector<vector<int>> dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
    cout<<obj.numEquivDominoPairs(dominoes)<<endl;
    return 0;
}