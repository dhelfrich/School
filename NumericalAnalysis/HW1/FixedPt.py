#Fixed point iteration method
import math
out = open("FixedPtOut.txt","w")
out.write("FixedPt Method \n")

#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))


#Here is what we need after solving x + exp(x) = 0 for x, g(x) = -exp(x)
def g1(x):
    return (-math.exp(x))

def fun3a(x):
    return (-2*math.sin(math.pi*x))

def fun3b(x):
    return (math.asin(-x/2)/math.pi)

#Fixed pt iter algorithm requires initial guess, tol, max iter, and function for inputs
def fixedPtIter(guess,tol,N,g):
    guesses = [guess, g(guess)]
    i = 0
    info = "Iteration: {} x: {:.15f}  error: N/A".format(i, guesses[i])
    print(info)
    out.write(info + "\n")
    i = 1 
    error = tol + 1
    while error > tol and i<N:
        error =  math.fabs((guesses[i-1] - guesses[i])/guesses[i-1])
        info = "Iteration: {} x: {:.15f}  error: {:.15f}".format(i, guesses[i],error)
        print(info)
        out.write(info + "\n")
        guesses.append(g(guesses[i]))
        i += 1

    info = "Iteration: {} x: {:.15f}  error: {:.15f}".format(i, guesses[i],error)
    print(info)
    out.write(info + "\n")

def main():
    fixedPtIter(1, 0.01, 50, fun3b)

main()
