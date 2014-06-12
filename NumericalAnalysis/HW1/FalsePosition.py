#FalsePosition Method
import math
out = open("FalsePositionOut.txt","w")
out.write("FalsePosition Method \n")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

def sample(x):
    return (math.cos(x)-x)

#FalsePosition Method
#Inputs are guess1, guess2, tolerance, max iter, and the function 

def false(guess1, guess2, tol, N, f):
    i = 1
    p0 = guess1
    p1 = guess2
    q0 = f(p0)
    q1 = f(p1)
    info = "Iteration: {} x: {:.15f}".format(0, p0)
    print(info)
    out.write(info + "\n")
    while math.fabs(f(p1)) > tol and i<N:
        info = "Iteration: {} x: {:.15f}".format(i, p1)
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

    info = "Iteration: {} x: {:.15f} f(x): {:.15f}".format(i, p1, f(p1))
    print(info)
    out.write(info + "\n")

def false2(a,b,tol,N,f):
    i = 0
    p0 = a
    p1 = b
    q0 = f(p0)
    q1 = f(p1)
    p = p1 - q1*(p1-p0)/(q1-q0)
    #set lside and rside to true if they have been halved already
    lside = False
    rside = False
    while math.fabs(f(p)) > tol and i < N:
        #print(i,a,b,p,f(p))
        info = "Iteration: {}, a: {:.15f}, b: {:.15f}, new point: {:.15f}, f(p): {:.15f}".format(i,p0,p1,p,f(p))
        print(info)
        out.write(info + "\n")
        i+=1
        q0 = f(p0)
        q1 = f(p1)
        p = p1 - q1*(p1-p0)/(q1-q0)
        q = f(p)
        if q*q1 > 0:
            print("left moved")
            p1 = p
        elif q*q0 > 0:
            p0 = p
    info = "Iteration: {}, a: {:.15f}, b: {:.15f}, new point: {:.15f}, f(p): {:.15f}".format(i,p0,p1,p,f(p))
    print(info)
    out.write(info + "\n")

def false3(a, b, tol, N, f):
    i = 1
    error = tol + 1
    a = a
    b = b
    while error > tol and i<N:
        info = "Iteration: {} a: {:.15f} b: {:.15f} Relative Error: {:.15f}".format(i, a, b,error)
        print(info)
        out.write(info + "\n")
        p = b - f(b)*(b-a)/(f(b)-f(a))
        #Change notation to p0, p1, .... etc
        #if sign change between f(a) and f(p) b <- p
        if f(a)*f(p) < 0:
            error =  math.fabs((p-b)/b)
            b = p
        elif f(b)*f(p) < 0:
            error =  math.fabs((p-a)/a)
            a = p
        else:
            print("something's wrong")
        i += 1

 
    info = "Iteration: {} a: {:.15f} b: {:.15f} Relative Error: {:.15f}".format(i, a, b,error)
    print(info)
    out.write(info + "\n")                                                                                         

def main():
    false3(-3,3, 0.0001, 50, fun)
    #the one in the book 
    #false2(0.5,math.pi/4, 0.000000001, 50, sample) 

main()
