package org.licho.apirectangles.service;

import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;

public interface AdjacencyService {

    AdjacencyType identifyAdjacency(Rectangle rectangle1, Rectangle rectangle2);
}
