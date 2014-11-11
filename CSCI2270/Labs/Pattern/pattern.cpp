#include <cctype>          // Provides toupper
#include <iostream>        // Provides cout and cin
#include <cstdlib>         // Provides EXIT_SUCCESS
#include <string>
using namespace std;


// PROTOTYPES for functions used by this test program:
void pattern(ostream& outs, unsigned int n, unsigned int i);

int main()
{
  int i2;
  cout << "Enter an integer (a power of 2): ";
  cin >> i2;
  pattern(cout, i2, 0);
  cout << endl;
  return (EXIT_SUCCESS);
}

// i is the offset
// n is the asterisks
void pattern(ostream& outs, unsigned int n, unsigned int i)
{
    if(n > 0)
    {
        pattern(outs, n/2, i);
        outs << endl;
        for (unsigned int k = 0; k < i; ++k)//print out i spaces
            outs << " ";
        for (unsigned int k = 0; k < n; ++k)//print out n asterisks
            outs << "*";
        pattern(outs, n/2, i + n/2);
    }
}

