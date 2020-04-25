#include <iostream>
using namespace std;

class Solution {
public:
    bool canWinNim(int n) {
        return n % 4 != 0;
    }
};


int main(){
    Solution sl;
    cout<<sl.canWinNim(1348820612)<<endl;
    return 0;
}