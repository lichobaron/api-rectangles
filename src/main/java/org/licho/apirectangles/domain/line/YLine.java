package org.licho.apirectangles.domain.line;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YLine extends Line {

    private double x;

    public YLine(double a, double b, double x) {
        super(a, b);
        this.x = x;
    }

    @Override
    public double getAxisPos() {
        return x;
    }
}
