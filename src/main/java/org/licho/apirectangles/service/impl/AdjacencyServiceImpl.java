package org.licho.apirectangles.service.impl;

import org.licho.apirectangles.domain.AdjacencyType;
import org.licho.apirectangles.domain.Rectangle;
import org.licho.apirectangles.domain.line.Line;
import org.licho.apirectangles.service.AdjacencyService;
import org.springframework.stereotype.Service;

@Service
public class AdjacencyServiceImpl implements AdjacencyService {

    @Override
    public AdjacencyType identifyAdjacency(Rectangle rectangle1, Rectangle rectangle2) {

        if (isProperAdjacency(rectangle1, rectangle2)) {
            return AdjacencyType.PROPER;
        }
        if (isPartialAdjacency(rectangle1, rectangle2)) {
            return AdjacencyType.PARTIAL;
        }
        if (isSubLineAdjacency(rectangle1, rectangle2)) {
            return AdjacencyType.SUB_LINE;
        }

        return AdjacencyType.NOT_ADJACENT;
    }

    private boolean isProperAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return compareProperAdjacency(rectangle1, rectangle2) || compareProperAdjacency(rectangle2, rectangle1);
    }

    private boolean compareProperAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return areLinesEqual(rectangle1.getLine1(), rectangle2.getLine1()) ||
                areLinesEqual(rectangle1.getLine1(), rectangle2.getLine3()) ||
                areLinesEqual(rectangle1.getLine2(), rectangle2.getLine2()) ||
                areLinesEqual(rectangle1.getLine2(), rectangle2.getLine4());
    }

    private boolean areLinesEqual(Line line1, Line line2) {
        return areInSameAxis(line1, line2) &&
                ((line1.getA() == line2.getA() && line1.getB() == line2.getB()) ||
                        (line1.getA() == line2.getB() && line1.getB() == line2.getA()));
    }

    private boolean isPartialAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return comparePartialAdjacency(rectangle1, rectangle2) || comparePartialAdjacency(rectangle2, rectangle1);
    }

    private boolean comparePartialAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return areLinesOverlapped(rectangle1.getLine1(), rectangle2.getLine1()) ||
                areLinesOverlapped(rectangle1.getLine1(), rectangle2.getLine3()) ||
                areLinesOverlapped(rectangle1.getLine2(), rectangle2.getLine2()) ||
                areLinesOverlapped(rectangle1.getLine2(), rectangle2.getLine4());
    }

    private boolean areLinesOverlapped(Line line1, Line line2) {
        return areInSameAxis(line1, line2) &&
                ((line1.getA() <= line2.getA() && line1.getB() >= line2.getB()) ||
                        (line1.getA() <= line2.getB() && line1.getB() >= line2.getA()) ||
                        (line1.getB() <= line2.getB() && line1.getA() >= line2.getA()));
    }

    private boolean isSubLineAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return compareSubLineAdjacency(rectangle1, rectangle2) || compareSubLineAdjacency(rectangle1, rectangle2);
    }

    private boolean compareSubLineAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return areLinesContained(rectangle1.getLine1(), rectangle2.getLine1()) ||
                areLinesContained(rectangle1.getLine1(), rectangle2.getLine3()) ||
                areLinesContained(rectangle1.getLine2(), rectangle2.getLine2()) ||
                areLinesContained(rectangle1.getLine2(), rectangle2.getLine4());
    }

    private boolean areLinesContained(Line line1, Line line2) {
        return areInSameAxis(line1, line2) &&
                ((line1.getA() >= line2.getA() && line1.getB() <= line2.getB()) ||
                        (line1.getA() >= line2.getB() && line1.getB() <= line2.getA()) ||
                        (line1.getB() >= line2.getB() && line1.getA() <= line2.getA()));
    }

    private boolean areInSameAxis(Line line1, Line line2) {
        return line1.getAxisPos() == line2.getAxisPos();
    }
}
