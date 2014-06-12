#FalsePositionBook Method
import math
out = open("FalsePositionBookOut.txt","w")
out.write("FalsePositionBook Method")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

def sample(x):
    return (math.cos(x)-x)

#FalsePositionBook Method
#Inputs are guess1, guess2, tolerance, max iter, and the function 

def false(guess1, guess2, tol, N, f):
    i = 1
    p0 = guess1
    p1 = guess2
    q0 = f(p0)
    q1 = f(p1)
    info = "Iteration: {} x: {:.10f}".format(0, p0)
    print(info)
    out.write(info + "\n")
    while math.fabs(f(p1)) > tol and i<N:
        info = "Iteration: {} x: {:.10f}".format(i, p1)
        print(info)
        out.write(info + "\n")
        p = p1 - q1*(p1-p0)/(q1-q0)
        #Change notation to p0, p1, .... etc
        i += 1
        q = f(p)
        if q*q1 < 0:
            p0 = p1
            q0 = q1
        p1 = p 
        q1 = q

    info = "Iteration: {} x: {:.10f} f(x): {:.10f}".format(i, p1, f(p1))
    print(info)
    out.write(info + "\n")

def main():
    false(0.5,math.pi/4, 0.0000000001, 50, sample)

main()
