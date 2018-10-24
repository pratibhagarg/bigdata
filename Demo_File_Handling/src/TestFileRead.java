import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFileRead {
	public static void main(String[] args) throws IOException {
		
	
	//File instance
	File f =new File("C:\\Users\\IBM_ADMIN\\Desktop\\sample.txt");
	BufferedReader reader = null;
	try
	{
		reader= new BufferedReader(new FileReader( f));
		String line="";
		while ((line=reader.readLine())!=null)
		{
			System.out.println("content:" +line);
		}
		
	}
	
	catch(Exception e)
	{
		System.out.println("Inside catch");
		e.printStackTrace();
	}
	finally {
		System.out.println("inside finally");
	
	  if(reader!=null){
		   reader.close();
	  }
	}

	}
}