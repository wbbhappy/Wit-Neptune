package org.witpool.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WitAspect {
    private final static Logger log = LoggerFactory.getLogger(WitAspect.class);

    @Pointcut("execution(public * org.witpool.rest.WitUserRest.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attr.getRequest();
        // URL
        log.info("WIT: URL={}", req.getRequestURL());
        // Method
        log.info("WIT: HTTP Method={}", req.getMethod());
        // IP
        log.info("WIT: IP={}", req.getRemoteAddr());
        // 类方法
        log.info("WIT: REST CLASS={}", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
        // 参数
        log.info("WIT: ARGS={}", jp.getArgs());
    }

    @After("log()")
    public void doAfter()
    {
        log.info("WIT: do after");
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj)
    {
        log.info("WIT: RESPONSE={}", obj.toString());
    }
}
