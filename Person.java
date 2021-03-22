public class Person
{
	// instance data
	private String name;
	private int age = 21;
	private static int drivingAge = 16;
	private static int num = 0;
	
	//constructors
	public Person(String name)
	{
		this.name = name;
		num++;				
	}
	public Person(String name, int age){
		this(name);
		this.age = age;
	}
    	//accessor and mutators
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
    public static int getDrivingAge(){
		return drivingAge;
	}
	public static int getNum(){
		return num;
	}
    public String toString(){
		return name;
	}
	public boolean equals(Object o){
		if( o == null)
			return false;
		if( getClass() != o.getClass())
			return false;
		Person p = (Person)o;
		return this.age == p.age;
	}



}
	
