package devutility.test.springcloud.feign.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "notFound", url = "https://www.cnblogs.com")
public interface NotFoundRemote {
	@GetMapping("/asd")
	String test();
}