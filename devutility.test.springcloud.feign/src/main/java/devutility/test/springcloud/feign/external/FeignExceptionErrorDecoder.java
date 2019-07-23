package devutility.test.springcloud.feign.external;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignExceptionErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String methodKey, Response response) {
		return null;
	}
}