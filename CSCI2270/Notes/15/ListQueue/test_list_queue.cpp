#include "list_queue.h"

using namespace std;


int main()
{
	int num;
	list_queue list_que;
	init(list_que);
	for (unsigned int k = 0; k < 10; ++k)
	{
		cout << "Enter a number to push: ";
		cin >> num;
		add(list_que, num);	
		print(list_que);
	}
	
	while (!empty(list_que))
	{
		cout << "Front " << front(list_que) << endl;
		remove(list_que);
		print(list_que);
	}
	
	
	cout << "Clearing" << endl;
	destr(list_que);					
}
