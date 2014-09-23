#include <iostream>
#include <string>
#include <sstream>

int main(int argc, char ** argv)
{    
    std::cout << "Please enter the grade you recieved in programming: ";
    
    int grade;
    std::string input;
    
    while(true)
    {
        getline(std::cin,input); //Recieve grade from user.
        std::stringstream temp(input);
        if (temp >> grade)
           {
                 if (grade >= 90 && grade <= 100)
                      std::cout << "Congratulations! You made an A!";
                 else if (grade >= 80 && grade < 90)
                      std::cout << "Congratulations! Your above average with a B!";
                 else if (grade >= 70 && grade < 80)
                      std::cout << "Boo! Your an average Joe with a C!";
                 else if (grade >= 60 && grade < 70)
                      std::cout << "Boo! You fail at life with a D!";
                 else if (grade >= 0 && grade < 60)
                      std::cout << "Failure! Try better slob! F!";
                 else 
                 { 
                      std::cout << "Please enter a valid grading number: "; 
                      continue; 
                 }
                 std::cout << std::endl << grade;
                 break;
           }
        else std::cout << "Invalid number, please try again: ";
    }
    
}
