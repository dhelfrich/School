/* Introduction to Java - Hello World, pages 3-9 in your java book
 * Java is an object-oriented language, which means that you can
 * build variables to represent some thing, or object. 
 * 
 * In Python, we talked about variables types, such as integers, 
 * floats, strings, booleans, and Java also has all of those types.
 * We used those types in code to represent something in our code. 
 * For example, we could have an integer that repesented a number of
 * minutes, or a float that represented the similarity score for two
 * strings. 
 * 
 * But, how would you represent something such as a bicycle? We want
 * one data type that is a bicycle, and so far, we haven't discussed
 * anything that would allow us to do that, represent something as
 * complex as a bicycle. This is the value of object-oriented 
 * programming, we can build an object that's type is Bicycle. It's not
 * an integer or a float or a string, it's a Bicycle.
 * 
 * When you think about what objects are in the real-world, they have
 * properties and behaviors, generally. For example, real bicycles have
 * properties such as current speed, color, manufacturer. They also 
 * have behaviors such as rolling, speeding up, slowing down. In code,
 * those properties can be represented using variable types that we've 
 * already discussed, for example, current speed could be an integer.
 * Properties could also be other objects, for example, the Bicycle
 * object could have a Rider property, where the Rider is another object
 * The behavior of objects are captured as methods, which are similar
 * to functions in Python. These are the actions that the object can 
 * take, or the things that it can do, which may need to a change in 
 * it's properties. For example, if the Bicycle behavior is to speed up, 
 * then this will change its current speed property.
 * 
 * Objects are built from classes. You can think of classes as templates
 * for objects, or blueprints for object, they define the outline for 
 * the object, and the specifics
 * for individual instances of the object are introduced when the object
 * is created and as it executes. For example, the Bicycle class could have
 * a property (aka variable) called color, but color is only set to a 
 * specific value, such as red, blue, orange, for instances of the 
 * Bicycle object.
 * 
 * One of the challenges of Java, coming from Python, is that it's
 * very syntax heavy. There is a lot more code needed in Java to write
 * a program that does even the most basic things. This can be frustrating
 * because it means that there is more opportunity for small programming
 * errors that cause your program to not run.
 * 
 * Today we're going to talk about defining a class, and our first class
 * will be HelloWorld. Everything in Java has to be in a class so that
 * we can create objects if we so desire.
 * 
 * There are a few things to think about when defining a class. First,
 * who can "see" the class. We can have our class be callable by other
 * classes, or we can make it private, which is hidden from other classes.
 * For our purposes right now, we'll have our classes be public.
 * 
 * Next, what's included in the class, i.e. where does the class begin
 * and end, and what are the variables and methods included in the class.
 * In Python, we defined what was included in functions and loops using
 * indentation. In Java, we use {} to mark the beginning and ending of 
 * a class, function, loop, or conditional. This is the same idea, 
 * different syntax.
 * 
 * Next, where does the program start, what happens first?
 * In Python, we created a main() function and started there. We do the 
 * same thing here, with a few differences. Our main function here is
 * inside of our class, and it's required. In Python, we created a main
 * just to get in the habit of creating a main, but it wasn't actually
 * required. Java expects to find a main in the starting class.

 * Our main function in Java also has the word void as part of the 
 * definition. In python, we didn't have to declare what the return 
 * type was for any of our functions, we just said "return x". 
 * But in Java, we need to explicitly say what the type of the return 
 * value will be. A void return type means that it doesn't return a value
*/ 

/*our first class, HelloWorld
 * it's public
 * Each word in the class name is capitalized
*/
public class Lecture22HelloWorld
{

/* Here is our main function. We make main public. static is a Java
 * keyword used for methods that are not tied to a specific instance
 * of an object. The word "void" here is very important. 
 * Void is what we use when our 
 * function doesn't return a value.
 * 
 * The main function also has (String[] args). These are command line 
 * arguments to main. The String[] is saying that args has a 
 * String data type and the [] means that there can be any number of them.
 */
	public static void main(String[] args)
	{
		/*To print out to the terminal, we have to use System.out.
		 *  Recall from the computer system slides in Lecture 2 that
		 * Input and Output included the mouse, keyboard, monitor. 
		 * So, when we access the hardware system, we have
		 * to use System in Java. In python, we just did print.
		 * 
		 * Notice the syntax on System. We saw this same syntax in Python
		 * with lists and strings when we did list.count. That called
		 * the list object and used the count method. In Java, since
		 * everything is an object, there are object types built in to
		 * the language. One of them is System. 
		 */
		System.out.print("Hello, world");
		System.out.println();
	}
}

//and that's it. Only 114 lines of code and comments to print Hello, world
