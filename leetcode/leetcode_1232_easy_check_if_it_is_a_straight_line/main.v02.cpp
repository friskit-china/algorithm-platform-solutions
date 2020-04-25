// https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
#include <iostream>
using namespace std;
#include <vector>

// submit start
class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        float k = (coordinates[0][1] * 1.0 - coordinates[1][1] * 1.0) / (coordinates[0][0] * 1.0 - coordinates[1][0] * 1.0);
        float b = (coordinates[0][1] - k * coordinates[0][0]);
        for (int i=2; i<coordinates.size(); i++){
            if (abs(k * coordinates[i][0] + b - coordinates[i][1]) > 1e-5){
                return false;
            }
        }
        return true;
    }
};
// submit end

int main(){
    Solution solutionObject;
    vector<vector<int>> coordinates_true {{1, 2}, {2, 3}, {3,4}, {4,5}, {5,6}, {6,7}};
    vector<vector<int>> coordinates_false {{1,1}, {2,2}, {3,4}, {4,5}, {5,6}, {7,7}};
    cout<<solutionObject.checkStraightLine(coordinates_true)<<endl;
    cout<<solutionObject.checkStraightLine(coordinates_false)<<endl;
    return 0;
}