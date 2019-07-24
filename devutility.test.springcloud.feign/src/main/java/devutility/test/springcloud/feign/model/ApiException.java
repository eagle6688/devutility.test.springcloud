package devutility.test.springcloud.feign.model;

import java.io.IOException;

import feign.Response;
import feign.Util;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = -4779190659002773702L;
	private int status;
	private String response;

	public ApiException() {
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(String message, int status) {
		this(message);
		this.setStatus(status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public static ApiException build(String methodKey, Response response) {
		String message = String.format("Call %s failed with status %d.", methodKey, response.status());
		ApiException exception = new ApiException(message);

		exception.setStatus(response.status());

		if (response.body() != null) {
			try {
				exception.setResponse(Util.toString(response.body().asReader()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return exception;
	}
}