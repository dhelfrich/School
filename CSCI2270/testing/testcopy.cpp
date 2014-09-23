#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
  int  * list = new int[40];
  int * list2 = new int[40];
  list[0] = 0; list[1] = 1; list[2] = 2;list[3] = 3; list[4] = 4;
  copy(list , list + 36 , list + 4);
  for(int i = 0; i<40; ++i)
  {
    cout << list[i] <<endl;
  }
  

  return 0;
}
