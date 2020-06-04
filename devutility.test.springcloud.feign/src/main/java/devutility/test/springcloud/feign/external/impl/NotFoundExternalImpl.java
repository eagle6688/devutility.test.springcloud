package devutility.test.springcloud.feign.external.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devutility.test.springcloud.feign.external.NotFoundExternal;
import devutility.test.springcloud.feign.model.ApiResponse;
import devutility.test.springcloud.feign.remote.NotFoundRemote;

@Component
public class NotFoundExternalImpl implements NotFoundExternal {
	@Autowired
	private NotFoundRemote notFoundRemote;

	@Override
	public ApiResponse<String> test() {
		try {
			String value = notFoundRemote.test();
			return new ApiResponse<String>(value);
		} catch (Exception e) {
			return new ApiResponse<String>(e);
		}
	}
}