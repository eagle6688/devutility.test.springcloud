package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import devutility.test.springcloud.feign.model.OtherApiResponse;
import feign.Response;

/**
 * 
 * UnknowHostRemote, such unknow host scenario doesn't target ErrorDecoder process, it throws
 * java.net.UnknownHostException after retryer finished.
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 17:09:40
 */
@FeignClient(name = "unknowHost", url = "http://unknow-host.com")
public interface UnknowHostRemote {
	@GetMapping("/test")
	String test();

	@GetMapping("/test")
	OtherApiResponse<String> standard();

	@GetMapping("/test")
	Response response();
}