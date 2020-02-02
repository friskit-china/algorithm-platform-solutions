// https://leetcode-cn.com/problems/unique-number-of-occurrences/
#include <iostream>
#include <vector>
#include <map>
#include <set>
using namespace std;

//submit start
class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        map<int, int> m;
        set<int> s;
        for (auto it = arr.begin(); it != arr.end(); ++it){
            int num = *it;
            m[num] += 1;
        }
        for (auto it = m.begin(); it != m.end(); ++it){
            s.insert(it -> second);
        }
        if (s.size() < m.size()){
            return false;
        }
        return true;
    }
};
//submit end

int main(){
    Solution sl;
    // vector<int> arr = {1, 2, 2, 1, 1, 3}; // true
    // vector<int> arr = {1, 2}; // false
    vector<int> arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}; // true
    cout<<sl.uniqueOccurrences(arr)<<endl;
    return 0;
}