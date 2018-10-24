
public class Test {
	public static void main(String[] args) {
		System.out.println("-----Inside Main-----");

		Animal obj1 = new Animal();
		System.out.println("obj1 name:: " + obj1.name);
		obj1.makeSound(obj1.name);
		System.out.println("obj1 address: " + obj1);
		obj1.name = "111";
		System.out.println("obj1 name after change:: " + obj1.name);

		Animal obj2 = new Animal();
		System.out.println("obj2 name:: " + obj2.name);
		System.out.println("obj2 address: " + obj2);

		System.out.println("-------------------------");
		Dog obj3 = new Dog();
		System.out.println("obj3 name:: " + obj3.name);
		obj1.makeSound(obj3.name);
		System.out.println("obj3 address: " + obj3);
		obj3.test();

		//format- ctrl+shift+F or source->format
	}
}
