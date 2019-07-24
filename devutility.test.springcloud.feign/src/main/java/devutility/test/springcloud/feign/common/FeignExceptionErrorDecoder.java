package devutility.test.springcloud.feign.common;

import org.springframework.context.annotation.Configuration;

import devutility.test.springcloud.feign.model.ApiException;
import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignExceptionErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String methodKey, Response response) {
		return ApiException.build(methodKey, response);
	}
}