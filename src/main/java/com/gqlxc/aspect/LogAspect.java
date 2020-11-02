package com.gqlxc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.gqlxc.web.*..*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,methodName,args);

        logger.info("RequestLog : {}" ,requestLog);


    }

    @After("log()")
    public void doAfter(){
        //logger.info("-----doafter-------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}" ,result);
    }

    class RequestLog{
        private String url;
        private String ip;
        private String methodName;
        private Object[] args;

        public RequestLog(String url, String ip, String methodName, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.methodName = methodName;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", methodName='" + methodName + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
