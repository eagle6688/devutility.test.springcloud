package devutility.test.springcloud.feign.external;

import devutility.test.springcloud.feign.model.ApiResponse;

public interface NormalExternal {
	ApiResponse<String> baidu();
}