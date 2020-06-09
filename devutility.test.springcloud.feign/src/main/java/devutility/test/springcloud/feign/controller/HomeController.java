package devutility.test.springcloud.feign.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.model.OperationResult;

@RestController
public class HomeController {
	@Autowired(required = false)
	@Qualifier("feignOptions")
	private Properties feignProperties;

	@GetMapping("/index")
	public OperationResult index() {
		return new OperationResult();
	}

	@GetMapping("feign-properties")
	public OperationResult feignProperties() {
		OperationResult result = new OperationResult();
		result.setData(feignProperties);
		return result;
	}
}