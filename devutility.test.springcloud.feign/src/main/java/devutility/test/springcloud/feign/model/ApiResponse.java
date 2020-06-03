package devutility.test.springcloud.feign.model;

import java.net.UnknownHostException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import devutility.internal.lang.ExceptionUtils;
import devutility.internal.model.BaseResponse;
import devutility.test.springcloud.feign.common.HttpCode;

public class ApiResponse<T> extends BaseResponse<T> {
	private int status;
	private HttpHeaders httpHeaders;
	private String exception;

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

	public ApiResponse(Exception exception) {
		super.setErrorMessage(exception.getMessage());
		setException(ExceptionUtils.toString(exception));

		if (exception instanceof ApiException) {
			ApiException apiException = (ApiException) exception;
			setStatus(apiException.getStatus().value());
		}

		if (exception instanceof UnknownHostException || exception.getCause() instanceof UnknownHostException) {
			setStatus(HttpCode.UNKNOWHOST.getValue());
		}
	}

	public boolean isWorthyRetry() {
		switch (status) {
		case 404:
			return true;

		case 408:
			return true;

		case 410:
			return true;

		case 413:
			return true;

		case 421:
			return true;

		case 423:
			return true;

		case 424:
			return true;

		case 425:
			return true;

		case 449:
			return true;

		case 503:
			return true;

		case 504:
			return true;

		case 507:
			return true;

		case 509:
			return true;

		case 600:
			return true;

		case 701:
			return true;

		default:
			return false;
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

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}