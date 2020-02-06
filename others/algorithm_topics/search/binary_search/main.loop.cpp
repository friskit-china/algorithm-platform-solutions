#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
using namespace std;

class Algorithms{
    public: 
        int static binary_search(vector<int> &arr, int element){
            int left = 0;
            int right = arr.size();
            while (left < right){
                int mid = (left + right) / 2;
                if (arr[mid] < element){
                    left = mid - 1;
                }else if (arr[mid] > element){
                    right = mid + 1;
                }else if (arr[mid] == element){
                    return mid;
                }
            }
            return -1;
        }
};

int main(){
    int data = -1;

    std::ifstream fin_tiny;
    fin_tiny.open("data.tinyW.txt");
    if (!fin_tiny){
        std::cout<<"I/O error"<<endl;
        throw "I/O error";
    }
    vector<int> * arr_tiny = new vector<int>();
    while (fin_tiny>>data){
        arr_tiny->push_back(data);
    }
    sort(arr_tiny->begin(), arr_tiny->end());

    std::ifstream fin_large;
    fin_large.open("data.largeW.txt");
    if (!fin_large){
        std::cout<<"I/O error"<<endl;
        throw "I/O error";
    }
    vector<int> * arr_large = new vector<int>();
    while (fin_large>>data){
        arr_large->push_back(data);
    }
    sort(arr_large->begin(), arr_large->end());

    std::cout<<Algorithms::binary_search(*arr_tiny, 12)<<endl;
    std::cout<<Algorithms::binary_search(*arr_large, 12)<<endl;
    return 0;
}