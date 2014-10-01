#include <iostream>
#include <string.h>
using namespace std;

string& get_a_string()
{

    string* answer = new string;

    cout << "Tell me a word: " << endl;

    cin >> *answer;

    return *answer;
}

int main()

{

    string user_input = get_a_string();

    cout << "You entered " << user_input << endl;
}
