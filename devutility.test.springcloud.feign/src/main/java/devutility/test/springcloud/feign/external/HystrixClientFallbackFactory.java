package devutility.test.springcloud.feign.external;

import org.springframework.http.ResponseEntity;

import feign.hystrix.FallbackFactory;

public class HystrixClientFallbackFactory implements FallbackFactory<ResponseEntity<Object>> {
	@Override
	public ResponseEntity<Object> create(Throwable cause) {
		return null;
	}
}