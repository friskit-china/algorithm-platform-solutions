#include <iostream>
using namespace std;

class Solution {
public:
    int numSquares(int n) {
        if (n == 0){
            return 0;
        }
        int result[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; ++i){
            int m = INT32_MAX;
            for (int j = 1; j * j <= i; ++j){
                m = min(m, result[i - j * j]);
            }
            result[i] = m + 1;
        }
        return result[n];
    }
};

int main(){
    Solution sl;
    cout<<sl.numSquares(1)<<endl;
    return 0;
}