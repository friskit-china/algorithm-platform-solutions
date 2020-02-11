#include <iostream>
#include <exception>
using namespace std;

class stack{
public:
    static const int default_size = 100;
    stack(){
        this->initialization(stack::default_size);
    }
    stack(int size){
        this->initialization(size);
    }
    

    stack* push(int data){
        if (this->is_full()){
            throw new range_error("Stack overflow");
        }
        this->data_array[this->pointer] = data;
        this->pointer += 1;
        return this;
    }

    int pop(){
        if (this->is_empty()){
            throw new range_error("Stack is empty");
        }
        int result = this->data_array[this->pointer - 1];
        this->pointer -= 1;
        return result;
    }

    bool is_full(){
        return this->pointer == this->_size;
    }

    bool is_empty(){
        return this->pointer == 0;
    }
    int size(){
        return this->_size;
    }

    ~stack(){
        delete this->data_array;
    }
private:
    int _size = -1;
    int *data_array;
    int pointer = 0;
    
    void initialization(int size){
        this->_size = size;
        this->data_array = new int[this->_size];
        this->pointer = 0;
    }
};


int main(){
    stack* s = new stack();
    for (int i = 0; i < 50; ++ i){
        s->push(i);
    }
    while(!s->is_empty()){
        cout<<s->pop()<<endl;
    }


    return 0;
}