#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length() <= 1){
            return s;
        }

        bool p[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i){
            for (int j = 0; j < s.length(); ++j){
                if (i == j){
                    p[i][j] = true;
                }else{
                    p[i][j] = false;
                }
            }
        }

        int best_from = 0;
        int best_to = 0;
        int best_len = 1;

        for (int i = 1; i < s.length(); ++i){
            if (s[i - 1] == s[i]){
                best_from = i - 1;
                best_to = i;
                best_len = 2;
                p[i - 1][i] = true;
            }
        }

        

        for (int l = 2; l <= s.length(); ++l){
            for (int i = 0; i < s.length() - l; ++i){
                int j = i + l;
                if (s[i] == s[j] && p[i + 1][j - 1] == true){
                    p[i][j] = true;
                    if (j - i + 1 > best_len){
                        best_from = i;
                        best_to = j;
                    }
                }else{
                    p[i][j] = false;
                }
            }
        }
        string result = "";
        for (int i = best_from; i <= best_to; ++i){
            result = result + s[i];
        }
        return result;
    }
};

int main(){
    Solution sl;
    cout<<sl.longestPalindrome("bbabad")<<endl; // bad, aba
    cout<<sl.longestPalindrome("babad")<<endl; // bab, aba
    cout<<sl.longestPalindrome("cbbd")<<endl; // bb

    return 0;
}