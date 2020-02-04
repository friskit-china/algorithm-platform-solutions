// https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
#include <iostream>
using namespace std;

// submit start
class Solution {
public:
    string freqAlphabets(string s) {
        bool in = false;
        string result = "";
        for (int i = s.length() - 1; i >= 0; --i){
            if (s[i] == '#'){
                result = string(1, (s[i-2] - '0') * 10 + (s[i - 1] - '0') + 'a' - 1) + result;
                i -= 2;
            }else{
                result = string(1, s[i] - '0' + 'a' - 1) + result;
            }
        }
        return result;
    }
};
// submit end

int main(){
    Solution sl;
    cout<<sl.freqAlphabets("10#11#12")<<endl; // jkab
    cout<<sl.freqAlphabets("1326#")<<endl; // acz
    cout<<sl.freqAlphabets("25#")<<endl; // y
    return 0;
}