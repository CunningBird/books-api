package com.cunningbird.codereview.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component
public class BookLogger {

    private final Logger logger = LoggerFactory.getLogger(BookLogger.class);

    @Pointcut("@annotation(BusinessLogicLogging)")
    public void loggableMethod() {
    }

    @Around("loggableMethod()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();
        BusinessLogicLogging annotation = method.getAnnotation(BusinessLogicLogging.class);

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            logger.info("Started business logic - " + annotation.scenarioName() + " (" + className + "." + methodName + ")");
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            logger.info("Completed business logic - " + annotation.scenarioName() + " (" + className + "." + methodName + ") " + "Execution time - " + stopWatch.getTotalTimeMillis() + " ms");
        }
    }
}
