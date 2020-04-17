#include <string>
#include <iostream>
using namespace std;

// 滑动窗口
class Solution {
public:

    int lengthOfLongestSubstring(string s) {
        if (s.length() <= 1){
            return s.length();
        }
        int flag[256] = {0};
        int result = -1;
        flag[s[0]] = true;
        for (int i = 0, j = 1; j < s.length(); ++j){
            if(flag[s[j]] == true){
                for (;i < j; ++i){
                    flag[s[i]] = false;
                    if (s[i] == s[j]){
                        i = i + 1;
                        break;
                    }
                }
            }
            flag[s[j]] = true;
            result = max(result, j - i + 1);
        }
        return result;
    }
};

int main(){
    Solution sl;
    cout<<sl.lengthOfLongestSubstring("abba")<<endl; // 2
    cout<<sl.lengthOfLongestSubstring("dvdf")<<endl; // 3
    cout<<sl.lengthOfLongestSubstring("aab")<<endl; // 2
    cout<<sl.lengthOfLongestSubstring("abcabcbb")<<endl; // 3
    cout<<sl.lengthOfLongestSubstring("bbbbb")<<endl; // 1
    cout<<sl.lengthOfLongestSubstring("pwwkew")<<endl; // 3
    return 0;
}