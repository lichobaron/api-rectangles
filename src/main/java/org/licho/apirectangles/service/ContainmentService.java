package org.licho.apirectangles.service;

import org.licho.apirectangles.domain.Rectangle;

public interface ContainmentService {

    Rectangle getContainment(Rectangle rectangle1, Rectangle rectangle2);
}
