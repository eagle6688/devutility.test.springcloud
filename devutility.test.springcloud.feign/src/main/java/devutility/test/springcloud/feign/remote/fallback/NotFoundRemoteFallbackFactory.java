package devutility.test.springcloud.feign.remote.fallback;

import devutility.test.springcloud.feign.remote.NotFoundRemote;
import feign.hystrix.FallbackFactory;

//@Component
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