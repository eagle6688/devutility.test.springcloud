package devutility.test.springcloud.feign.external.remote.fallback;

import org.springframework.stereotype.Component;

import devutility.test.springcloud.feign.external.remote.UnknowHostRemote;
import feign.hystrix.FallbackFactory;

@Component
public class UnknowHostRemoteFallbackFactory implements FallbackFactory<UnknowHostRemote> {
	@Override
	public UnknowHostRemote create(Throwable cause) {
		cause.printStackTrace();

		return new UnknowHostRemote() {
			@Override
			public String test() {
				return null;
			}
		};
	}
}