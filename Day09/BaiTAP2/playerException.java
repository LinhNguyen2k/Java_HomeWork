package BaiTAP2;

public class playerException extends Exception{
	public playerException(String message) {
		super();
		this.message = message;
	}

	private String message;

	public playerException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
