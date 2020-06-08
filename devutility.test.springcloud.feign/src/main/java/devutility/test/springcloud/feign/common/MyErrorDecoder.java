package devutility.test.springcloud.feign.common;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

/**
 * 
 * MyErrorDecoder
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 16:27:31
 */
public class MyErrorDecoder implements ErrorDecoder {
	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.printf("MyErrorDecoder, methodKey: %s, request url: %s\n", methodKey, response.request().url());
		Exception exception = defaultErrorDecoder.decode(methodKey, response);
		System.out.printf("MyErrorDecoder, status: %d, exception: %s\n", response.status(), exception.getClass().getName());

		if (exception instanceof RetryableException) {
			return exception;
		}

		String message = String.format("%d error!", response.status());

		if (response.status() == 404) {
			return new RetryableException(response.status(), message, response.request().httpMethod(), null, response.request());
		}

		return exception;
	}
}