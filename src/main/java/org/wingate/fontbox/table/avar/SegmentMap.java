package org.wingate.fontbox.table.avar;

import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;

import java.util.ArrayList;
import java.util.List;

public class SegmentMap extends Entity {

    private Field<UInt16> positionMapCount;
    private List<Field<AxisValueMap>> axisValueMaps;

    public SegmentMap(Field<UInt16> positionMapCount) {
        this.positionMapCount = positionMapCount;
        axisValueMaps = new ArrayList<>();

        name = "axisSegmentMaps[axisCount]";
        description = "The segment maps array — one segment map for each axis, " +
                "in the order of axes specified in the 'fvar' table.";
    }

    public SegmentMap() {
        Field<UInt16> positionMapCount = new Field<>();
        positionMapCount.setUnit(new UInt16(0));
        this(positionMapCount);
    }

    public Field<UInt16> getPositionMapCount() {
        return positionMapCount;
    }

    public void setPositionMapCount(Field<UInt16> positionMapCount) {
        this.positionMapCount = positionMapCount;
    }

    public List<Field<AxisValueMap>> getAxisValueMaps() {
        return axisValueMaps;
    }

    public void setAxisValueMaps(List<Field<AxisValueMap>> axisValueMaps) {
        this.axisValueMaps = axisValueMaps;
    }
}
