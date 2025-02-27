package com.jzajas.Aspects.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(public * com.jzajas.Aspects.Services.UserService.*(..))")
    private void publicMethodsFromUserServices() {}

    @Before("publicMethodsFromUserServices()")
    public void beforeMethodNameAndParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Attempting to execute : {}() with arguments: {}", methodName, Arrays.toString(args));
    }

    @AfterReturning(value = "publicMethodsFromUserServices()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        logger.info("Execution of : {}()", methodName + " Completed successfully with return type: " + result);
    }
}
