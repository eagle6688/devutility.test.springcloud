package devutility.test.springcloud.feign.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * Pointcuts
 * 
 * @author: Aldwin Su
 * @version: 2020-06-09 11:49:37
 */
public class Pointcuts {
	/**
	 * Pointcut for aspect.
	 */
	@Pointcut("execution(public * devutility.test.springcloud.feign.remote..*(..))")
	public void pointcutForRemote() {

	}
}