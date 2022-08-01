package org.licho.apirectangles.domain.response;

import lombok.Builder;
import lombok.Data;
import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;

@Data
@Builder
public class RectangleOperationResponse {

    private Rectangle intersection;
    private Rectangle containment;
    private AdjacencyType adjacencyType;
}
