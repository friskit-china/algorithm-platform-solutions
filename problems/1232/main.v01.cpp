#include <iostream>
using namespace std;
#include <vector>

// submit start
class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        if (coordinates.size() == 2){
            return true;
        }
        vector<int> pointA = coordinates[0];
        vector<int> pointB = coordinates[1];
        float xA = pointA[0];
        float yA = pointA[1];
        float xB = pointB[0];
        float yB = pointB[1];
        float k = (yA-yB) / (xA-xB);
        float b = (xA * yB - yA * xB) / (xA - xB);
        for (int i=2; i<coordinates.size(); i++){
            if(isOnLine(k, b, coordinates[i]) == false){
                return false;
            }
        }
        return true;
    }

    bool isOnLine(float k, float b, vector<int> point){
        float x = point[0];
        float y = k * x + b;
        return isFloatEqual(y, point[1]);
    }

    bool isFloatEqual(float a, float b, float prec=1e-5){
        if (abs(a - b) < prec){
            return true;
        }else{
            return false;
        }
    }
};
// submit end

int main(){
    Solution solutionObject;
    vector<vector<int>> coordinates_true {{1, 2}, {2, 3}, {3,4}, {4,5}, {5,6}, {6,7}};
    vector<vector<int>> coordinates_false {{1,1}, {2,2}, {3,4}, {4,5}, {5,6}, {7,7}};
    cout<<solutionObject.checkStraightLine(coordinates_true)<<endl;
    cout<<solutionObject.checkStraightLine(coordinates_false)<<endl;
}