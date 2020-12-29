package devutility.test.springcloud.feign.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.response.EasyResponse;

@RestController
public class HomeController {
	@Autowired(required = false)
	@Qualifier("feignOptions")
	private Properties feignProperties;

	@GetMapping("/index")
	public EasyResponse index() {
		return new EasyResponse();
	}

	@GetMapping("feign-properties")
	public EasyResponse feignProperties() {
		EasyResponse result = new EasyResponse();
		result.setData(feignProperties);
		return result;
	}
}