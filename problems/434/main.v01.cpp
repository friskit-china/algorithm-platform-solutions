// https://leetcode-cn.com/problems/number-of-segments-in-a-string/
#include <iostream>
#include <string>
using namespace std;

// start submit
class Solution {
public:
    int countSegments(string s) {
        int counter = 0;
        bool in_word = false;
        for (int i = 0; i < s.length(); ++i){
            if (s[i] != ' ' and in_word == false){
                in_word = true;
                counter ++;
            }
            if (s[i] == ' '){
                in_word = false;
            }
            if (in_word == true){
                continue;
            }
        }
        return counter;
    }
};
// end submit

int main(){
    Solution sl;
    // string s("Hello, my name is John");
    string s("");
    cout<<sl.countSegments(s);
    return 0;
}