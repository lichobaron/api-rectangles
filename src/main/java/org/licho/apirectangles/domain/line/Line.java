package org.licho.apirectangles.domain.line;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public abstract class Line {
    /*
        Line examples:
        B
        |
        |
        |
        |
        A

        A _______________ B
     */
    private double a;
    private double b;

    public abstract double getAxisPos();

    private double getSize() {
        return b - a;
    }
}
