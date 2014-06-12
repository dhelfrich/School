#Secant Method
import math
out = open("SecantOutBook.txt","w")
out.write("Secant Method")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

#sample function from book

def sample(x):
    return (math.cos(x)-x)
#Secant Method
#Inputs are guess1, guess2, tolerance, max iter, and the function 

def secant(guess1, guess2, tol, N, f):
    i = 0
    guesses = [guess1, guess2]
    while math.fabs(fun(guesses[i])) > tol and i<N:
        info = "Iteration: {} x: {:.10f}".format(i, guesses[i])
        print(info)
        out.write(info + "\n")
        i += 1
        #Change notation to p0, p1, .... etc
        p0 = guesses[i-1]
        p1 = guesses[i]
        q0 = f(p0)
        q1 = f(p1)
        p = p1 - q1*(p1-p0)/(q1-q0) 
        guesses.append(p)

    info = "Iteration: {} x: {:.10f} f(x): {:.10f}".format(i, guesses[i], fun(guesses[i]))
    print(info)
    out.write(info + "\n")

def main():
    secant(0.5,math.pi/4, 0.0001, 50, sample)

main()
