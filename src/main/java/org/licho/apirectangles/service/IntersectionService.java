package org.licho.apirectangles.service;

import org.licho.apirectangles.domain.Rectangle;
import org.springframework.stereotype.Service;

@Service
public interface IntersectionService {
    Rectangle calculateIntersection(Rectangle rectangle1, Rectangle rectangle2);
}
