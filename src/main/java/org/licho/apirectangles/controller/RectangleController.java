package org.licho.apirectangles.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;
import org.licho.apirectangles.domain.request.RectangleOperationRequest;
import org.licho.apirectangles.domain.response.RectangleOperationResponse;
import org.licho.apirectangles.service.RectangleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rectangles")
@RequiredArgsConstructor
public class RectangleController {

    private final RectangleService rectangleService;

    @ApiOperation(value = "Get the rectangle intersection between two rectangles")
    @PostMapping("/intersection")
    public Rectangle calculateIntersection(@RequestBody RectangleOperationRequest rectangleOperationRequest) {
        return rectangleService
                .calculateIntersection(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());
    }

    @ApiOperation(value = "Get the rectangle that is contained in the other one")
    @PostMapping("/containment")
    public Rectangle getContainment(@RequestBody RectangleOperationRequest rectangleOperationRequest) {
        return rectangleService
                .getContainment(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());
    }

    @ApiOperation(value = "Get the adjacency type between two rectangles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result", response = AdjacencyType.class) })
    @PostMapping("/adjacency")
    public AdjacencyType identifyAdjacency(@RequestBody RectangleOperationRequest rectangleOperationRequest) {
        return rectangleService
                .identifyAdjacency(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());
    }

    @ApiOperation(value = "Run intersection, containment and adjacency operations")
    @PostMapping("/all")
    public RectangleOperationResponse processAllOperations(@RequestBody RectangleOperationRequest rectangleOperationRequest) {
        AdjacencyType adjacencyType = rectangleService
                .identifyAdjacency(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());
        Rectangle intersection = rectangleService
                .calculateIntersection(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());
        Rectangle containment = rectangleService
                .getContainment(rectangleOperationRequest.getRectangle1(), rectangleOperationRequest.getRectangle2());

        return RectangleOperationResponse.builder()
                .adjacencyType(adjacencyType)
                .intersection(intersection)
                .containment(containment)
                .build();
    }
}
