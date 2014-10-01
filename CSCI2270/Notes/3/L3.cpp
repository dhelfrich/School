#include <iostream>

using namespace std;

void example11()
{
	int b[4];
	b[0] = 1; 	b[1] = 2; 	b[2] = 4;	b[3] = 8;
	for (int i = 0; i < 4; i++)
		cout << b[i] << endl;
}

void example12()
{
	int b[4];
	int* b_ptr = (&b[0]);
	b[0] = 1; 	b[1] = 2; 	b[2] = 4;	b[3] = 8;
	for (int i = 0; i < 4; i++)
	{
		cout << b_ptr << " " << *b_ptr << endl;
		b_ptr++;
	}
}

void example13()
{
	int b[4];
	int* b_ptr;
	b[0] = 1; 	b[1] = 2; 	b[2] = 4;	b[3] = 8;
	for (b_ptr = &(b[0]); b_ptr != &(b[4]); b_ptr+=2)
	{
		cout << b_ptr << " " << *b_ptr << endl;
	}
}


int main()
{
//	example11();
	example12();
//	example13();
}
