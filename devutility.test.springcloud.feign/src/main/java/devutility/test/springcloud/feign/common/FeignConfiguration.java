package devutility.test.springcloud.feign.common;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devutility.internal.util.PropertiesUtils;
import feign.Retryer;
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
	@ConditionalOnProperty(name = "feign.custom.config.enabled", havingValue = "true")
	@ConfigurationProperties("feign.custom.config")
	public Properties feignOptions() {
		return new Properties();
	}

	@Bean
	@ConditionalOnBean(name = "feignOptions")
	public feign.Retryer retryer(@Qualifier("feignOptions") Properties feignOptions) {
		//return new CustomRetryer(6, 2000L);

		long period = PropertiesUtils.getValue(feignOptions, "period", Long.class);
		long maxPeriod = PropertiesUtils.getValue(feignOptions, "maxPeriod", Long.class);
		int maxAttempts = PropertiesUtils.getValue(feignOptions, "maxAttempts", Integer.class);
		return new Retryer.Default(period, maxPeriod, maxAttempts);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
}