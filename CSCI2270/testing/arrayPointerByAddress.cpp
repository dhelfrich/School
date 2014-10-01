#include <iostream>
using namespace std;

void flobo(const int*& array)
{
    int* arr_replace = new int[5];
    arr_replace[0] = 10; arr_replace[1] = 11; arr_replace[2] = 12; arr_replace[3] = 13; arr_replace[4] = 14;
    array = arr_replace;
}
int main()
{

    int* arr = new int[5];
    arr[0] = 0; arr[1] = 1; arr[2] = 2; arr[3] = 3; arr[4] = 4;
    const int* arr_const = arr;
    for(int i = 0; i<5; i++) 
    {
        cout << arr_const[i] << endl;
    }

    flobo(arr_const);

    for(int i = 0; i<5; i++) 
    {
        cout << arr_const[i] << endl;
    }

    return 0;
}
