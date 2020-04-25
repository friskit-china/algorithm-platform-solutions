// https://leetcode-cn.com/problems/maximum-number-of-balloons/
#include <iostream>
#include <string>
#include <algorithm> 
using namespace std;

//submit start
// inspired by https://leetcode-cn.com/problems/maximum-number-of-balloons/comments/151052
class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int num_b = 0;
        int num_a = 0;
        int num_l = 0;
        int num_o = 0;
        int num_n = 0;
        for (int i = 0; i < text.length(); ++i){
            if(text[i] == 'b'){
                num_b += 1;
            }else if(text[i] == 'a'){
                num_a += 1;
            }else if(text[i] == 'l'){
                num_l += 1;
            }else if(text[i] == 'o'){
                num_o += 1;
            }else if(text[i] == 'n'){
                num_n += 1;
            }
        }
        return min({num_b, num_a, num_l / 2, num_o / 2, num_n});
    }
};
//submit end

int main(){
    Solution sl;
    // string text = "nlaebolko"; // 1
    string text = "loonbalxballpoon"; // 2
    // string text = "leetcode"; // 0
    cout<<sl.maxNumberOfBalloons(text);
    return 0;
}