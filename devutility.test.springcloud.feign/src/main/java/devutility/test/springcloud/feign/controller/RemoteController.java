package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.model.OperationResult;
import devutility.test.springcloud.feign.remote.NormalRemote;
import devutility.test.springcloud.feign.remote.NotFoundRemote;
import devutility.test.springcloud.feign.remote.SlowRemote;
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

	@Autowired
	private SlowRemote slowRemote;

	@Autowired
	private NormalRemote normalRemote;

	@GetMapping("unknow-host")
	public OperationResult unknowHost() {
		OperationResult result = new OperationResult();
		result.setData(unknowHostRemote.test());
		return result;
	}

	@GetMapping("not-found")
	public OperationResult notFound() {
		OperationResult result = new OperationResult();
		result.setData(notFoundRemote.test());
		return result;
	}

	@GetMapping("slow-process")
	public OperationResult slowProcess(long time) {
		return slowRemote.process(time);
	}

	@GetMapping("baidu")
	public OperationResult baidu() {
		OperationResult result = new OperationResult();
		result.setData(normalRemote.baidu());
		return result;
	}
}