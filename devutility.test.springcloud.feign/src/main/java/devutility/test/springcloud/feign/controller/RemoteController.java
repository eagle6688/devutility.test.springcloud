package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.model.OperationResult;
import devutility.test.springcloud.feign.remote.NotFoundRemote;
import devutility.test.springcloud.feign.remote.UnknowHostRemote;

/**
 * 
 * RemoteController
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 17:44:03
 */
@RestController
@RequestMapping("/remote")
public class RemoteController {
	@Autowired
	private UnknowHostRemote unknowHostRemote;

	@Autowired
	private NotFoundRemote notFoundRemote;

	/**
	 * http://localhost:9005/remote/unknow-host
	 * @return OperationResult
	 */
	@GetMapping("unknow-host")
	public OperationResult unknowHost() {
		OperationResult result = new OperationResult();
		result.setData(unknowHostRemote.test());
		return result;
	}

	/**
	 * http://localhost:9005/remote/not-found
	 * @return OperationResult
	 */
	@GetMapping("not-found")
	public OperationResult notFound() {
		OperationResult result = new OperationResult();
		result.setData(notFoundRemote.test());
		return result;
	}
}