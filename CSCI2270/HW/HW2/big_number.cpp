#include "big_number.h"

using namespace std;

// default constructor, creates a 0
big_number::big_number()
{
    head_ptr = nullptr;
    tail_ptr = nullptr;
    add_node_head(head_ptr, tail_ptr, '0');
    digits = 1;
    positive = true;
    base = 10;
}

// int constructor; create big_number from base 10 integer
big_number::big_number(int i)
{
    digits = 0;
    head_ptr = nullptr;
    tail_ptr = nullptr;
    if (i==0)
    {
        big_number zero;
        *this = zero;
    }
    else
    {
        if (i<0)
        {
            positive = false;
            i *= -1;
        }
        else 
            positive = true;
        while ( i != 0 )
        {
            add_node_head(head_ptr, tail_ptr, (i % 10) + '0');
            ++digits;
            i /= 10;
        }
    }

}

// copy constructor, creates a deep copy of m
big_number::big_number(const big_number& m)
{

}

// create a big_number from a string
big_number::big_number(const string& s, unsigned int b)
{

    digits = 0;
    unsigned index = 0;
    positive = true;
    if (s[0] == '-')
    {
        positive = false;
        ++index;
    }
    if (s[0] == '+')
    {
        ++index;
    }
    head_ptr = new node;
    head_ptr->next = nullptr;
    head_ptr->prev = nullptr;
    tail_ptr = head_ptr;

    while ( index < s.length()  )
    {
        add_node_tail(head_ptr, tail_ptr, s[index]);
        ++digits;
        ++index;
    }

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
    node* cursor = n.head_ptr;

    for (unsigned i = 0; i < n.digits; i++)
    {
        out << cursor->data;
        cursor = cursor->next;
    }
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


