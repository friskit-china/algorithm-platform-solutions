#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string addStrings(string num1, string num2) {
        string result_str("");
        if(num1.length() < num2.length()){
            auto t = num1;
            num1 = num2;
            num2 = t;
        }

        // add leading zero
        num2.insert(0, string(num1.length() - num2.length(), '0'));

        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; --i){
            int digit_1 = (int)num1[i] - 48;
            int digit_2 = (int)num2[i] - 48;
            int digit_sum = digit_1 + digit_2 + carry;
            carry = digit_sum / 10;
            result_str.insert(0, to_string(digit_sum % 10));
        }
        if (carry != 0){
            result_str.insert(0, to_string(carry));
        }
        return result_str;
    }
};

int main(){
    Solution sl;
    string num1 = "11111";
    string num2 = "229";
    cout<<sl.addStrings(num1, num2)<<endl;
    return 0;
}