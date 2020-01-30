// https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
#include <iostream>
using namespace std;


// start submit
class Solution {
public:
    int subtractProductAndSum(int n) {
        if (n == 0){
            return 0;
        }

        int prod = 1;
        int sum = 0;
        while (n != 0){
            int digit = n % 10;
            n = n/10;
            prod = prod * digit;
            sum = sum + digit;
        }
        return prod - sum;
    }
};
// end submit

int main(){
    Solution sl;
    // int n = 234; // 15
    int n = 4421; // 15
    cout<<sl.subtractProductAndSum(n)<<endl;
    return 0;
}