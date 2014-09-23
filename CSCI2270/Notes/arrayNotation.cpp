#include <iostream>
using namespace std;

int main()
{
    int arr [4] = {0,1,2,3};
    cout << arr << " " << arr + 1 << " " << (arr + 1)[0] << " " << (arr + 1)[1] <<endl;
    //int darray [4] [3] = {{0,1,2},{0,2,4},{0,3,6},{0,4,8}};
    int darray** = new int [4][3];
    for(int i = 0; i < 4; i++)
        for(int j = 0; j < 3; j++) 
            cout << darray[i][j] << endl;
    return 0;
}
