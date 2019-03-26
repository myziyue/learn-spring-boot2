package com.myziyue.learn.ch02.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class AOPConfig {
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args: " + Arrays.asList(args));
            // 调用原有的方法
            // 通常情况下，执行完切面代码，还需要继续执行应用代码， proceed() 方法则会继续调用原有的业务逻辅，并将返回对象正常返回。
            Object o = pjp.proceed();
            System.out.println("Return : " + o);
            return o;
        } catch (Throwable e) {
            throw  e;
        }
    }
}
