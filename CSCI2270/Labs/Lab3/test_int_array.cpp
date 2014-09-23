#include "dynamic_size_array_unsorted.h"

using namespace std;


int main()
{
	int_array arr;
	int num;
	
	init(arr);
	
	for (unsigned int i = 0; i < 15; ++i)
	{
		cout << "Enter a number to add: ";
		cin >> num;
		add(arr, num);
		print(arr);
                cout << "count = " << arr.count <<" capacity = " << arr.capacity << endl;
	}
	
	
        for (unsigned int i = 0; i < 15; ++i)
	{
		cout << "Enter a number to remove: ";
		cin >> num;
		remove(arr, num);
		print(arr);
	}
        
	


        /*
        if (contains(arr, 7) == true) 
          cout << "7 is in there" << endl;
        else
          cout << "7 is not in there" << endl;
        */

	clear(arr);
	add(arr, 7);
	print(arr);
	
        

	destr(arr);
}
