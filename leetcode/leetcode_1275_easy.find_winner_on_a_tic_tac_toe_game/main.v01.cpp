// https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/
#include <iostream>
#include <vector>
using namespace std;

// start submit
class Solution {
public:
    int correct_mask[8] =  {0b100100100, 0b010010010, 0b001001001, 0b111000000, 
                            0b000111000, 0b000000111, 0b100010001, 0b001010100};
    string tictactoe(vector<vector<int>>& moves) {
        int counter = 0;
        int map_A = 0x000000000;
        int map_B = 0x000000000;
        for (auto step = moves.begin(); step != moves.end(); ++step){
            int x = (*step)[0];
            int y = (*step)[1];
            int shift = 8 - 3 * x - y;
            if (counter % 2 == 0){ // for playerA
                map_A = map_A | (0b1<<shift);
            }else{ // for playerB
                map_B = map_B | (0b1<<shift);
            }
            // check wins
            for (int i = 0; i < 8; ++i){
                if ((map_A & correct_mask[i]) == correct_mask[i]){
                    return "A";
                }else if((map_B & correct_mask[i]) == correct_mask[i]){
                    return "B";
                }
            }
            counter += 1;
        }
        if (counter == 9){
            return "Draw";
        }else{
            return "Pending";
        }
    }
};
//end submit

int main(){
    Solution sl;
    // vector<vector<int>> moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};                                 // "A"
    // vector<vector<int>> moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};                         // "B"
    // vector<vector<int>> moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}}; // "Draw"
    vector<vector<int>> moves = {{0, 0}, {1, 1}};                                                            // "Pending"
    auto result = sl.tictactoe(moves);
    cout<<result<<endl;
    return 0;
}