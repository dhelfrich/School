#include <iostream>

struct node {
	int data;
	node* next;
};


void add_node(node*& head_ptr, const int& payload);

bool remove_node(node*& head_ptr, const int& target);

void print_list(const node* head_ptr);

bool find_list(const node* head_ptr, const int& target);

void clear_list(node*& head_ptr);

void copy_list(const node* source_ptr, node*& dest_ptr);

