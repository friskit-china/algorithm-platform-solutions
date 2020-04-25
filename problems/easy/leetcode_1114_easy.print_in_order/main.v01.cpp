// https://leetcode-cn.com/problems/print-in-order/
#include <iostream>
#include <functional>
#include <thread>
#include <chrono>
#include <mutex>
using namespace std;


bool lock_1 = true;
bool lock_2 = true;

class Foo {
public:
    Foo() {
        
    }

    void first(function<void()> printFirst) {
        // printFirst() outputs "first". Do not change or remove this line.
        printFirst();
        lock_1 = false;
    }

    void second(function<void()> printSecond) {
        while (lock_1 == true){
            this_thread::sleep_for(std::chrono::milliseconds(10));
        }
        // printSecond() outputs "second". Do not change or remove this line.
        printSecond();
        lock_2 = false;
    }

    void third(function<void()> printThird) {
        while (lock_2 == true){
            this_thread::sleep_for(std::chrono::milliseconds(10));
        }
        // printThird() outputs "third". Do not change or remove this line.
        printThird();
    }
};

void func1(){
    cout<<"func 1"<<endl;
}

void func2(){
    cout<<"func 2"<<endl;
}

void func3(){
    cout<<"func 3"<<endl;
}

void thread_1(Foo* foo){
    foo->first(func1);
}

void thread_2(Foo* foo){
    foo->second(func2);
}

void thread_3(Foo* foo){
    foo->third(func3);
}

int main(){
    Foo *foo;
    thread thread_obj_3(thread_1, foo);
    thread thread_obj_2(thread_2, foo);
    thread thread_obj_1(thread_3, foo);

    thread_obj_1.join();
    thread_obj_2.join();
    thread_obj_3.join();

    return 0;
}