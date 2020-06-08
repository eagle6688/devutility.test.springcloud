package devutility.test.springcloud.feign.common;

import feign.RetryableException;
import feign.Retryer;

/**
 * 
 * MyRetryer, how can we configure these parameters?
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 17:36:10
 */
public class MyRetryer implements Retryer {
	private int retryMaxAttempt;
	private long retryInterval;
	private int attempt = 1;

	public MyRetryer(int retryMaxAttempt, Long retryInterval) {
		this.retryMaxAttempt = retryMaxAttempt;
		this.retryInterval = retryInterval;
	}

	@Override
	public void continueOrPropagate(RetryableException e) {
		System.out.println("This is retryer!");

		if (attempt++ == retryMaxAttempt) {
			throw e;
		}
		try {
			Thread.sleep(retryInterval);
		} catch (InterruptedException ignored) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public Retryer clone() {
		return new MyRetryer(6, 2000L);
	}
}