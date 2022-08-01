package org.licho.apirectangles.domain.request;

import lombok.Data;
import org.licho.apirectangles.domain.Rectangle;

@Data
public class RectangleOperationRequest {
    private Rectangle rectangle1;
    private Rectangle rectangle2;
}
