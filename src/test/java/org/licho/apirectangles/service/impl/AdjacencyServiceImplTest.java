package org.licho.apirectangles.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;

class AdjacencyServiceImplTest {

    private final AdjacencyServiceImpl adjacencyService = new AdjacencyServiceImpl();

    @Test
    void identifyAdjacency_whenNoAdjacency() {
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

        AdjacencyType result = adjacencyService.identifyAdjacency(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(AdjacencyType.NOT_ADJACENT);
    }

    @Test
    void identifyAdjacency_whenProperAdjacency() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(1)
                .height(1)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(2)
                .y(1)
                .width(1)
                .height(1)
                .build();

        AdjacencyType result = adjacencyService.identifyAdjacency(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(AdjacencyType.PROPER);
    }

    @Test
    void identifyAdjacency_whenPartialAdjacency() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(1)
                .height(1)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(2)
                .y(1.5)
                .width(1)
                .height(1)
                .build();

        AdjacencyType result = adjacencyService.identifyAdjacency(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(AdjacencyType.PARTIAL);
    }

    @Test
    void identifyAdjacency_whenSubLineAdjacency() {
        Rectangle rectangle1 = Rectangle.builder()
                .x(1)
                .y(1)
                .width(2)
                .height(2)
                .build();
        Rectangle rectangle2 = Rectangle.builder()
                .x(3)
                .y(1.5)
                .width(0.5)
                .height(0.5)
                .build();

        AdjacencyType result = adjacencyService.identifyAdjacency(rectangle1, rectangle2);

        Assertions.assertThat(result).isEqualTo(AdjacencyType.PARTIAL);
    }
}