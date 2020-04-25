#include <iostream>
using namespace std;

class Solution {
public:
    int minCut(string s) {
        bool p[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i){
            for (int j = 0; j < s.length(); ++j){
                p[i][j] = false;
            }
        }
        // odd pal num
        for (int i = 0; i < s.length(); ++i){
            for (int j = 0; i - j >= 0 && i + j <= s.length(); ++j){
                if (s[i - j] == s[i + j]){
                    p[i - j][i + j] = true;
                }else{
                    break;
                }
            }
        }

        // even pal num
        for (int i = 1; i < s.length(); ++i){
            for(int j = 1; i - j >=0 && i + j <= s.length() + 1; ++j){
                if (s[i - j] == s[i + j - 1]){
                    p[i - j][i + j - 1] = true;
                }else{
                    break;
                }
            }
        }

        // dp
        int f[s.length() + 1];
        f[0] = 0;
        for (int i = 1; i <= s.length(); ++i){
            int m = INT32_MAX;
            for (int j = 0; j < i; ++j){
                if (p[j][i - 1] == true){
                    m = min(m, f[j]);
                }
            }
            f[i] = m + 1;
        }
        return f[s.length()] - 1;
    }
};

int main(){
    Solution sl;
    cout<<sl.minCut("aab")<<endl;
    return 0;
}