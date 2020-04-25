#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        if (s.length() == 0 or s[0] == '0'){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        

        int l[s.length()];
        l[0] = 1;

        if (is_valid(s[0], s[1])){
            if (s[1] == '0'){
                l[1] = 1;
            }else{
                l[1] = 2;
            }
        }else{
            if (s[1] == '0'){
                l[1] = 0;
            }else{
                l[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); ++i){
            l[i] = 0;

            if (s[i - 1] == '0' && s[i] == '0'){
                return 0;
            }

            if (!is_valid(s[i - 2], s[i - 1]) && !is_valid(s[i - 1], s[i]) && l[i-1] == 0){
                return 0;
            }

            if (is_valid(s[i - 1], s[i])){
                l[i] += l[i - 2];
            }

            if (s[i] != '0'){
                l[i] += l[i - 1];
            }
            
            
        }
        return l[s.length() - 1];
    }

    bool is_valid(char n1, char n2){
        int n = (n1 - '0') * 10 + n2 - '0';
        if (n >= 10 && n <= 26){
            return true;
        }
        return false;
    }
};

int main(){
    Solution sl;
    cout<<sl.numDecodings("27")<<endl; // 1: BG(2 7)
    cout<<sl.numDecodings("1029")<<endl; // 1: JBI(10 2 9)
    cout<<sl.numDecodings("301")<<endl; // 0: invalid
    cout<<sl.numDecodings("101")<<endl; // 1: JA(10 1)
    cout<<sl.numDecodings("100")<<endl; // 0: invalid
    cout<<sl.numDecodings("1001")<<endl; // 0: invalid
    cout<<sl.numDecodings("10")<<endl; // 1: J(10)
    cout<<sl.numDecodings("12")<<endl; // 2: AB(1 2), L(12)
    cout<<sl.numDecodings("226")<<endl; // 3: BZ(2 26), VF(22 6), BBF(2 2 6)
    return 0;
}