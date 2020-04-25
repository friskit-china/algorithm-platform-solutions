#include <string>
#include <iostream>
using namespace std;

// 暴力，O(n^3)，不要提交这个版本。。
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() <= 1){
            return s.length();
        }
        int result = -1;
        for (int i = 0; i < s.length(); ++i){
            for (int j = 1; j <= s.length() - i; ++j){
                result = max(result, f(s.substr(i, j)));
            }
        }
        return result;
    }

    int f(string s){
        bool flag[256];
        for (int k = 0; k < 256; ++k){
            flag[k] = false;
        }
        for (int i = 0; i < s.length(); ++i){
            if (flag[s[i]] == true){
                return -1;
            }else{
                flag[s[i]] = true;
            }
        }
        return s.length();
    }
};

int main(){
    Solution sl;
    cout<<sl.lengthOfLongestSubstring("au")<<endl; // 2
    cout<<sl.lengthOfLongestSubstring("abcabcbb")<<endl; // 3
    cout<<sl.lengthOfLongestSubstring("bbbbb")<<endl; // 1
    cout<<sl.lengthOfLongestSubstring("pwwkew")<<endl; // 3
    cout<<sl.lengthOfLongestSubstring("aabaab!bb")<<endl; // 3
    return 0;
}