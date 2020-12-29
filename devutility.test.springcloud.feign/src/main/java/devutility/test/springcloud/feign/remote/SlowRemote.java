package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devutility.internal.response.EasyResponse;

@FeignClient(name = "SlowRemote", url = "http://localhost:9001")
public interface SlowRemote {
	@GetMapping("/home/process")
	EasyResponse process(@RequestParam("time") long time);
}