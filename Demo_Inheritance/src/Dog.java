
public class Dog extends Animal{

	@Override
	public void makeSound(String name) {
		// TODO Auto-generated method stub
		//super.makeSound(name);
		System.out.println("Inside dog Class-- I Bark");
	}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "I am test Dog";
		}
		
		//Dog class can add new behavior
		public void test()
		{
			System.out.println("own method: In test");
		}
		
	}
	

