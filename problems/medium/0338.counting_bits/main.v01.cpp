#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> result;
        result.push_back(0);
        for (int i = 1; i < num + 1; ++i){
            result.push_back(result[i >> 1] + (i % 2));
        }
        return result;
    }
};

int main(){
    Solution sl;
    auto result = sl.countBits(5);
    for (int i = 0; i < result.size(); ++i){
        cout<<result[i]<<" ";
    }
    cout<<endl;
    return 0;
}