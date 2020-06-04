package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.springcloud.feign.external.NormalExternal;
import devutility.test.springcloud.feign.model.ApiResponse;

@RestController
@RequestMapping("/external")
public class ExternalController {
	@Autowired
	private NormalExternal normalExternal;

	/**
	 * http://localhost:9005/external/baidu
	 * @return OperationResult
	 */
	@GetMapping("baidu")
	public ApiResponse<String> baidu() {
		return normalExternal.baidu();
	}
}