package devutility.test.springcloud.feign.external.remote.fallback;

import org.springframework.stereotype.Component;

import devutility.test.springcloud.feign.external.remote.NotFoundRemote;
import feign.hystrix.FallbackFactory;

@Component
public class NotFoundRemoteFallbackFactory implements FallbackFactory<NotFoundRemote> {
	@Override
	public NotFoundRemote create(Throwable cause) {
		cause.printStackTrace();

		return new NotFoundRemote() {
			@Override
			public String test() {
				return null;
			}
		};
	}
}