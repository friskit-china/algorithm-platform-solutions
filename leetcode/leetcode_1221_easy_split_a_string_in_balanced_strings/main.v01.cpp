// https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
#include <iostream>
#include <string>
using namespace std;

// submit start
class Solution {
public:
    int balancedStringSplit(string s) {
        if (s.length() == 0){
            return 0;
        }
        int counter = 0;
        int L = 0;
        int R = 0;
        for (int i = 0; i < s.length(); ++i){
            
            if (s[i] == 'L'){
                L += 1;
            }else if(s[i] == 'R'){
                R += 1;
            }
            if (L == R){
                counter += 1;
                L = 0;
                R = 0;
            }
        }
        return counter;
    }
};
// submit end

int main(){
    Solution sl;
    // string s = "RLRRLLRLRL"; // 4
    // string s = "RLLLLRRRLR"; // 3
    // string s = "LLLLRRRR";   // 1
    string s = "RLRRRLLRLL"; // 2
    cout<<sl.balancedStringSplit(s)<<endl;
    return 0;
}