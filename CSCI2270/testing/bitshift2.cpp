#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    for(int i; i < 1000000000; i++)
    {
        int a = 3;
        int b = 2*a;
        if(i%100000000 == 0)
            printf("%d \n",b);
    }
}
