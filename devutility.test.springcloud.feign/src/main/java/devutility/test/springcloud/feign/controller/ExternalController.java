package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.springcloud.feign.external.NormalExternal;
import devutility.test.springcloud.feign.external.NotFoundExternal;
import devutility.test.springcloud.feign.external.UnknowHostExternal;
import devutility.test.springcloud.feign.model.ApiResponse;

@RestController
@RequestMapping("/external")
public class ExternalController {
	@Autowired
	private UnknowHostExternal unknowHostExternal;

	@Autowired
	private NotFoundExternal notFoundExternal;

	@Autowired
	private NormalExternal normalExternal;

	/**
	 * http://localhost:9005/external/unknow-host
	 * @return OperationResult
	 */
	@GetMapping("unknow-host")
	public ApiResponse<String> unknowHost() {
		return unknowHostExternal.test();
	}

	/**
	 * http://localhost:9005/external/not-found
	 * @return OperationResult
	 */
	@GetMapping("not-found")
	public ApiResponse<String> notFound() {
		return notFoundExternal.test();
	}

	/**
	 * http://localhost:9005/external/baidu
	 * @return OperationResult
	 */
	@GetMapping("baidu")
	public ApiResponse<String> baidu() {
		return normalExternal.baidu();
	}
}