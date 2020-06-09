package devutility.test.springcloud.feign.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import devutility.internal.lang.ExceptionUtils;
import devutility.internal.model.BaseResponse;

/**
 * 
 * RemoteAspect
 * 
 * @author: Aldwin Su
 * @version: 2020-06-09 14:23:45
 */
@Aspect
@Component
public class RemoteAspect {
	@Around("devutility.test.springcloud.feign.aspect.Pointcuts.pointcutForRemote()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		Signature signature = proceedingJoinPoint.getSignature();
		Class<?> returnType = ((MethodSignature) signature).getReturnType();

		try {
			return proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();

			if (BaseResponse.class.isAssignableFrom(returnType)) {
				BaseResponse<Object> response = new BaseResponse<>();
				response.setErrorMessage("Failed!");
				response.setData(e);
				return response;
			}

			return ExceptionUtils.toString(e);
		}
	}
}