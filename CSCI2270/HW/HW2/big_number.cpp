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
    head_ptr = nullptr;
    tail_ptr = nullptr;
    digits = m.digits;
    positive = m.positive;
    base = m.base;
    copy_list(m.head_ptr, head_ptr, tail_ptr);

}


// create a big_number from a string
big_number::big_number(const string& s, unsigned int b)
{

    digits = 0;
    unsigned index = 0;
    positive = true;
    base = b;
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
    head_ptr = nullptr;
    tail_ptr = nullptr;
    
    while ( s[index] == '0' ) //remove leading zeroes
    {
        if ( index + 1 < s.length() ) //only remove leading zeroes if it's not the last digit
            index++;
        else //get here if input is zero
        {
            positive = true; //zero is positive!
            break;
        }
            
    }

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
    clear_list( head_ptr, tail_ptr );
    digits = 0;
    base = 0;
    positive = 0;
}

// assignment operator
big_number& big_number::operator=(const big_number& m)
{
    if (this == &m)
        return *this;

    head_ptr = nullptr;
    tail_ptr = nullptr;
    digits = m.digits;
    positive = m.positive;
    base = m.base;
    copy_list(m.head_ptr, head_ptr, tail_ptr);

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
    if ( compare(a,b) == 'G')
        return true;
    else
        return false;

}

bool operator >=(const big_number& a, const big_number& b)
{
    if ( compare(a,b) == 'G' || compare(a,b) == 'E')
        return true;
    else
        return false;
}

bool operator <(const big_number& a, const big_number& b)
{
    if ( compare(a,b) == 'L' )
        return true;
    else
        return false;
}

bool operator <=(const big_number& a, const big_number& b)
{
    if ( compare(a,b) == 'L' || compare(a,b) == 'E')
        return true;
    else
        return false;
}

bool operator==(const big_number& a, const big_number& b)
{
    if (compare(a,b) == 'E')
        return true;
    else
        return false;
}

bool operator!=(const big_number& a, const big_number& b)
{
    if (compare(a,b) != 'E')
        return true;
    else
        return false;
}

ostream& operator <<(ostream& out, const big_number& n)
{

    if ( n.positive == false ) //if negative, print the negative sign
        out << '-';

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
    string number;
    in >> number; 
    n = big_number (number, 10);
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

//Helper functions


//returns 'G' 'L' or 'E' for >, <, or == respectively 
char absoluteValueCompare (const big_number& a, const big_number& b)
{
    if (a.digits > b.digits )
        return 'G';
    else if (a.digits < b.digits)
        return 'L';
    else //compare digits starting after 1
    {
        node* cursor_a = a.head_ptr;
        node* cursor_b = b.head_ptr;
        for (unsigned i = 0; i < a.digits; i++) 
        {
            if (cursor_a->data > cursor_b->data)
                return 'G';
            else if(cursor_a->data < cursor_b->data )
                return 'L';
            cursor_a = cursor_a->next;
            cursor_b = cursor_b->next;
        }
        return 'E'; 
    } 
}

//returns 'G' 'L' or 'E' based on sign only for >, <, or == respectively 

char signCompare (const big_number& a, const big_number& b)
{
    if ( a.positive == b.positive )
        return 'E';
    else if ( a.positive )
        return 'G';
    else
        return 'L';
}

char compare  (const big_number& a, const big_number& b)
{
    if ( signCompare(a,b) == 'E' )
        return absoluteValueCompare(a, b);
    else
        return signCompare(a,b);
    
}
