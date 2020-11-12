package com.yajun.access;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.pagehelper.util.StringUtil;
import com.yajun.utils.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


@Aspect
@Component
public class ParamsPrintUtils {

    private static Logger log = LoggerFactory.getLogger(ParamsPrintUtils.class);

    private final ObjectMapper mapper;

    @Autowired
    public ParamsPrintUtils(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestLog() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postLog() {
    }

    @Before("requestLog() || postLog()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token= request.getHeader("token");

        log.info("token={}", token);

        // url
        log.info("url={}", request.getRequestURL());
        // method
        log.info("method={}", request.getMethod());
        // ip
        log.info("id={}", request.getRemoteAddr());

        // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。
        Object[] args = joinPoint.getArgs(); // 参数值
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名

        for (int i = 0; i < args.length; i++) {
            Object object = args[i];
            if (object instanceof MultipartFile ||
                    object instanceof HttpServletRequest ||
                    object instanceof HttpServletResponse) {
                continue;
            }

            if(object == null){
                continue;
            }

            if (log.isInfoEnabled()) {
                if (joinPoint == null){
                    continue;
                }
                try {
                    String className =  joinPoint.getTarget().getClass().getName();
                    String Signature = joinPoint.getSignature().getName();
                    String str = object == null ? null : object.toString();
                    String argName = argNames[i];
                    String logStr = className + "." + Signature + " : request parameter : " + argName + " = " + str;
                    log.info(logStr);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @AfterReturning(returning = "response", pointcut = "requestLog() || postLog()")
    public void doAfterReturning(Object response) throws Throwable {
        if (response != null) {
            log.info("response parameter : " + mapper.writeValueAsString(response));
        }
    }
}
