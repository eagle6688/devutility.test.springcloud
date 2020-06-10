package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.springcloud.feign.model.OtherApiResponse;
import devutility.test.springcloud.feign.remote.BaiduRemote;
import devutility.test.springcloud.feign.remote.NotFoundRemote;
import devutility.test.springcloud.feign.remote.UnknowHostRemote;

@RestController
@RequestMapping("/standard-remote")
public class StandardRemoteController {
	@Autowired
	private UnknowHostRemote unknowHostRemote;

	@Autowired
	private NotFoundRemote notFoundRemote;

	@Autowired
	private BaiduRemote normalRemote;

	@GetMapping("unknow-host")
	public OtherApiResponse<String> unknowHost() {
		return unknowHostRemote.standard();
	}

	@GetMapping("not-found")
	public OtherApiResponse<String> notFound() {
		return notFoundRemote.standard();
	}

	@GetMapping("baidu")
	public OtherApiResponse<String> baidu() {
		return normalRemote.standard();
	}
}