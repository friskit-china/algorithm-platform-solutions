#include <iostream>
using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        ListNode* result_root = new ListNode(0);
        ListNode* result_last = result_root;
        while (l1 != NULL && l2 != NULL){
            result_last -> next = new ListNode((l1->val + l2->val + carry) % 10);
            result_last = result_last -> next;
            carry = (l1->val + l2->val + carry) / 10;
            l1 = l1->next;
            l2 = l2->next;
        }

        if (l1 == NULL && l2 == NULL){
            if (carry != 0){
                result_last -> next = new ListNode(carry);
                result_last = result_last -> next;
            }
        }else{
            ListNode* remains = l1 == NULL ? l2 : l1;
            while (remains != NULL){
                result_last -> next = new ListNode((remains->val + carry) % 10);
                result_last = result_last -> next;
                carry = (remains -> val + carry) / 10;
                remains = remains -> next;
            }
            if (carry != 0){
                result_last -> next = new ListNode(carry);
                result_last = result_last -> next;
            }
        }
        return result_root->next;
    }
};


int main(){
    Solution sl;
    ListNode* l1, *l2;
    l1 = new ListNode(0);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);
    // l1->next->next->next = new ListNode(5);

    l2 = new ListNode(5);
    l2->next = new ListNode(6);
    l2->next->next = new ListNode(4);
    
    ListNode* result = sl.addTwoNumbers(l1, l2);
    while (result != NULL){
        cout<<result->val<<"->"<<endl;
        result = result->next;
    }
    return 0;
}