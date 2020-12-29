package devutility.test.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.response.EasyResponse;
import devutility.test.springcloud.feign.remote.BaiduRemote;
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
	private BaiduRemote normalRemote;

	@GetMapping("unknow-host")
	public EasyResponse unknowHost() {
		EasyResponse result = new EasyResponse();
		result.setData(unknowHostRemote.test());
		return result;
	}

	@GetMapping("unknow-host-response")
	public EasyResponse unknowHostResponse() {
		EasyResponse result = new EasyResponse();
		result.setErrorMessage(unknowHostRemote.response().toString());
		return result;
	}

	@GetMapping("not-found")
	public EasyResponse notFound() {
		EasyResponse result = new EasyResponse();
		result.setData(notFoundRemote.test());
		return result;
	}

	@GetMapping("not-found-response")
	public EasyResponse notFoundResponse() {
		EasyResponse result = new EasyResponse();
		result.setErrorMessage(notFoundRemote.response().toString());
		return result;
	}

	@GetMapping("slow-process")
	public EasyResponse slowProcess(long time) {
		return slowRemote.process(time);
	}

	@GetMapping("baidu")
	public EasyResponse baidu() {
		EasyResponse result = new EasyResponse();
		result.setData(normalRemote.normal());
		return result;
	}
}