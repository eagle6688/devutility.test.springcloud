package devutility.test.springcloud.feign.model;

import java.net.UnknownHostException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import devutility.internal.response.BaseResponse;
import devutility.test.springcloud.feign.common.HttpCode;

public class ApiResponse<T> extends BaseResponse<T> {
	private int status;

	@JsonIgnore
	private HttpHeaders httpHeaders;

	@JsonIgnore
	private Throwable throwable;

	public ApiResponse() {
		this.setStatus(HttpStatus.OK.value());
	}

	public ApiResponse(T data) {
		this();
		super.setData(data);
	}

	public ApiResponse(ResponseEntity<T> responseEntity) {
		this(responseEntity.getBody());
		setHttpHeaders(responseEntity.getHeaders());
	}

	public ApiResponse(Throwable throwable) {
		super.setErrorMessage(throwable.getMessage());
		this.setThrowable(throwable);

		if (throwable instanceof UnknownHostException || throwable.getCause() instanceof UnknownHostException) {
			setStatus(HttpCode.UNKNOWHOST.getValue());
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}