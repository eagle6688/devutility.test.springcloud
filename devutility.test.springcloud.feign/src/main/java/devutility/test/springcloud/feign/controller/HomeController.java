package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.models.OperationResult;
import devutility.test.springcloud.feign.external.UnknowHostRemote;

@RestController
public class HomeController {
	@Autowired
	private UnknowHostRemote unknowHostRemote;

	@GetMapping("/index")
	public OperationResult index() {
		return new OperationResult();
	}

	@GetMapping("/unknow-host")
	public OperationResult unknowHost() {
		OperationResult result = new OperationResult();
		result.setData(unknowHostRemote.test());
		return result;
	}
}