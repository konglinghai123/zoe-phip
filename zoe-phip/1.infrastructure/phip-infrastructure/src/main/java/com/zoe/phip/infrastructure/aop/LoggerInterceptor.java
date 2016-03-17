package com.zoe.phip.infrastructure.aop;

import com.zoe.phip.infrastructure.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by 文彬 on 2016/3/16.
 */
public class LoggerInterceptor {


    private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    public void doBefore(JoinPoint point) {
        // TODO: 2016/3/17 相关权限验证

    }

    public void doAfter(JoinPoint joinPoint) {
        // TODO: 2016/3/17
    }

    public void doAfterReturn(JoinPoint joinPoint, String result) {
        // TODO: 2016/3/17
    }

    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //参数
        Object[] params = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        if (!StringUtil.isNullOrWhiteSpace(methodName)) {
            if (!(methodName.startsWith("set") || methodName.startsWith("get") || methodName.startsWith("query"))) {
                Class clazz = joinPoint.getTarget().getClass();
                Method method = clazz.getMethod(methodName);
                if (method != null) {
                    boolean hasAnnotation = method.isAnnotationPresent(Action.class);
                    if (hasAnnotation) {
                        Action action = method.getAnnotation(Action.class);
                        String operationType = action.operationType();
                        String description = action.description();
                        // TODO: 2016/3/16 拦截后，做什么？
                        //if (logger.isDebugEnabled()) {
                        //logger.debug(operationType + ":" + description);
                        //}
                    }
                }
            }
        }
        return joinPoint.proceed();
    }

    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        // TODO: 2016/3/17 异常处理
        if (logger.isErrorEnabled())
            logger.error("异常处理消息", ex);
    }
}
