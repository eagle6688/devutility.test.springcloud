package devutility.test.springcloud.feign.model;

public class OtherApiResponse<T> extends ApiResponse<T> {
	public OtherApiResponse(T data) {
		super(data);
	}

	public OtherApiResponse(Throwable throwable) {
		super(throwable);
	}

	public OtherApiResponse() {
		super();
	}
}