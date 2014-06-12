#Secant Method
import math
out = open("SecantOut.txt","w")
out.write("Secant Method\n")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

#Secant Method
#Inputs are guess1, guess2, tolerance, max iter, and the function 

def secant(guess1, guess2, tol, N, f):
    i = 1
    guesses = [guess1, guess2]
    error = tol + 1
    while error > tol and i<N:
        info = "Iteration: {} x: {:.15f} Relative Error: {:.15f}".format(i, guesses[i],error)
        print(info)
        out.write(info + "\n")
        #Change notation to p0, p1, .... etc
        p0 = guesses[i-1]
        p1 = guesses[i]
        q0 = f(p0)
        q1 = f(p1)
        p = p1 - q1*(p1-p0)/(q1-q0) 
        guesses.append(p)
        error =  math.fabs((guesses[i-1] - guesses[i])/guesses[i-1])
        i += 1

    info = "Iteration: {} x: {:.15f} f(x): {:.15f}".format(i, guesses[i], fun(guesses[i]))
    print(info)
    out.write(info + "\n")

def main():
    secant(-1.45,5, 0.0001, 50, fun)

main()
