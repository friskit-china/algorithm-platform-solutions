// https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
#include <iostream>
#include <vector>
using namespace std;

// submit start
class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        bool flag = true;
        for(int i=0; i< bits.size(); ++i){
            if (flag == true){
                if(bits[i] == 0 and i == bits.size() - 1){
                    return true;
                }else if (bits[i] == 1){
                    flag = false;
                }
            }else{
                if (bits[i] == 0 and i == bits.size() - 1){
                    return false;
                }else if((bits[i] == 0 and i != bits.size() - 1) || bits[i] == 1){
                    flag = true;
                }
            }
        }
        return false;
    }
};
// submit end

int main(){
    Solution solutionObject;
    vector<int> bits{1,0,0};
    // vector<int> bits{1,1,1,0};
    cout<<solutionObject.isOneBitCharacter(bits)<<endl;
    return 0;
}
