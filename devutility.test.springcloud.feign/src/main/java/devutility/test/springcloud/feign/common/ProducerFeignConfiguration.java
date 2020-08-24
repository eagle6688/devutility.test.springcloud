package devutility.test.springcloud.feign.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ProducerFeignConfiguration implements RequestInterceptor {
	@Override
	public void apply(RequestTemplate template) {
		List<String> cookies = Arrays.asList(String.format("SESSION=%s;", "Test"));
		template.header(HttpHeaders.COOKIE, cookies);
	}
}