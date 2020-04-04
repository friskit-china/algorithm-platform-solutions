#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 1){
            return triangle[0][0];
        }
        for (int row = triangle.size() - 2; row >=0 ; --row){
            for (int column = 0; column < row + 1; ++column){
                triangle[row][column] = triangle[row][column] + min(triangle[row + 1][column], triangle[row + 1][column + 1]);
            }
        }
        return triangle[0][0];
    }
};

int main(){
    Solution sl;
    vector<vector<int>> triangle = {
        {2},
        {3,4},
        {6,5,7},
        {4,1,8,3}
    };
    cout<<sl.minimumTotal(triangle)<<endl;
    return 0;
}