package com.ashitem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(* com.ashitem.service..*.*(..))")
    public void pt(){

    }
    @Before("pt()")
    public void before(){
        System.out.println("before");
    }
}
