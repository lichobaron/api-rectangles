package org.licho.apirectangles.service.impl;

import lombok.RequiredArgsConstructor;
import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;
import org.licho.apirectangles.service.AdjacencyService;
import org.licho.apirectangles.service.ContainmentService;
import org.licho.apirectangles.service.IntersectionService;
import org.licho.apirectangles.service.RectangleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RectangleServiceImpl implements RectangleService {

    private final IntersectionService intersectionService;
    private final ContainmentService containmentService;
    private final AdjacencyService adjacencyService;

    @Override
    public Rectangle calculateIntersection(Rectangle rectangle1, Rectangle rectangle2) {
        return intersectionService.calculateIntersection(rectangle1, rectangle2);
    }

    @Override
    public Rectangle getContainment(Rectangle rectangle1, Rectangle rectangle2) {
        return containmentService.getContainment(rectangle1, rectangle2);
    }

    @Override
    public AdjacencyType identifyAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return adjacencyService.identifyAdjacency(rectangle1, rectangle2);
    }
}
