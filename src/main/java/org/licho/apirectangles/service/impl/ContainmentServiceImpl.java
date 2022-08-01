package org.licho.apirectangles.service.impl;

import org.licho.apirectangles.domain.Rectangle;
import org.licho.apirectangles.service.ContainmentService;
import org.springframework.stereotype.Service;

@Service
public class ContainmentServiceImpl implements ContainmentService {

    @Override
    public Rectangle getContainment(Rectangle rectangle1, Rectangle rectangle2) {

        if (oneContainsTwo(rectangle1, rectangle2)) {
           return rectangle2;
        }

        if (oneContainsTwo(rectangle2, rectangle1)) {
            return rectangle1;
        }

        return null;
    }

    private boolean oneContainsTwo(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getPointA().getX() <= rectangle2.getPointA().getX() &&
                rectangle1.getPointA().getY() <= rectangle2.getPointA().getY() &&
                rectangle1.getPointD().getX() >= rectangle2.getPointD().getX() &&
                rectangle1.getPointD().getY() >= rectangle2.getPointD().getY();
    }
}
