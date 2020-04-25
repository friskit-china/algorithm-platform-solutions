// https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

// submit start
class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        int counter = 0;
        int chars_num[26] = {0};
        for (int i = 0; i < chars.length(); ++i){
            chars_num[chars[i] - 'a'] += 1;
        }
        for (auto it = words.begin(); it != words.end(); ++it){
            int chars_num_tmp[26];
            copy(begin(chars_num), end(chars_num), begin(chars_num_tmp));
            string word = *it;
            int len = 0;
            bool flag = true;
            for (int i = 0; i < word.length(); ++i){
                if (chars_num_tmp[word[i] - 'a'] == 0){
                    flag = false;
                    break;
                }
                chars_num_tmp[word[i] - 'a'] -= 1;
                len += 1;
            }
            if (flag == true){
                counter += len;
            }
            
        }
        return counter;
    }
};
// submit end

int main(){
    Solution sl;
    vector<string> words = {"cat", "bt", "hat", "tree"};
    string chars = "atach";
    cout<<sl.countCharacters(words, chars)<<endl;
    return 0;
}