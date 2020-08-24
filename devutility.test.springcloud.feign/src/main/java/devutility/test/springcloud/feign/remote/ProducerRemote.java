package devutility.test.springcloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devutility.internal.model.OperationResult;
import devutility.test.model.Member;
import devutility.test.springcloud.feign.common.ProducerFeignConfiguration;

/**
 * 
 * ProducerRemote
 * 
 * @author: Aldwin Su
 * @creation: 2020-08-24 15:07:21
 */
@FeignClient(name = "ProducerRemote", url = "http://127.0.0.1:9001", configuration = { ProducerFeignConfiguration.class })
public interface ProducerRemote {
	@PostMapping("/user/receive-json")
	OperationResult receiveJson(@RequestParam("languageCode") String languageCode, Member member);

	@PostMapping(value = "/user/receive-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	OperationResult receiveForm(@RequestParam("languageCode") String languageCode, String param);
}