#include "list_stack.h"

using namespace std;


int main()
{
	int num;
	list_stack list_stk;
	init(list_stk);
	for (unsigned int k = 0; k < 10; ++k)
	{
		cout << "Enter a number to push: ";
		cin >> num;
		push(list_stk, num);	
		print(list_stk);
	}
	
	for (unsigned int k = 0; k < 10; ++k)
	{
		pop(list_stk);
		print(list_stk);
	}
	
	
	cout << "Clearing" << endl;
	destr(list_stk);					
}
