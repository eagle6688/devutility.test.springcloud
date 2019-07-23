package devutility.test.springcloud.feign.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "unknowHost", url = "http://unknow-host.com")
public interface UnknowHostRemote {
	@GetMapping("/test")
	String test();
}