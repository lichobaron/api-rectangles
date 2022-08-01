package org.licho.apirectangles.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.licho.apirectangles.domain.line.XLine;
import org.licho.apirectangles.domain.line.YLine;

@Data
@Builder
public class Rectangle {
    /*
    Rectangle example:
                   4
       C ________________________ D
        |                       |
        |                       |
      1 |                       | 3
        |                       |
        |_______________________|
       A            2            B
     */
    private double x;
    private double y;
    private double height;
    private double width;

    @JsonIgnore
    public Point getPointA() {
        return Point.builder()
                .x(x)
                .y(y)
                .build();
    }

    @JsonIgnore
    public Point getPointB() {
        return Point.builder()
                .x(x + width)
                .y(y)
                .build();
    }

    @JsonIgnore
    public Point getPointC() {
        return Point.builder()
                .x(x)
                .y(y + height)
                .build();
    }

    @JsonIgnore
    public Point getPointD() {
        return Point.builder()
                .x(x + width)
                .y(y + height)
                .build();
    }

    @JsonIgnore
    public YLine getLine1() {
        return new YLine(getPointA().getY(), getPointC().getY(), getPointA().getX());
    }

    @JsonIgnore
    public XLine getLine2() {
        return new XLine(getPointB().getX(), getPointB().getX(), getPointA().getY());
    }

    @JsonIgnore
    public YLine getLine3() {
        return new YLine(getPointB().getY(), getPointD().getY(), getPointB().getX());
    }

    @JsonIgnore
    public XLine getLine4() {
        return new XLine(getPointC().getX(), getPointD().getX(), getPointB().getY());
    }
}
