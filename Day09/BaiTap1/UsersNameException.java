package BaiTap1;

public class UsersNameException extends Exception{
	private String message;

	public UsersNameException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UsersNameException(String message) {
		super();
		this.message = message;
	}
}
