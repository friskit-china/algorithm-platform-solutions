#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    static bool sort_func(vector<int> a, vector<int> b){
        if (a[0] == b[0]){
            return a[1] < b[1];
        }
        return a[0] < b[0];
        
    }

    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if (envelopes.size() == 0){
            return 0;
        }
        sort(envelopes.begin(), envelopes.end(), sort_func);

        int f[envelopes.size()];
        f[0] = 1;
        for (int i = 1; i < envelopes.size(); ++i){
            f[i] = 1;
            for (int j = 0; j < i; ++j){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    f[i] = max(f[i], f[j] + 1);
                }
            }
        }
        int result = -1;
        for (int i = 0; i < envelopes.size(); ++i){
            result = max(result, f[i]);
        }
        return result;
    }
};

int main(){
    Solution sl;
    vector<vector<int>> envelopes = { {5, 4}, {6, 4}, {6, 7}, {2, 3} }; // 3
    cout<<sl.maxEnvelopes(envelopes)<<endl;
    return 0;
}