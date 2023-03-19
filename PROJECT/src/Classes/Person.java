package Classes;

public abstract class Person {
	
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	
	public abstract boolean verifyUser( String username, String password );
	
}
