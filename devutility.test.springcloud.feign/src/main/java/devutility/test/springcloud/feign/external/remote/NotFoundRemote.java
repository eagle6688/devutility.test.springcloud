package devutility.test.springcloud.feign.external.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import devutility.test.springcloud.feign.external.remote.fallback.NotFoundRemoteFallbackFactory;

@FeignClient(name = "notFound", url = "https://www.cnblogs.com", fallbackFactory = NotFoundRemoteFallbackFactory.class)
public interface NotFoundRemote {
	@GetMapping("/asd")
	String test();
}