#Bisection Method
import math
#This is the function we will be studying
out = open("BisectionOut.txt","w")
out.write("Bisection Method")

def fun(x):
    return (x + math.log(x))

#Bisection algorthim
#a,b initial values, tolerance and max iterations N, with function f
def bisection(a,b,tol,N,f):
    i = 0
    p = (a + b)/2
    while math.fabs(f(p)) > tol and i < N:
        #print(i,a,b,p,f(p))
        print("Iteration: {}, a: {:.5f}, b: {:.5f}, p: {:.5f}, f(p): {:.5f}".format(i,a,b,p,f(p)))
        out.write("Iteration: {}, a: {:.5f}, b: {:.5f}, p: {:.5f}, f(p): {:.5f}\n".format(i,a,b,p,f(p)))
        if f(a)*f(p) > 0:
            a = p
        else:
            b = p
        i+=1
        p = (a + b)/2
    print("Iteration: {}, a: {:.5f}, b: {:.5f}, p: {:.5f}, f(p): {:.5f}".format(i,a,b,p,f(p)))
    out.write("Iteration: {}, a: {:.5f}, b: {:.5f}, p: {:.5f}, f(p): {:.5f}\n".format(i,a,b,p,f(p)))

def main():
    bisection(0.01,1,0.0001,30,fun)

main()
