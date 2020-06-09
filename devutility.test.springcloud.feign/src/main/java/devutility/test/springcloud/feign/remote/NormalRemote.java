package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "normal", url = "https://www.baidu.com")
public interface NormalRemote {
	@GetMapping("/")
	String baidu();
}