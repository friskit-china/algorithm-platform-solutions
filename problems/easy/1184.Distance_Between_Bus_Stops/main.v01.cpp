// https://leetcode-cn.com/problems/distance-between-bus-stops/
#include <iostream>
#include <vector>
using namespace std;

//submit start
class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        int dis_sum = 0;
        int dis_road = 0;
        int s = min(start, destination);
        int d = max(start, destination);
        for (int i = 0; i < distance.size(); ++i){
            dis_sum += distance[i];
            if (s <= i and i < d){
                dis_road += distance[i];
            }
        }
        return min(dis_road, dis_sum - dis_road);
    }
};
//submit end

int main(){

    Solution sl;
    vector<int> distance = {1, 2, 3, 4};
    cout<<sl.distanceBetweenBusStops(distance, 0, 1)<<endl; // 1
    cout<<sl.distanceBetweenBusStops(distance, 0, 2)<<endl; // 3
    cout<<sl.distanceBetweenBusStops(distance, 0, 3)<<endl; // 4
}