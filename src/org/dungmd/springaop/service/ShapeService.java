package org.dungmd.springaop.service;

import org.dungmd.springaop.aspect.Loggable;
import org.dungmd.springaop.model.Circle;
import org.dungmd.springaop.model.Triangle;
import org.springframework.stereotype.Component;

@Component
public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

}
