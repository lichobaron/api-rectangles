package org.licho.apirectangles.domain.line;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class XLine extends Line {

    private double y;

    public XLine(double a, double b, double y) {
        super(a, b);
        this.y = y;
    }

    @Override
    public double getAxisPos() {
        return y;
    }
}
