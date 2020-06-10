package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import devutility.test.springcloud.feign.model.OtherApiResponse;

@FeignClient(name = "BaiduRemote", url = "https://www.baidu.com")
public interface BaiduRemote {
	@GetMapping("/")
	String normal();

	@GetMapping("/")
	OtherApiResponse<String> standard();
}