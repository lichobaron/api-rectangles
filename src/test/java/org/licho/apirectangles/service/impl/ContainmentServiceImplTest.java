package org.licho.apirectangles.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.licho.apirectangles.domain.Rectangle;

class ContainmentServiceImplTest {

    private final ContainmentServiceImpl containmentService = new ContainmentServiceImpl();

    @Test
    void getContainment_whenOneContainsTwo() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(4)
                .height(4)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(1.5)
                .y(1.5)
                .width(1)
                .height(1)
                .build();

        Rectangle result = containmentService.getContainment(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(rectangle2);
    }

    @Test
    void getContainment_whenTwoContainsOne() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1.5)
                .y(1.5)
                .width(1)
                .height(1)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(4)
                .height(4)
                .build();

        Rectangle result = containmentService.getContainment(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(rectangle1);
    }

    @Test
    void getContainment_whenNoContainmentIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(5)
                .y(5)
                .width(5)
                .height(5)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(1.5)
                .y(1.5)
                .width(7)
                .height(7)
                .build();

        Rectangle result = containmentService.getContainment(rectangle1, rectangle2);

        Assertions.assertThat(result).isNull();
    }

    @Test
    void getContainment_whenNoContainment() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(1)
                .height(1)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(2.5)
                .y(2.5)
                .width(7)
                .height(7)
                .build();

        Rectangle result = containmentService.getContainment(rectangle1, rectangle2);

        Assertions.assertThat(result).isNull();
    }
}