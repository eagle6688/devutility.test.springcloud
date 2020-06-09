package devutility.test.springcloud.feign.common;

import feign.RetryableException;
import feign.Retryer;

/**
 * 
 * CustomRetryer
 * 
 * @author: Aldwin Su
 * @version: 2020-06-04 17:36:10
 */
public class CustomRetryer implements Retryer {
	private int retryMaxAttempt;
	private long retryInterval;
	private int attempt = 1;

	public CustomRetryer(int retryMaxAttempt, Long retryInterval) {
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
		return new CustomRetryer(5, 2000L);
	}

	public int getRetryMaxAttempt() {
		return retryMaxAttempt;
	}

	public void setRetryMaxAttempt(int retryMaxAttempt) {
		this.retryMaxAttempt = retryMaxAttempt;
	}

	public long getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(long retryInterval) {
		this.retryInterval = retryInterval;
	}
}