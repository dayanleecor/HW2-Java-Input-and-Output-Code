import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

public class PersonTest
{
	public static void main(String args[])
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the amount of people you would like on the list: ");
		int num = PersonTest.inputNum();
		
		String firstName, lastName;
		int age;
		boolean again = false, error = true;
		PersonExt[] people = new PersonExt[num];
		
		int i = 0;
		while(i < num) {
			
			do {
				System.out.println("Enter first name of Person #" + (i + 1) +":");
				firstName = sc.nextLine();
				again = PersonTest.check(firstName);
			} while(again == true);
			
			do {
				System.out.println("Enter last name of Person #" + (i + 1) +":");
				lastName = sc.nextLine();
				again = PersonTest.check(lastName);
			} while(again == true);
			
			System.out.println("Enter age of Person #" + (i + 1) +":");
			age = PersonTest.inputNum();
			
			PersonExt p = new PersonExt(firstName, lastName);
			people[i] = p;
			
			i++;	
		}
		
		char ans;
		do{
			try {
				System.out.println("Would you like to print out the data: (y/n)");
				ans = sc.next().charAt(0);
				sc.nextLine();
					
				if(ans != 'y' && ans != 'n') { throw new NotOptionException();}
					
				error = false;
					
				if(ans == 'y') {		
					PersonTest.printList(people);
				}
				else {
					System.out.println("Ok, bye!");
				}				
			}
			catch (NotOptionException e) {
				System.out.println(e.getMessage());							
			}		
		} while(error);	
	}

	//------------------------------------------------------------------
	public static void compare(Person p1, Person p2)
	{
		System.out.println(p1 + " is" +
			(p1.equals(p2)? " ": " not ") + 
			"the same age as "  + p2);
	}
	
	//------------------------------------------------------------------
	// If true (there's a match to a non letter) user must enter again
	public static boolean isNotOnlyChar(String s)
	{
		Pattern pattern = Pattern.compile("[^a-zA-Z\\s]");
		Matcher matcher = pattern.matcher(s);
		
    	return matcher.find();
	}
	
	//------------------------------------------------------------------
	public static boolean check(String name){
		try{
				if(isNotOnlyChar(name) == true) {
					throw new Exception("Only alphabetical characters are valid. Please retry.");
				}
		}
		catch (Exception e){
				System.out.println(e.getMessage());
				
		}
		return isNotOnlyChar(name);
	}
	
	//------------------------------------------------------------------
	public static int inputNum() {
		boolean error = true;
		Scanner sc = new Scanner(System.in);
		int num;
		do{
			try {
				num = sc.nextInt();
				sc.nextLine();
					
				error = false;	
				return num;					
			}
			catch (InputMismatchException e) {
				System.out.println("Only numerical characters are valid. Please retry:");
				sc.nextLine();				
			}	
		} while(error);
		return 0;
	}

	//------------------------------------------------------------------	
	public static void printList(PersonExt people[]) {
		System.out.println("Your list: ");
		for(int j = 0; j < people.length; j++) {
				System.out.println(people[j].toString());
		}
	}
}