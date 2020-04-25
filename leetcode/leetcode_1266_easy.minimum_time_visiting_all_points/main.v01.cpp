// https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int total_time = 0;
        for(int i=0; i < points.size() - 1; ++i){
            auto from = points[i];
            auto to = points[i + 1];
            auto distance_x = abs(from[0] - to[0]);
            auto distance_y = abs(from[1] - to[1]);
            total_time += max(distance_x, distance_y);
        }
        return total_time;
    }
};
// submit end

int main(){
    Solution sl;

    // vector<vector<int>> points = {{1, 1}, {3, 4}, {-1, 0}};
    vector<vector<int>> points = {{3, 2}, {-2, 2}};
    cout<<sl.minTimeToVisitAllPoints(points);

    return 0;
}