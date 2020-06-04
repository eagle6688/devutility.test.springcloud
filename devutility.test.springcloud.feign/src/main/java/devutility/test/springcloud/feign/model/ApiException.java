package devutility.test.springcloud.feign.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;

import feign.Response;
import feign.Util;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = -4779190659002773702L;
	private HttpStatus status;
	private String response;

	public ApiException() {
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(String message, HttpStatus status) {
		this(message);
		this.setStatus(status);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public static ApiException build(String methodKey, Response response) {
		HttpStatus httpStatus = HttpStatus.valueOf(response.status());
		String message = String.format("Call %s failed, %s, status %d.", methodKey, httpStatus.getReasonPhrase(), response.status());
		ApiException exception = new ApiException(message, httpStatus);

		if (response.body() != null) {
			try {
				exception.setResponse(Util.toString(response.body().asReader(StandardCharsets.UTF_8)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return exception;
	}
}