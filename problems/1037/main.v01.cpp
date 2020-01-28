// https://leetcode-cn.com/problems/valid-boomerang/
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// start submit
class Solution {
public:
    bool isBoomerang(vector<vector<int>>& points) {
        if (
            abs(distance(points[0], points[1]) + distance(points[0], points[2]) - distance(points[1], points[2])) < 1e-5||
            abs(distance(points[0], points[1]) + distance(points[1], points[2]) - distance(points[0], points[2])) < 1e-5||
            abs(distance(points[0], points[2]) + distance(points[1], points[2]) - distance(points[0], points[1])) < 1e-5){
            return false;
        }
        return true;
    }

    float distance(vector<int>& pointA, vector<int>& pointB){
        return pow(pow(pointB[0] - pointA[0], 2) + pow(pointB[1] - pointA[1], 2), 0.5);
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