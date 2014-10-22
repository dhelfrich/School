#include "big_number.h"

using namespace std;

// default constructor, creates a 0
big_number::big_number()
{

}

// int constructor; create big_number from base 10 integer
big_number::big_number(int i)
{

}

// copy constructor, creates a deep copy of m
big_number::big_number(const big_number& m)
{

}

// create a big_number from a string
big_number::big_number(const string& s, unsigned int b)
{

}

// destructor
big_number::~big_number()
{

}

// assignment operator
big_number& big_number::operator=(const big_number& m)
{
	return *this;
}

// set value to original value + b; return answer in original number's base
big_number& big_number::operator+= (const big_number& b)
{
	return *this;
}

// set value to original value * b; return answer in original number's base
big_number& big_number::operator*= (const big_number& b)
{
	return *this;
}

// set value to original value - b; return answer in original number's base
big_number& big_number::operator-= (const big_number& b)
{
	return *this;
}

// set value to original value / b; return answer in original number's base
big_number& big_number::operator/= (const big_number& b)
{
	return *this;
}

// set value to original value * b; return answer in original number's base
big_number& big_number::operator%= (const big_number& b)
{
	return *this;
}

// prefix increment
big_number& big_number::operator++()
{
	return *this;
}

// prefix decrement
big_number& big_number::operator--()
{
	return *this;
}

bool operator >(const big_number& a, const big_number& b)
{
	return false;
}

bool operator >=(const big_number& a, const big_number& b)
{
	return false;
}

bool operator <(const big_number& a, const big_number& b)
{
	return false;
}
			
bool operator <=(const big_number& a, const big_number& b)
{
	return false;
}
			
bool operator==(const big_number& a, const big_number& b)
{
	return false;
}
	
bool operator!=(const big_number& a, const big_number& b)
{
	return false;
}

ostream& operator <<(ostream& out, const big_number& n)
{
	return out;
}

istream& operator >>(istream& in, big_number& n)
{
	return in;
}

big_number operator+(const big_number& a, const big_number& b)
{
	big_number answer;
	return answer;
}

big_number operator-(const big_number& a, const big_number& b)
{
	big_number answer;
	return answer;
}

big_number operator*(const big_number& a, const big_number& b)
{
	big_number answer;
	return answer;
}

big_number operator/(const big_number& a, const big_number& b)
{
	big_number answer;
	return answer;
}

big_number operator%(const big_number& a, const big_number& b)
{
	big_number answer;
	return answer;
}

big_number factorial(const big_number& a)
{
	big_number answer;
	return answer;
}


