package demo;

public class InvalidHazchemCodeException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidHazchemCodeException() {
             super("Something wrong!");
	}

	public InvalidHazchemCodeException(String warning) {
       super(warning);
	}
}
