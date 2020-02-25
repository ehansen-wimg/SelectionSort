
public class AllStudentsException extends Exception {

	public AllStudentsException(String message) {
		super(message);
	}
	
	public AllStudentsException(Throwable t) {
		super(t);
	}
	
	public AllStudentsException(String message, Throwable t) {
		super(message, t);
	}
}
