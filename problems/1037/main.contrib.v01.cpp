// https://leetcode-cn.com/problems/valid-boomerang/
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// gradient: two lines must have different slope
// (y_1-y_2)/(x_1-x_2) != (y_2-_y_3)/(x_2-x_3)
// convert to prod only: (y_1-y_2) * (x_2-x_3) != (y_2-y_3) * (x_1-x_2)

// start submit
class Solution {
public:
    bool isBoomerang(vector<vector<int>>& points) {
        return (points[0][1] - points[1][1]) * (points[1][0] - points[2][0]) != (points[1][1] - points[2][1]) * (points[0][0] - points[1][0]);
    }
};
// end submit

int main(){
    Solution solutionObject;
    // vector<vector<int>> points = {{1,1}, {2,3}, {3,2}};
    vector<vector<int>> points = {{1,1}, {2,2}, {3,3}};
    cout<<solutionObject.isBoomerang(points);
    
    return 0;
}