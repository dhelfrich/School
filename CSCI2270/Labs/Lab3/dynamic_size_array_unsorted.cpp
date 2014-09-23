#include "dynamic_size_array_unsorted.h"

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
  arr.data[arr.count] = payload;
  ++arr.count;
}

bool remove(int_array& arr, const int& target)
{
  if(!contains(arr, target))
    return false;
  else{
    for(unsigned int i = 0; i < arr.count; ++i){
      if(arr.data[i] == target){
        arr.count--;
        /*for(unsigned j = 0; j < arr.count; ++j){
          arr.data[i+j] = arr.data[i+1+j];
        }
        break; //just so we only remove the first ocurrence */
        arr.data[i] = arr.data[arr.count];
      }
    }
    return true;
  }
}

