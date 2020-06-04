package devutility.test.springcloud.feign.external.remote.fallback;

import devutility.test.springcloud.feign.remote.UnknowHostRemote;
import feign.hystrix.FallbackFactory;

// @Component
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