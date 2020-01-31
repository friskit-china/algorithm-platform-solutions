// https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// submit start
class Solution {
public:
    int getDecimalValue(ListNode* head) {
        int num = 0;
        while (head != NULL){
            num = num << 1;
            num |= head->val;
            head = head->next;
        }
        return num;
    }
};
// submit end

int main(){
    Solution sl;
    auto* n1 = new ListNode(1);
    auto* n2 = new ListNode(0);
    auto* n3 = new ListNode(1);
    n1->next = n2;
    n2->next = n3;
    
    cout<<sl.getDecimalValue(n1)<<endl;

}