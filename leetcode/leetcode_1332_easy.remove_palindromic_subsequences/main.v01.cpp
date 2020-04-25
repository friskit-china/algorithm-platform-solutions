// https://leetcode-cn.com/problems/remove-palindromic-subsequences/
#include <iostream>
using namespace std;

// submit start
class Solution {
public:
    int removePalindromeSub(string s) {
        if (s == ""){
            return 0;
        }else if(is_palindrome(s)){
            return 1;
        }else{
            return 2;
        }
    }
    bool is_palindrome(string s){
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j){
            if (s[i] != s[j]){
                return false;
            }
        }
        return true;
    }
};
// submit end

int main(){
    Solution sl;
    cout<<sl.removePalindromeSub("ababa")<<endl; // 1
    cout<<sl.removePalindromeSub("abb")<<endl; // 2
    cout<<sl.removePalindromeSub("baabb")<<endl; // 2
    cout<<sl.removePalindromeSub("")<<endl; // 0
    return 0;
}