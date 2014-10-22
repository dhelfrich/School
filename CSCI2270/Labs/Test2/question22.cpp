#include "bintree.h"
#include "binary_search_tree.h"
#include <iostream>

using namespace std;

// helper function to build a random binary tree
binary_tree_node* binary_tree(unsigned int size)
{
    binary_tree_node* root_ptr = new binary_tree_node;
    root_ptr->data = 0;
    root_ptr->left = root_ptr->right = nullptr;
    binary_tree_node* cursor = root_ptr;
    for (unsigned int k = 1; k < size; ++k)
    {
        while (cursor != nullptr)
            if (rand() % 2)
                if (cursor->left == nullptr)
                {
                    cursor->left = new binary_tree_node;
                    cursor->left->left = cursor->left->right = nullptr;
                    cursor->left->data = rand() % 10;
                    break;
                }
                else cursor = cursor->left;
            else
                if (cursor->right == nullptr)
                {
                    cursor->right = new binary_tree_node;
                    cursor->right->right = cursor->right->left = nullptr;
                    cursor->right->data = rand() % 10;
                    break;
                }
                else cursor = cursor->right;
    }
    return root_ptr;
}

// write this code to search a binary search tree for a target
bool bst_contains(const binary_tree_node* root_ptr, int target)
{
    //base case - root_ptr = nullptr
    if ( root_ptr == nullptr )
        return false;
    //base case return true if node->data is target
    if ( root_ptr->data == target )
        return true;
    else if ( root_ptr->data < target ) //call recursively on right node if target is bigger
        return bst_contains(root_ptr->right, target);
    else if ( root_ptr->data > target  ) //call recursively on left node if target is smaller
        return bst_contains(root_ptr->left, target);
    else
        return false;
}

// write this code to search a binary tree for a target
bool bintree_contains(const binary_tree_node* root_ptr, int target)
{
    //base case - root_ptr = nullptr
    if ( root_ptr == nullptr )
        return false;
    //base case return true if node->data is target
    if ( root_ptr->data == target )
        return true;
    else //recall recursively on both child nodes and check if one is true using (||)
        return (bintree_contains(root_ptr->right, target) || bintree_contains(root_ptr->left, target));
}

int main()
{
    int number;

    // make a random binary search tree
    binary_tree_node* root_ptr1 = nullptr;
    for (unsigned int q = 0; q < 10; ++q)
    {
        insert(root_ptr1, rand() % 10);
    }

    // make a random binary_tree
    binary_tree_node* root_ptr2 = binary_tree(10);

    cout << "Binary search tree " << endl;
    print(root_ptr1, 0);

    cout << "Enter a number to find in the binary search tree ";
    cin >> number;
    if (bst_contains(root_ptr1, number))
        cout << "Yep, that's in the tree" << endl;
    else
        cout << "Nope, that's not in the tree" << endl;

    cout << "Binary tree " << endl;
    print(root_ptr2, 0);

    cout << "Enter a number to find in the binary tree ";
    cin >> number;
    if (bintree_contains(root_ptr2, number))
        cout << "Yep, that's in the tree" << endl;
    else
        cout << "Nope, that's not in the tree" << endl;


    tree_clear(root_ptr1);
    tree_clear(root_ptr2);

    if (bst_contains(root_ptr1, rand() % 10))
        cout << "Empty binary search tree contains a number?!?" << endl;
    else
        cout << "Empty tree contains nothing" << endl;

    if (bintree_contains(root_ptr2, rand ()% 10))
        cout << "Empty binary tree contains a number?!?" << endl;
    else
        cout << "Empty tree contains nothing" << endl;


}
