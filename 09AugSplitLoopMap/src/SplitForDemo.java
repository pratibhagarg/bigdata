import java.util.HashMap;
import java.util.StringTokenizer;

public class SplitForDemo {

	public static void main(String[] args) {
		String line = "Apache hadoop is a collection of open-source software utilities";

		System.out.println(line.charAt(1));
		System.out.println(line.length());
		System.out.println(line.indexOf('i'));
		System.out.println(line.lastIndexOf('i'));
		System.out.println(line.substring(7, 13));
		String words[] = line.split(" ");
		String[] words1 = line.split(" ");

		for (int i = 0; i < words1.length; i++) {
			System.out.println(words1[i]);
		}

		System.out.println("-----------------New for loop--------");

		for (String val : words1) {
			System.out.println(val);
		}

		System.out.println("-----------------while loop--------");
		int i = 0;
		while (i < words1.length) {
			System.out.println(words1[i]);
			i = i + 1;
		}

		System.out.println("-------------------String TokenUtility---------");
		StringTokenizer words2 = new StringTokenizer(line, " ");
		while (words2.hasMoreTokens()) {
			System.out.println(words2.nextToken());
		}

		
		System.out.println("****"+ ( 1000 + Float.parseFloat("100.5")));

		//System.out.println("****"+ ( 1000 + Integer.parseInt("100.5")));
		System.out.println("****"+ ( 1000 + (int)Float.parseFloat("100.5")));
		
		int i1=100;
		Integer j1=100;
		System.out.println(i1+j1);
		
			
		/*auotmatically converts primityives to class and vice-versa
		autoboxing autounboxing
*/		
		/*Java collection framework--wikipedia   map hashmap
		
		library and pakcage
		we writre code using library
		framework will run our code.*/
		
		System.out.println("--------------HashMap---------");
		
		
		
		/*Question- can we use any java class as key in hashmap?  */
		
		
		HashMap<String,String> hashmap= new HashMap<String,String>();
		
		String line1 = "Apache hadoop is a collection of Apache111 open-source software utilities";
		StringTokenizer testwords = new StringTokenizer(line1, " ");
		while (testwords.hasMoreTokens()) {
			String word=testwords.nextToken();
			hashmap.put(word.charAt(0)+"", word);
						
		}
		
		System.out.println("HAsMAP::: "+ hashmap.get("A"));
		System.out.println("HAsMPAP::: "+ hashmap.get("H"));
		System.out.println("HAsMAP::: "+ hashmap.get("h"));
		
		
		
		
		
	}
}