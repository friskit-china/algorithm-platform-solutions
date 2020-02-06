#include <iostream>
#include <vector>
using namespace std;

class Algorithms{
    public: 
        int static binary_search(vector<int> arr, int element){
            int left = 0;
            int right = arr.size() - 1;
            while (left < right){
                int mid = (left + right) / 2;
                if (arr[mid] < element){
                    left = mid + 1;
                }else if (arr[mid] > element){
                    right = mid - 1;
                }else if (arr[mid] == element){
                    return mid;
                }
            }
            return -1;
        }
};

int main(){
    vector<int> arr = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119};
    cout<<Algorithms::binary_search(arr, 10);
    return 0;
}