
public class Cat {
	private String name;
	private int age;

	public Cat(String name, int age){
		this.name = name;
		this.age = age;
	}
	//add some getters to the class
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}
}
