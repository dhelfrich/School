#Bisection Method
import math
out = open("BisectionOut.txt","w")
out.write("Bisection Method\n")

#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

def fun2(x):
    return (x - math.tan(x))

def fun3(x):
    return (x**3 - 25)

#Bisection algorthim
#a,b initial values, tolerance and max iterations N, with function f
def bisection(a,b,tol,N,f):
    i = 0
    p = (a + b)/2
    plist = [p]
    error = 100
    while error > tol and i < N:
        #print(i,a,b,p,f(p))
        mes = "Iteration: {}, a: {:.8f}, b: {:.8f}, p: {:.8f}  error = {:.8f}\n".format(i,a,b,p,error)
        print(mes)
        out.write(mes)
        if f(a)*f(p) > 0:
            a = p
        else:
            b = p
        p = (a + b)/2
        plist.append(p)
        i+=1
        error = math.fabs((plist[i]-plist[i-1])/plist[i-1])

    mes = "Iteration: {}, a: {:.8f}, b: {:.8f}, p: {:.8f}  error = {:.8f}\n".format(i,a,b,p,error)
    print(mes)
    out.write(mes)

def main():
    bisection(2.5,3,0.0001,30,fun3)

main()

