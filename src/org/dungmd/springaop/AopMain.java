package org.dungmd.springaop;

import org.dungmd.springaop.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("appcontext.xml");
        aContext.registerShutdownHook();
        
        ShapeService shapeService = aContext.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getCircle().getName());

        System.out.println(shapeService.getTriangle().getName());
    }

}
