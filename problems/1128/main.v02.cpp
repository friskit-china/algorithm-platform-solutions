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
            counter += (*it)[0] < (*it)[1] ? matrix[(*it)[0]][(*it)[1]] ++ : matrix[(*it)[1]][(*it)[0]] ++;
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