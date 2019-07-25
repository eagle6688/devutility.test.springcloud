package devutility.test.springcloud.feign.external;

import devutility.test.springcloud.feign.model.ApiResponse;

public interface UnknowHostExternal {
	ApiResponse<String> test();
}