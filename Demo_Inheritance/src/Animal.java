
public class Animal {
	//state->data
	//class variables
	
	int legs=4;
	String name="Test animal";
	
	//Behavior methods
	public void makeSound(String name)
	{
		System.out.println("Inside Animal Class:: "+name);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "tosring method";
	}
	
	
}
