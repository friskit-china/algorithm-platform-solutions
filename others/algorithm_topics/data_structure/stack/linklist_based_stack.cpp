#include <iostream>
#include <exception>
using namespace std;



class stack{
public:
    stack(){
        this->head = new Node();
    }
    stack* push(int data){
        Node* new_node = new Node();
        new_node->data = data;
        new_node->next = this->head;
        this->head = new_node;
        this->current_size += 1;
        return this;
    }
    int pop(){
        Node* last_node = this->head;
        int result_value = last_node->data;
        this->head = this->head->next;
        delete last_node;
        this->current_size -= 1;
        return result_value;
    }

    bool is_empty(){
        return this->current_size == 0;
    }

    int size(){
        return this->current_size;
    }

private:
    class Node{
        public:
            int data;
            Node* next;
            Node(){
                this->next = nullptr;
            }
    };
    Node* head = nullptr;
    int current_size = 0;
};

int main(){
    cout<<"start"<<endl;
    stack* s = new stack();
    for (int i = 0; i < 500; ++ i){
        s->push(i);
    }
    while(!s->is_empty()){
        cout<<s->pop()<<endl;
    }
    return 0;
}