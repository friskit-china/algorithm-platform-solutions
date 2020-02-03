// https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character/
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

// submit start
class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        vector<int> result;
        int f_words[words.size()] = {0};
        for (int i = 0; i < words.size(); ++i){
            f_words[i] = f(words[i]);
        }
        for (auto it = queries.begin(); it != queries.end(); ++it){
            int f_q = f(*it);
            int counter = 0;
            for (int i = 0; i < words.size(); ++i){
                if (f_q < f_words[i]){
                    counter += 1;
                }
            }
            result.push_back(counter);
        }
        return result;
    }

    int f(string s){
        char min_word = 'z' + 1;
        int min_counter = 0;
        for (int i = 0; i < s.length(); ++i){
            if (s[i] < min_word){
                min_word = s[i];
                min_counter = 1;
            }else if(s[i] == min_word){
                min_counter += 1;
            }
        }
        return min_counter;
    }
};
// submit end

int main(){
    Solution sl;

    // vector<string> queries = {"cbd"};
    // vector<string> words = {"zaaaz"};

    vector<string> queries = {"bbb", "cc"};
    vector<string> words = {"a", "aa", "aaa", "aaaa"};

    auto result = sl.numSmallerByFrequency(queries, words);
    for (vector<int>::iterator it = result.begin(); it != result.end(); ++it){
        cout<<*it<<" ";
    }
    cout<<endl;
    

    return 0;
}