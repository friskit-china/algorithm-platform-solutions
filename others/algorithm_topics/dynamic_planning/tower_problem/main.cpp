#include <iostream>
#include <vector>
using namespace std;

int main(){
    vector<vector<int>> data = {
        {9},
        {12, 15},
        {10, 6, 8},
        {2, 18, 9, 5},
        {19, 7, 10, 4, 16}
    };
    for (int row = data.size() - 2; row >= 0; --row){
        for (int column = 0; column < row + 1; ++ column){
            data[row][column] = max(data[row+1][column] + data[row][column], data[row+1][column+1] + data[row][column]);
        }
    }
    cout<<data[0][0]<<endl;
    return 0;
}