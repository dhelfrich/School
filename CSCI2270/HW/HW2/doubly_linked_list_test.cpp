#include <iostream>
#include "doubly_linked_list.h"

using namespace std;

int main()
{
    node* head = nullptr;
    node* tail = nullptr;
    for (int i = 0; i < 10; ++i)
    {

        add_node_head(head, tail, '0' + i);

    }
    std::cout << "Printing head list forward" << std::endl;
    print_list(head);
    std::cout << "Printing head list backwards" << std::endl;
    print_list_backwards(tail);

    node* head2 = nullptr;
    node* tail2 = nullptr;
    for (int i = 0; i < 10; ++i)
    {

        add_node_tail(head2, tail2, '0' + i);

    }

    std::cout << "Printing tail list forward" << std::endl;
    print_list(head2);
    std::cout << "Printing tail list backwards" << std::endl;
    print_list_backwards(tail2);

    add_node_head(head, tail, 'h');
    add_node_tail(head, tail, 't');

    std::cout << "Printing head list forward" << std::endl;
    print_list(head);
    std::cout << "Printing head list backwards" << std::endl;
    print_list_backwards(tail);
    clear_list(head, tail);
    clear_list(head2, tail2);
    return 0;
}
