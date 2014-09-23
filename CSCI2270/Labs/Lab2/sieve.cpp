#include <iostream>
#include <vector>
using namespace std;

int main()
{
    unsigned int array_size;

    cout << "Find primes from 0 to what? ";
    cin >> array_size;

    array_size++;

    vector <bool> prime_numbers(array_size,1);
    prime_numbers[0] = false;
    prime_numbers[1] = false;

    unsigned int counter = 2;

    //for(unsigned int k = 0; k < array_size; k++)
    //	prime_numbers[k] = true;

    for(unsigned j = 2; j < array_size; j++)
    {
        if(prime_numbers[j] == true)
        {
            counter = j;
            for (unsigned int i = j*2; i < array_size; i+= counter)
            {
                prime_numbers[i] = false;	
            }
        }
    }

    for(unsigned int k = 0; k < array_size; k++)
        cout << k << " " << prime_numbers[k] << endl;
    return 0;
}
