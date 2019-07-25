package devutility.test.springcloud.feign.external.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devutility.test.springcloud.feign.external.NormalExternal;
import devutility.test.springcloud.feign.external.remote.NormalRemote;
import devutility.test.springcloud.feign.model.ApiResponse;

@Component
public class NormalExternalImpl implements NormalExternal {
	@Autowired
	private NormalRemote normalRemote;

	@Override
	public ApiResponse<String> baidu() {
		try {
			return new ApiResponse<>(normalRemote.baidu());
		} catch (Exception e) {
			return new ApiResponse<>(e);
		}
	}
}