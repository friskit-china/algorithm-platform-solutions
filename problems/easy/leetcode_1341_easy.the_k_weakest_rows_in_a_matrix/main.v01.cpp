// https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<int> result;
        int m = mat.size();
        int n = mat[0].size();
        int stat[m] = {0};
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                stat[i] += mat[i][j];
            }
        }
        //argsort
        vector<pair<int, int>> stat_with_args;
        for (int i = 0; i < m; ++i){
            stat_with_args.push_back(pair<int, int>({i, stat[i]}));  // arg, value
        }

        for (int i = 0; i < m - 1; ++i){
            for (int j = 0; j < m - i - 1; ++j){
                if (stat_with_args[j].second > stat_with_args[j + 1].second){
                    auto tmp = stat_with_args[j];
                    stat_with_args[j] = stat_with_args[j + 1];
                    stat_with_args[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < k; ++i){
            result.push_back(stat_with_args[i].first);
        }
        return result;
        
    }
};
//submit end

int main(){
    Solution sl;
    // 2, 0, 3
    // vector<vector<int>> mat = {
    //     {1, 1, 0, 0, 0},
    //     {1, 1, 1, 1, 0},
    //     {1, 0, 0, 0, 0},
    //     {1, 1, 0, 0, 0},
    //     {1, 1, 1, 1, 1}
    // };
    // int k = 3;

    // 0, 2
    // vector<vector<int>> mat = {
    //     {1, 0, 0, 0},
    //     {1, 1, 1, 1},
    //     {1, 0, 0, 0},
    //     {1, 0, 0, 0}
    // };
    // int k = 2;

    vector<vector<int>> mat = {
        {1, 1, 0},
        {1, 0, 0},
        {1, 0, 0},
        {1, 1, 1},
        {1, 1, 0},
        {0, 0, 0}
    };
    int k = 4;



    auto result = sl.kWeakestRows(mat, k);
    for (auto it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    return 0;
}