package org.dungmd.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {

    public Object log(ProceedingJoinPoint proceedingJoinPoin) {
    	Object ret = null;
    	try {
        	System.out.println("Logging.log start " + proceedingJoinPoin.getTarget().getClass().getName());
    		ret = proceedingJoinPoin.proceed();        	
        	System.out.println("Logging.log done");
    	} catch (Throwable e) {
    		System.out.println("Caught " + e.getMessage());
    	}
    	System.out.println("Logging.log finally");
    	return ret;
    }

}
