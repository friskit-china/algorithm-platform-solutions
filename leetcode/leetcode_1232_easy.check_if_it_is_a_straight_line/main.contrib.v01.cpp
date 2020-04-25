// https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
#include <iostream>
using namespace std;
#include <vector>

// solution of https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/comments/167070
// comment: this solution is memory saver but comsumes more cpu.

// submit start
class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& c) {
        for(int i=3;i<c.size();i++)
            if((c[1][1]-c[0][1])*(c[i][0]-c[0][0])!=(c[i][1]-c[0][1])*(c[1][0]-c[0][0]))
                return false;
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