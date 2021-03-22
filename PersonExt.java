public class PersonExt extends Person {

	private String firstName;
	private String lastName;
	
	public PersonExt(String firstName, String lastName)
	{
		super(firstName);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		return sb.append(lastName).append(", ").append(firstName).toString();
	}
}