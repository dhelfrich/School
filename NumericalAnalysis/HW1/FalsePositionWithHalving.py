#FalsePositionWithHalving Method
import math
out = open("FalsePositionWithHalvingOut.txt","w")
out.write("FalsePositionWithHalving Method: \n")


#This is the function we will be studying
def fun(x):
    return (x + math.exp(x))

def sample(x):
    return (math.cos(x)-x)

#This comes from wikipedia to show failure of this method

def wiki(x):
    return (2*x**3 - 4*x**2 + 3*x)

#FalsePositionWithHalving Method
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
 
def false2(a,b,tol,N,f):
    i = 0
    p0 = a
    p1 = b
    q0 = f(p0)
    q1 = f(p1)
    p = p1 - q1*(p1-p0)/(q1-q0)
    q = f(b)
    #set lside and rside to true if they have been halved already
    q0halved = False
    q1halved = False
    while math.fabs(f(p)) > tol and i < N:
        #print(i,a,b,p,f(p))
        info = "Iteration: {}, a: {:.10f}, b: {:.10f}, new point: {:.10f}, f(p): {:.10f}".format(i,p0,p1,p,f(p))
        print(info)
        out.write(info + "\n")
        i+=1
        p = p1 - q1*(p1-p0)/(q1-q0)
        q = f(p)
        if q*q1 > 0:    #move p1
            p1 = p
            q1 = q
            # halve q0?
            if not q0halved:
                q0 = q0/2
                q0halved = True
        elif q*q0 > 0:  #move p0
            p0 = p
            q0 = f(p0)
            q1 = f(p1)
            if not q1halved:
                q1 = q1/2
                q1halved = True
    info = "Iteration: {}, a: {:.10f}, b: {:.10f}, new point: {:.10f}, f(p): {:.10f}".format(i,p0,p1,p,f(p))
    print(info)
    out.write(info + "\n")
 
def false3halving(a, b, tol, N, f):
    i = 1
    error = tol + 1
    a = a
    b = b
    fa = f(a)
    fb = f(b)
    ahalved = False
    bhalved = False
    while error > tol and i<N:
        info = "Iteration: {} a: {:.15f} b: {:.15f} Relative Error: {:.15f}".format(i, a, b,error)
        print(info)
        out.write(info + "\n")
        #p = b - f(b)*(b-a)/(f(b)-f(a)) Instead of this line, we can modify the code to halve f(b)
        p = b - fb*(b-a)/(fb - fa) #since we are no longer calling f, fb and fa must be redefined
                                    #whenever a or b change
        #Change notation to p0, p1, .... etc
        #if sign change between f(a) and f(p) b <- p
        if f(a)*f(p) < 0:
            error =  math.fabs((p-b)/b)
            b = p
            fb = f(b)
            bhalved = False #say b hasnt been halved
            
            #here we moved b; we check if a had moved before, then halve fa for when p is calculated nect
            if not ahalved:
                fa /= 2
                ahalved = True
                print("f(a) halved")
                out.write("f(a) halved\n")

        elif f(b)*f(p) < 0:
            error =  math.fabs((p-a)/a)
            a = p
            fa = f(a)
            ahalved = False #say a hasnt been halved
            
            #here we moved a; we check if b had moved before, then halve fb for when p is calculated nect
            if not bhalved:
                fb /= 2
                bhalved = True
                print("f(b) halved")
                out.write("f(b) halved\n")

        else:
            print("something's wrong")
        i += 1

 
    info = "Iteration: {} a: {:.15f} b: {:.15f} Relative Error: {:.15f}".format(i, a, b,error)
    print(info)
    out.write(info + "\n")                                                                                         

                                                                                    
def main():
    false3halving(-3,3, 0.0001, 50, fun)    
    #the one in the book 
    #false2(0.5,math.pi/4, 0.000000001, 50, sample) 

main()
