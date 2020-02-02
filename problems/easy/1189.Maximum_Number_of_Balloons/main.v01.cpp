// https://leetcode-cn.com/problems/maximum-number-of-balloons/
#include <iostream>
#include <string>
using namespace std;

//submit start
class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int counter = 0;
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

            if (num_b >= 1 && num_a >= 1 && num_l >= 2 && num_o >= 2 && num_n >= 1){
                counter += 1;
                num_b -= 1;
                num_a -= 1;
                num_l -= 2;
                num_o -= 2;
                num_n -= 1;
            }
        }
        return counter;
    }
};
//submit end

int main(){
    Solution sl;
    // string text = "nlaebolko"; // 1
    // string text = "loonbalxballpoon"; // 2
    string text = "leetcode"; // 0
    cout<<sl.maxNumberOfBalloons(text);
    return 0;
}