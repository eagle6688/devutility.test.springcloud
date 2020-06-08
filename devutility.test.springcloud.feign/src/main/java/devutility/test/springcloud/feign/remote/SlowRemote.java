package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devutility.internal.model.OperationResult;

@FeignClient(name = "SlowRemote", url = "http://localhost:9001")
public interface SlowRemote {
	@GetMapping("/home/process")
	OperationResult process(@RequestParam("time") long time);
}