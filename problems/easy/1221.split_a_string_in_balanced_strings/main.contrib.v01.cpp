// https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
#include <iostream>
#include <string>
using namespace std;

// submit start
// inspired by https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/comments/164265 only use 1 counter.
class Solution {
public:
    int balancedStringSplit(string s) {
        if (s.length() == 0){
            return 0;
        }
        int counter = 0;
        int n = 0;
        for (int i = 0; i < s.length(); ++i){
            
            if (s[i] == 'L'){
                n += 1;
            }else if(s[i] == 'R'){
                n -= 1;
            }
            if (n == 0){
                counter += 1;
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