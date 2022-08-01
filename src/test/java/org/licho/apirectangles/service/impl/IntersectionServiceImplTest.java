package org.licho.apirectangles.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.licho.apirectangles.domain.Rectangle;

class IntersectionServiceImplTest {

    private final IntersectionServiceImpl intersectionService = new IntersectionServiceImpl();


    @Test
    void calculateIntersection_whenLeftIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(3)
                .y(1)
                .width(4)
                .height(4)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(2)
                .y(2)
                .width(2)
                .height(2)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(
                Rectangle.builder()
                        .x(3)
                        .y(2)
                        .height(2)
                        .width(1)
                        .build()
        );
    }

    @Test
    void calculateIntersection_whenRightIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(2)
                .y(2)
                .width(2)
                .height(2)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(3)
                .y(1)
                .width(4)
                .height(4)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(
                Rectangle.builder()
                        .x(3)
                        .y(2)
                        .height(2)
                        .width(1)
                        .build()
        );
    }

    @Test
    void calculateIntersection_whenMiddleIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(3)
                .y(3)
                .width(3)
                .height(3)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(2)
                .y(4)
                .width(6)
                .height(1)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(
                Rectangle.builder()
                        .x(3)
                        .y(4)
                        .height(1)
                        .width(3)
                        .build()
        );
    }

    @Test
    void calculateIntersection_whenLeftUpCornerIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(4)
                .y(4)
                .width(2)
                .height(2)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(3)
                .y(5)
                .width(2)
                .height(2)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(
                Rectangle.builder()
                        .x(4)
                        .y(5)
                        .height(1)
                        .width(1)
                        .build()
        );
    }

    @Test
    void calculateIntersection_whenRightBottomCornerIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(4)
                .y(4)
                .width(2)
                .height(2)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(5)
                .y(3)
                .width(2)
                .height(2)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(
                Rectangle.builder()
                        .x(5)
                        .y(4)
                        .height(1)
                        .width(1)
                        .build()
        );
    }

    @Test
    void calculateIntersection_whenNoIntersection() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(1)
                .height(1)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(3)
                .y(3)
                .width(1)
                .height(1)
                .build();

        Rectangle result = intersectionService.calculateIntersection(rectangle1, rectangle2);

        Assertions.assertThat(result).isNull();
    }
}