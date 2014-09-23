#include "string"
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

string shift(string s, int shift)
{
	int i = 0;
	while(s[i])
	{
		if ('a' <= s[i] && s[i] <= 'z')
		{
			s[i] = (s[i] - 'a' + shift)%26 + 'a'; 
		}

		if ('A' <= s[i] && s[i] <= 'Z')
		{
			s[i] = (s[i] - 'A' + shift)%26 + 'A'; 
		}
		i++;
	}
	return s;
}


int main()
{
	string output = shift("hello", 1);
	printf("%s \n", output.c_str() );
	cout << output << endl;
	return 0;
}
