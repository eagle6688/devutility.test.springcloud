package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.models.OperationResult;
import devutility.test.springcloud.feign.external.NotFoundRemote;
import devutility.test.springcloud.feign.external.UnknowHostRemote;

@RestController
public class HomeController {
	@Autowired
	private UnknowHostRemote unknowHostRemote;

	@Autowired
	private NotFoundRemote notFoundRemote;

	@GetMapping("/index")
	public OperationResult index() {
		return new OperationResult();
	}

	/**
	 * http://localhost:9005/unknow-host
	 * @return OperationResult
	 */
	@GetMapping("/unknow-host")
	public OperationResult unknowHost() {
		OperationResult result = new OperationResult();
		result.setData(unknowHostRemote.test());
		return result;
	}

	/**
	 * http://localhost:9005/not-found
	 * @return OperationResult
	 */
	@GetMapping("/not-found")
	public OperationResult notFound() {
		OperationResult result = new OperationResult();
		result.setData(notFoundRemote.test());
		return result;
	}
}