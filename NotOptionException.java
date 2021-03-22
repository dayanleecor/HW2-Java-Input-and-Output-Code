public class NotOptionException extends Exception {
	
	public NotOptionException() {
		super("Only 'y' for yes or 'n' for no.");
	}
	
	public NotOptionException(String message) {
		super(message);
	}
}