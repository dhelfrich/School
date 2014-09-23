#include "singly_linked_list.h"

using namespace std;

bool check_list(const node*& head_ptr)
{
    for (const node*& cursor = head_ptr; 
            cursor != nullptr && cursor->next != nullptr;
            cursor = cursor->next)
        if (cursor->data > cursor->next->data) return false;
    return true;
}

unsigned int freq_iterative(const node*& head_ptr, const int& target)
{
    unsigned int freq = 0;
    //loop through the entire linked list, and increment
    //freq if it matches the target
    for (const node*& cursor = head_ptr; 
            cursor != nullptr;
            cursor = cursor->next)
        if(cursor->data == target) ++freq;
    return freq;
}

unsigned int freq_recursive(const node*& head_ptr, const int& target)
{
    //Base case if list is null
    if(head_ptr == nullptr)
        return 0;
    //Base case if list is not null
    else if(head_ptr->next == nullptr)
        //Return 1 if target is in the data. Otherwise, return 0
        return (head_ptr->data == target);
    else
    {
        //If it is not one of the above cases, check if the head_ptr points to data
        //equal to the target. Then preform the same function on head_ptr->next.
        const node* next_head = head_ptr->next;
        return (head_ptr->data == target) + freq_recursive(next_head, target);
    }
}

int main()
{
    node* head_ptr1 = nullptr;      // This will be the list 1 head
    const node* const_head_ptr1;	
    int target = 9;

    const_head_ptr1 = head_ptr1;
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    cout << "Frequency of " << target << " is " << 
        freq_iterative(const_head_ptr1, target) << endl;

    for (unsigned int k = 0; k < 10; ++k)
    {
        add_node(head_ptr1, target);	// add a number to the list
        const_head_ptr1 = head_ptr1;
        cout << "Here is your list: " << endl;
        print_list(const_head_ptr1);
        cout << "Frequency of " << target << " is " << 
            freq_iterative(const_head_ptr1, target) << endl;
    }

    target = 10;
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    cout << "Frequency of " << target << " is " << 
        freq_iterative(const_head_ptr1, target) << endl;

    clear_list(head_ptr1);				// destroy list 1

    print_list(const_head_ptr1);
    cout << "Frequency of " << target << " is " << 
        freq_recursive(const_head_ptr1, target) << endl;

    for (unsigned int k = 0; k < 10; ++k)
    {
        add_node(head_ptr1, target);	// add a number to the list
        const_head_ptr1 = head_ptr1;
        cout << "Here is your list: " << endl;
        print_list(const_head_ptr1);
        cout << "Frequency of " << target << " is " << 
            freq_recursive(const_head_ptr1, target) << endl;
    }

    target = 10;
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    cout << "Frequency of " << target << " is " << 
        freq_recursive(const_head_ptr1, target) << endl;

    //I added these lines to test what happens if the target is not in the list
    add_node(head_ptr1,11);
    target = 11;
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    print_list(const_head_ptr1);
    cout << "Frequency (iter) of " << target << " is " << 
        freq_iterative(const_head_ptr1, target) << endl;
    add_node(head_ptr1,11);
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    cout << "Frequency (recur) of " << target << " is " << 
        freq_recursive(const_head_ptr1, target) << endl;
    cout << "Here is your list: " << endl;
    print_list(const_head_ptr1);
    cout << "Frequency (iter) of " << target << " is " << 
        freq_iterative(const_head_ptr1, target) << endl;
    cout << "Frequency (recur) of " << target << " is " << 
        freq_recursive(const_head_ptr1, target) << endl;
    clear_list(head_ptr1);				// destroy list 1
}
