package org.dungmd.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.dungmd.springaop.model.Circle;

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
    
    @Pointcut("within(org.dungmd.springaop.model.Circle)")
    public void allCircleMethods() {}
    
    @After("allCircleMethods() && allGetters()")
    public void afterCircleGetMethods() {
        System.out.println("afterCircleGetMethods: Circle method called");
    }

    @After("allCircleMethods()")
    public void afterCircleMethods(JoinPoint joinPoint) {
        System.out.println("afterCircleMethods: " + joinPoint.getTarget());
    }

    @Before("args(name)")
    public void beforeStringArgMethods(String name) {
        System.out.println("beforeStringArgMethods: arg: " + name);
    }

    @After("args(name)")
    public void afterStringArgMethods(String name) {
        System.out.println("afterStringArgMethods: arg: " + name);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnedString")
    public void afterStringArgMethodsReturned(String name, String returnedString) {
        System.out.println("afterStringArgMethodsReturned: arg: " + name + ", returned: " + returnedString);
    }
    
    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void afterStringArgMethodsException(String name, Exception ex) {
        System.out.println("afterStringArgMethodsException: arg: " + name + " - ex: " + ex.getMessage());
    }
    
    @Around("allGetters()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoin) {
    	Object ret = null;
    	try {
        	System.out.println("aroundAdvice start " + proceedingJoinPoin.getTarget().getClass().getName());
        	if (proceedingJoinPoin.getTarget().getClass() != Circle.class) {
        		ret = proceedingJoinPoin.proceed();
            	System.out.println("aroundAdvice done " + proceedingJoinPoin.getTarget().getClass().getName());
        	} else {
            	System.out.println("aroundAdvice avoid " + proceedingJoinPoin.getTarget().getClass().getName());        		
        	}
        	
    	} catch (Throwable e) {
    		System.out.println("Caught " + e.getMessage());
    	}
    	System.out.println("aroundAdvice finally");
    	return ret;
    }

    @Around("@annotation(org.dungmd.springaop.aspect.Loggable)")
    public Object aroundLoggableAdvice(ProceedingJoinPoint proceedingJoinPoin) {
    	Object ret = null;
    	try {
        	System.out.println("aroundLoggableAdvice start " + proceedingJoinPoin.getTarget().getClass().getName());
    		ret = proceedingJoinPoin.proceed();        	
        	System.out.println("aroundLoggableAdvice done");
    	} catch (Throwable e) {
    		System.out.println("Caught " + e.getMessage());
    	}
    	System.out.println("aroundLoggableAdvice finally");
    	return ret;
    }
}
