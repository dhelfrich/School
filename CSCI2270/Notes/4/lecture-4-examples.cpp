#include <iostream>

using namespace std;

void plus_plus_example_1()
{
  int n = 5;
  while (n < 20)
  {	
    cout << ++n << " ";
    cout << n++ << endl;
  }
}

void plus_plus_example_1b()
{
  int n = 5;
  while (n < 20)
  {	
    cout << n++ << " ";
    cout << ++n << endl;
  }
}
void plus_plus_example_2()
{
  int b[4]; 
  b[0] = 1; b[1] = 3; b[2] = 9; b[3] = 27;

  int n = 0;
  while (n < 4)
    cout << b[n++] << endl;
  n = 0;
  while (n < 4)
    cout << b[++n] << endl;
}

void plus_plus_example_3()
{
  int b[4];
  int* b_ptr = &(b[0]);
  b[0] = 1; 	b[1] = 2; 	b[2] = 4;	b[3] = 8;
  for (int i = 0; i < 4; i++)
  {
    cout << *(++b_ptr) << endl;
  }
}


void example_with_a()
{
  int a = 5;		// a is born!
}					// a is killed. :(

void example_loop_ok()
{
  for (int a = 5; a < 20; a++)
  {
    cout << a << endl;
  }
}

/*
   void example_loop_not_ok()
   {
   for (int a = 5; a < 20; a++)
   {
   cout << a << endl;
   }
   cout << a << endl;
   }
   */
int triple_a_number_1(int starting_number)
{
  starting_number *= 3;	
  return starting_number;
}

int triple_a_number_2(int& starting_number)
{
  starting_number *= 3;
  return starting_number;
}	

/*
   int triple_a_number_3(const int& starting_number)
   {
   starting_number *= 3; // NO, compile error
   return starting_number;
   }	
   */

int get_a_number_1()
{
  int answer;
  cout << "Tell me a number: " << endl;
  cin >> answer;
  return answer;
}	

int& get_a_number_2()
{
  int answer;
  cout << "Tell me a number: " << endl;
  cin >> answer;
  return &answer;
}	


int main()
{
  //    plus_plus_example_1b();
  //    plus_plus_example_2();
  plus_plus_example_3();

  int lebowski = 9;
  cout << triple_a_number_1(lebowski) << endl;
  cout << lebowski << endl;

  int bob = 9;
  cout << triple_a_number_2(bob) << endl;
  cout << bob;

  int number = get_a_number_1();
  cout << "You entered " << number << endl;

  int other_number = get_a_number_2();
  cout << "You entered " << other_number << endl;
}
