#include <iostream>
#include <vector>
using namespace std;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 * public:
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     int f(int x, int y);
 * };
 */

class CustomFunction{
    public:
        int f(int x, int y){
            return x + y;
            // return x * y;
        }
};

// start submit
class Solution {
public:
    vector<vector<int>> findSolution(CustomFunction& customfunction, int z) {
        vector<vector<int>> resultList;
        for(int i = 1; i <= z; ++i){
            for (int j = z - i + 1; j >= 1; --j){
                if (customfunction.f(i, j) == z){
                    resultList.insert(resultList.begin(), {{i,j}});
                    break;
                }
            }
        }
        return resultList;
    }
};
// end submit



int main(){
    CustomFunction customfunction;
    Solution solutionObject;
    vector<vector<int>> result = solutionObject.findSolution(customfunction, 5);
    for (vector<vector<int>>::iterator it = result.begin(); it != result.end(); ++it){
        cout<<(*it)[0]<<' '<<(*it)[1]<<endl;
    }
    return 0;
}


