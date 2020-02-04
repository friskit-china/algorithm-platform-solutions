// https://leetcode-cn.com/problems/maximum-69-number/
#include <iostream>
#include <cmath>
using namespace std;

// submit start
class Solution {
public:
    int maximum69Number (int num) {
        int result = 0;
        bool flag = true;
        for(int i = 3; i >= 0; --i){
            int a = (int)(num / pow(10, i)) % 10;
            if (a == 6 and flag == true){
                a = 9;
                flag = false;
            }
            result = result * 10 + a;
        }
        return result;
    }
};
// submit end

int main(){
    Solution sl;
    cout<<sl.maximum69Number(9669)<<endl;
    return 0;
}