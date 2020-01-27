#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    int oddCells(int n, int m, vector<vector<int>>& indices) {
        int oddCount = 0;
        int arrN[n] = {0};
        int arrM[m] = {0};

        // STL fashion
        // for(vector<vector<int>>::iterator it=indices.begin(); it !=indices.end(); ++it ){
        //     arrN[(*it)[0]] ^= 1;
        //     arrM[(*it)[1]] ^= 1;
        // }

        for(int i=0; i < indices.size(); ++i){
            arrN[indices[i][0]] ^= 1;
            arrM[indices[i][1]] ^= 1;
        }
        
        for (int i=0; i<n; ++i){
            for (int j=0; j<m; j++){
                oddCount += arrN[i] ^ arrM[j];
            }
        }
        return oddCount;
    }
};
// submit end

int main(){
    Solution solutionObject;

    // int n = 2;
    // int m = 3;
    // vector<vector<int>> indices{{0,1}, {1,1}};

    int n = 2;
    int m = 2;
    vector<vector<int>> indices{{1,1}, {0,0}};

    cout<<solutionObject.oddCells(n, m, indices);

    return 0;
}