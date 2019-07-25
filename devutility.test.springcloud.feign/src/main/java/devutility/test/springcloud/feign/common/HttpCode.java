package devutility.test.springcloud.feign.common;

public enum HttpCode {
	/**
	 * Unknow host.
	 */
	UNKNOWHOST(701, "Unknow host");

	private int value;
	private String message;

	private HttpCode(int value, String message) {
		setValue(value);
		setMessage(message);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}