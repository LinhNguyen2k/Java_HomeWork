package BaiTap1;

public class PasswordException extends Exception {
private String message;
	public PasswordException(String message) {
	super();
	this.message = message;
}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PasswordException() {
		super();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
