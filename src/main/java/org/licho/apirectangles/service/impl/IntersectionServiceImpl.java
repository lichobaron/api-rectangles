package org.licho.apirectangles.service.impl;

import lombok.RequiredArgsConstructor;
import org.licho.apirectangles.domain.Rectangle;
import org.licho.apirectangles.service.IntersectionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntersectionServiceImpl implements IntersectionService {

    @Override
    public Rectangle calculateIntersection(Rectangle rectangle1, Rectangle rectangle2) {
        double leftBorder = Math.max(rectangle1.getPointA().getX(), rectangle2.getPointA().getX());
        double rightBorder = Math.min(rectangle1.getPointB().getX(), rectangle2.getPointB().getX());
        double bottomBorder = Math.max(rectangle1.getPointA().getY(), rectangle2.getPointA().getY());
        double topBorder = Math.min(rectangle1.getPointC().getY(), rectangle2.getPointC().getY());

        if (rightBorder <= leftBorder || topBorder <= bottomBorder) {
            return null;
        }

        return Rectangle.builder()
                .x(leftBorder)
                .y(bottomBorder)
                .height(topBorder - bottomBorder)
                .width(rightBorder - leftBorder)
                .build();

    }
}
