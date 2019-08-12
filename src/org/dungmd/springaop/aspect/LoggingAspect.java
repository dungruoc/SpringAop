package org.dungmd.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    
    @Before("execution(public String getName())")
    public void LoggingAdvice() {
        System.out.println("Advice run. Get method called");
    }
    
    @Before("execution(public String org.dungmd.springaop.model.Circle.getName())")
    public void ParticularLoggingAdvice() {
        System.out.println("Circle get method called");        
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters() {}
    
    @Before("allGetters()")
    public void allGetterAdvice1() {
        System.out.println("Getter method called 1");        
    }

    @Before("allGetters()")
    public void allGetterAdvice2() {
        System.out.println("Getter method called 2");        
    }    
}
