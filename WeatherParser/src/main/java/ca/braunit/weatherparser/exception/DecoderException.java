package ca.braunit.weatherparser.exception;

public class DecoderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4336068378129365583L;

	public DecoderException() {
		super();
	}

	public DecoderException(String message) {
		super(message);
	}
	
	public DecoderException(Throwable cause) {
		super(cause);
	}
	
	public DecoderException(String message, Throwable cause) {
		super(message, cause);
	}
}
