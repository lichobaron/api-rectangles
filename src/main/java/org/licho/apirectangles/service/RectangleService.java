package org.licho.apirectangles.service;

import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;

public interface RectangleService {

    Rectangle calculateIntersection(Rectangle rectangle1, Rectangle rectangle2);

    Rectangle getContainment(Rectangle rectangle1, Rectangle rectangle2);

    AdjacencyType identifyAdjacency(Rectangle rectangle1, Rectangle rectangle2);
}
