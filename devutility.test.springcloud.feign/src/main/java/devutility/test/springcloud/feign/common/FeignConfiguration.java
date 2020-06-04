package devutility.test.springcloud.feign.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

/**
 * 
 * FeignConfiguration
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 16:43:35
 */
@Configuration
public class FeignConfiguration {
	@Bean
	public feign.Retryer retryer() {
		return new MyRetryer(6, 2000L);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new MyErrorDecoder();
	}
}