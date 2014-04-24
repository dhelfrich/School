
public class L39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a1 = 4.23462;
		long b = Math.round(a1);
		System.out.println(b);
		
		a1 = Math.round(a1*100.0)/100.0;
		System.out.println(a1);
		
		Cat[] cat = new Cat[2];
		cat[0] = new Cat("Fluffy",1);
		cat[1] = new Cat("Scruffy",2);
		
		Cat[] catCopy = new Cat[2];
		for(int i = 0; i < cat.length; i++){
			catCopy[i] = cat[i];
			System.out.println(cat[i].getName() + " " + catCopy[i].getName());
		}
		//shallow copy
		cat[0].setAge(13);
		System.out.println(cat[0].getAge() + " " + catCopy[0].getName());
		
		catCopy[1].setAge(5);
		System.out.println(cat[1].getAge() + " " + catCopy[1].getName());
		
		//deep copy
		Cat[] catCopy2 = new Cat[2];
		for(int i = 0; i < cat.length; i++){
			String name = cat[i].getName();
			int age = cat[i].getAge();
			catCopy2[i] = new Cat(name, age);
		}	
		modifyCat(catCopy2[1],200);
		
	}
	public static void modifyCat(Cat cat, int age){
		cat.setAge(age);
	}

}
