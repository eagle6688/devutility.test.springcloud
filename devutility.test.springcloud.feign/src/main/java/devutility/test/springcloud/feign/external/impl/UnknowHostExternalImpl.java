package devutility.test.springcloud.feign.external.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devutility.test.springcloud.feign.external.UnknowHostExternal;
import devutility.test.springcloud.feign.external.remote.UnknowHostRemote;
import devutility.test.springcloud.feign.model.ApiResponse;

@Component
public class UnknowHostExternalImpl implements UnknowHostExternal {
	@Autowired
	private UnknowHostRemote unknowHostRemote;

	@Override
	public ApiResponse<String> test() {
		try {
			String value = unknowHostRemote.test();
			return new ApiResponse<String>(value);
		} catch (Exception e) {
			return new ApiResponse<String>(e);
		}
	}
}