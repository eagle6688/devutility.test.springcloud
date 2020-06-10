package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import devutility.test.springcloud.feign.model.OtherApiResponse;

/**
 * 
 * NotFoundRemote
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 17:10:00
 */
@FeignClient(name = "NotFoundRemote", url = "https://www.cnblogs.com")
public interface NotFoundRemote {
	@GetMapping("/asd")
	String test();

	@GetMapping("/asd")
	OtherApiResponse<String> standard();
}