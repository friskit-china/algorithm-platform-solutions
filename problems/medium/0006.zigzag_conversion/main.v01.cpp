#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1){
            return s;
        }

        string sl[numRows];
        for (int i = 0; i < numRows; ++i){
            sl[i] = "";
        }

        int row = 0;
        bool is_down = false;
        for (int i = 0; i < s.length(); ++i){
            sl[row] += s[i];
            if (row == numRows - 1 || row == 0){
                is_down = !is_down;
            }
            if (is_down == true){
                row += 1;
            }else{
                row -= 1;
            }
        }
        string result = "";
        for (int i = 0; i < numRows; ++i){
            result += sl[i];
        }
        return result;
    }
};

int main(){
    Solution sl;
    cout<<sl.convert("LEETCODEISHIRING", 3)<<endl;
    cout<<"-----"<<endl;
    cout<<sl.convert("LEETCODEISHIRING", 4)<<endl;
    return 0;
}