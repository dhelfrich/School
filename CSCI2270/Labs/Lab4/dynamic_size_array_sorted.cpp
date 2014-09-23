#include "dynamic_size_array_sorted.h"

using namespace std;


void init(int_array& arr)
{
  arr.capacity = arr.DEFAULT_CAPACITY;
  arr.data = new int[arr.capacity];
  arr.count = 0;
  
}

void clear(int_array& arr)
{
  arr.count = 0;
}

void destr(int_array& arr)
{
  delete [] arr.data;
  arr.count = 0;
}

void print(const int_array& arr)
{
  for (unsigned int i = 0; i < arr.count; ++i)
    cout << arr.data[i] << " ";
  cout << endl;
}

bool contains(const int_array& arr, const int& target)
{
  for (unsigned int q = 0; q < arr.count; ++q){
    if(arr.data[q] == target){
      return true;
    }
  }
  return false;
}

void resize(int_array& arr)
{
  arr.capacity *= 2;
  int* bigbigbigarray = new int[arr.capacity];
  for (unsigned int q = 0; q < arr.count; ++q)
    bigbigbigarray[q] = arr.data[q];
  delete [] arr.data;
  arr.data = bigbigbigarray;
}

void add(int_array& arr, const int& payload)
{
  if (arr.count >= arr.capacity)
    resize(arr);
  int key = payload;
  int i = arr.count - 1;

  //shift the contents of the array until the element is bigger than key
  while(i >= 0 && arr.data[i] > key)
  {
    arr.data[i+1] = arr.data[i];
    --i;
  }
  arr.data[i+1] = key;
  ++arr.count;
}

//removes and an element while maintaining order
//returns false if the element is not in the array
bool remove(int_array& arr, const int& target)
{
  for(unsigned int i = 0; i < arr.count; ++i)
  {
    //if the target is there, shift the contents until the end.
    if(arr.data[i] == target)
    {
      while(i < arr.count)
      {
        arr.data[i] = arr.data[i+1];
        i++; 
      }
      -- arr.count;
      return true;
    } 
  }
  return false; 
}

