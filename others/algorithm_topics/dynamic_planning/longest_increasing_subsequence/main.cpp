#include <iostream>
#include <vector>
using namespace std;

int main(){
    vector<int> sequence = {5, 3, 4, 8, 6, 7};
    vector<int> result = {};
    for (int i = 0; i < sequence.size(); ++i){
        result.push_back(1);
        for (int j = 0; j < i; j += 1){
            if (sequence[j] < sequence[i]){
                result[i] = max(result[i], result[j] + 1);
            }
        }
    }
    for (int i = 0; i < result.size(); ++ i){
        cout<<result[i]<<endl;
    }
    return 0;
}