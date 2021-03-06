package infra.aop;

import javax.inject.Named;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Named
public class AspectExample {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectExample.class);
    
    @Around("execution(* domain.*Service.*(..))")
    public Object inDomainServicesLayer(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("A call was made to the service [" + pjp.getSignature() + "]");
        return pjp.proceed();
    }
    
}
