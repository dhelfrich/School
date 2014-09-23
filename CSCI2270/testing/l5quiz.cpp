#include <iostream>
using namespace std;

int floo(int& a, const int& b, int c)

{

     a = b / 2;

     c = 4 * b;

     return a * b;

}

int main()

{

     int q = 7;

     int r = 23;

     int s = 13;

     cout << floo(r, s, q) << endl;

     cout << r << endl;

     cout << s << endl;

     cout << q << endl;

}

/*
What will the line 

     cout << floo(r, s, q) << endl;
     */
