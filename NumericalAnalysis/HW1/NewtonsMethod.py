#Newtons Method
import math
out = open("NewtonsOut.txt","w")
out.write("Newtons Method\n")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

#Here is its derivative
def der(x):
    return (1 + math.exp(x))

#Newton's Method
#Inputs are guess, tolerance, max iter, the function and its derivative 

def newtons(guess, tol, N, f, df):
    i = 0
    guesses = [guess]
    error = tol + 1 #some number bigger than tol
    while error > tol and i<N:
        info = "Iteration: {} x: {:.15f} Relative Error: {:.15f}".format(i, guesses[i],error)
        print(info)
        out.write(info + "\n")
        p0 = guesses[i]
        p = p0 - f(p0)/df(p0) 
        guesses.append(p)
        error =  math.fabs((guesses[i-1] - guesses[i])/guesses[i-1])
        i += 1
    info = "Iteration: {} x: {:.15f} Relative Error: {:.15f}".format(i, guesses[i],error)
    print(info)
    out.write(info + "\n")

def main():
    newtons(0.5, 0.0001, 50, fun, der)

main()
