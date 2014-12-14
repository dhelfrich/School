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
    base = 10;
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

//conversion contructor, converts a bignum into another base
//convert from m.base to b.
big_number::big_number(const big_number& m, unsigned int b)
{
    if(m.base == b)//if it's the same base
    {
        *this = m;
    }
    else
    {
        //head_ptr = nullptr;
        //tail_ptr = nullptr;
        *this = big_number();
        positive = m.positive;
        base = b;
        unsigned int k = m.base;
        char digit_c;
        unsigned int index;
        //first convert 0..k to base b. Store result in array
        big_number *k_digits = new big_number [k+1];
        //fill array using string constructor
        string digit = "0";
        k_digits [0] = big_number(digit, b);
        for (unsigned int i = 1; i < k+1; ++i)
        {    
            digit = ""; 
            unsigned int remainder = i;
            while(remainder > 0)
            {
                digit_c = alpha[remainder % b];
                remainder = remainder / b;
                digit.insert(0, 1, digit_c);
            }
            k_digits [i] = big_number(digit, b);     
        }
        //now that we have the alphabet, we can convert m into the new base
        node* cursorm = m.head_ptr;
        string mdigitstring = "";
        while (cursorm != nullptr)
        {
            *this = *this * k_digits[k];
            index = alpha.find(cursorm->data);
            *this = *this + k_digits[index];
            cursorm = cursorm->next;
        }
        delete [] k_digits;
    }
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
    *this = *this + b;
    return *this;
}

// set value to original value * b; return answer in original number's base
big_number& big_number::operator*= (const big_number& b)
{
    *this = *this * b;
    return *this;
}

// set value to original value - b; return answer in original number's base
big_number& big_number::operator-= (const big_number& b)
{
    *this = *this - b;
    return *this;
}

// set value to original value / b; return answer in original number's base
/*
big_number& big_number::operator/= (const big_number& b)
{
    return *this;
}

// set value to original value * b; return answer in original number's base
big_number& big_number::operator%= (const big_number& b)
{
    return *this;
}
*/

// prefix increment
big_number& big_number::operator++()
{
    *this = *this + big_number("1",base);
    return *this;
}

// prefix decrement
big_number& big_number::operator--()
{
    *this = *this - big_number("1",base);
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
    if (a.base == b.base)
    {
        if (a.positive == b.positive)//if it's essentially a sum
        {
            if(a.digits > b.digits) //add b to a
            {
                answer = a;
                answer.sum(b);
            }
            else
            {
                answer = b;
                answer.sum(a);
            }
        }
        else
        {
            if(absoluteValueCompare(a,b) == 'G')
            {
                answer = a;
                answer.minus(b);
            }
            else
            {
                answer = b;
                answer.minus(a);
            }
        } 
        return answer;
    }
    else
        return a + big_number(b, a.base);
}

big_number operator-(const big_number& a, const big_number& b)
{
    big_number answer;
    if (a.base == b.base)
    {
        big_number bcopy(b);
        if(bcopy.positive)
            bcopy.positive = false;
        else if(!bcopy.positive)
            bcopy.positive = true;
        return a + bcopy;
    }
    else
        return a - big_number(b, a.base);
}

big_number operator*(const big_number& a, const big_number& b)
{
    big_number answer; 
    if (a.base == b.base)
    {
        answer = a;
        answer.mult(b);
        if (a.positive == b.positive)
            answer.positive = true;
        else
            answer.positive = false;
        return answer;
    }
    else
        return a * big_number(b, a.base);
}

/*
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
*/

big_number factorial(const big_number& a)
{
    if (a.digits == 1 && a.head_ptr->data == '0')// a == 0
        return big_number("1",a.base);
    else
    {
        return factorial(a - big_number(1)) * a;
    }
}

big_number tail_factorial(big_number n, big_number accumulator)
{
    while (n != 0) 
    {
        accumulator *= n;
        --n;
    }
    return accumulator;
}

//Helper functions
// helper function: assume |*this| >= |m|
big_number& big_number::sum(const big_number& m)
{
    node* cursor = tail_ptr;
    const node* mcursor = m.tail_ptr;
    digits = 0;  // a little scary, but let's roll with it anyway
    unsigned int dig1, dig2, result;
    unsigned int carry = 0;
    while (cursor != nullptr && mcursor != nullptr)
    {
        // we added an alphabet string to the big_number.h
        dig1 = alpha.find(cursor->data);
        dig2 = alpha.find(mcursor->data);
        result = carry + dig1 + dig2;
        if (result >= base) // we have to carry
        {
            // this code is simpler, more correct and more elegant; 
            // thanks to Audi Li!
            cursor->data = alpha[result % base];
            carry = 1;
        }
        else // we don't have to carry
        {
            cursor->data = alpha[result];
            carry = 0;
        }
        cursor = cursor->prev;
        mcursor = mcursor->prev;
        ++digits;
    }
    while (cursor != nullptr)
    {
        dig1 = alpha.find(cursor->data);
        result = carry + dig1;
        if (result >= base) // carry
        {
            cursor->data = alpha[result % base];
            carry = 1;
        }
        else // no carry
        {
            cursor->data = alpha[result];
            carry = 0;
        }
        cursor = cursor->prev;
        ++digits;
    }
    if (carry > 0)
    {
        add_node_head(head_ptr, tail_ptr, '1');
        ++digits;
    }
    return *this;
}

// helper function: assume |*this| >= |m|
big_number& big_number::minus(const big_number& m)
{
    node* cursor = tail_ptr;
    const node* mcursor = m.tail_ptr;
    int dig1, dig2, result;
    int borrow = 0;
    while (cursor != nullptr && mcursor != nullptr)
    {
        dig1 = alpha.find(cursor->data) - borrow; //take away borrow
        dig2 = alpha.find(mcursor->data);
        if (dig1 < dig2)
        {
            result = base + dig1 - dig2;
            borrow = 1;
        }
        else //no borrow
        {
            result = dig1 - dig2;
            borrow = 0;
        }
        cursor->data = alpha[result]; 
        cursor = cursor->prev;
        mcursor = mcursor->prev;
    }
    while (cursor != nullptr) //same as above..replace dig2 with 0
    {
        dig1 = alpha.find(cursor->data) - borrow; //take away borrow
        if (dig1 < 0)
        {
            result = base + dig1;
            borrow = 1;
        }
        else //no borrow
        {
            result = dig1;
            borrow = 0;
        }
        cursor->data = alpha[result]; 
        cursor = cursor->prev;
    }
    this->trim();
    return *this;
}

//helper function..remove leading zeroes
void big_number::trim()
{
    while (digits > 1 && head_ptr->data == '0')
    {
        --digits;
        remove_node(head_ptr, tail_ptr, '0');
    }
    if (digits == 1)
        positive = true;
}

// helper function: assume |*this| >= |m| and same base
big_number& big_number::mult(const big_number& m)
{
    big_number answer;
    answer.base = base;
    node* cursor = m.tail_ptr;
    int n = 0; //the digit we're looking at
    while(cursor != nullptr)
    {
        answer = answer + this->mult_digit_plus_zeros(cursor->data,n);
        ++n;
        cursor = cursor->prev;
    }
    *this = answer;
    this->trim();
    return *this;
}

//multiply by a single digit;
big_number& big_number::mult_digit(char d)
{
    int n = alpha.find(d);
    node* cursor = tail_ptr;
    digits = 0;  
    unsigned int dig1, result;
    unsigned int carry = 0;
    while (cursor != nullptr)
    {
        dig1 = alpha.find(cursor->data);
        result = carry + dig1 * n;
        cursor->data = alpha[result % base];
        carry = result/base;
        cursor = cursor->prev;
        ++digits;
    }
    if (carry > 0)//if we need to add another digit
    {
        add_node_head(head_ptr, tail_ptr, alpha[carry]);
        ++digits;
    }
    this->trim();
    return *this;
}

//multiply by digit  * b^n
big_number big_number::mult_digit_plus_zeros(char d, unsigned int n)
{
    big_number new_num(*this);
    new_num.mult_digit(d);
    for (unsigned int i = 0; i < n; ++i)
    {
        add_node_tail(new_num.head_ptr, new_num.tail_ptr, '0');
        ++new_num.digits;
    }
    return new_num;
}

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
    {
        if (!a.positive)//if both negative
        {
            if (absoluteValueCompare(a,b) == 'L')
                return 'G';
            else if (absoluteValueCompare(a,b) == 'G')
                return 'L';
            else
                return absoluteValueCompare(a,b);
        } 
        else
            return absoluteValueCompare(a, b);
    }
    else
        return signCompare(a,b); 
}
