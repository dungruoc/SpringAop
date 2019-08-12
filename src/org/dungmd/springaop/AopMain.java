package org.dungmd.springaop;

import org.dungmd.springaop.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        try {
            AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("appcontext.xml");
            aContext.registerShutdownHook();
            
            ShapeService shapeService = aContext.getBean("shapeService", ShapeService.class);
            System.out.println(shapeService.getCircle().getName());
    
            shapeService.getCircle().setNameAndReturn("New Circle Name");
            System.out.println(shapeService.getTriangle().getName());

            shapeService.getCircle().setName("New Circle Name");
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
