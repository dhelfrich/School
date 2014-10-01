#include <iostream>

using namespace std;

bool binary_contains1(const int* arr, unsigned int first, 
	unsigned int last, int target)
{
	// base cases come first...
	
	return false;
}  

bool binary_contains2(const int* arr, unsigned int size, int target)
{
	return false;
}

int main()
{
	int target;
	int array[10] = {1, 6, 17, 22, 24, 26, 27, 35, 51, 98};
	for (unsigned int k = 0; k < 10; ++k)
		cout << array[k] << " ";
	cout << endl;
	cout << "Enter a number to search for: ";
	cin >> target;
	if (binary_contains1(array, 0, 9, target))
		cout << "target " << target << " found" << endl;
	else
		cout << "target " << target << " not found" << endl;
//	if (binary_contains2(array, 10, target))
//		cout << "target " << target << " found" << endl;
//	else
//		cout << "target " << target << " not found" << endl;
		
}
