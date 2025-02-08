package org.wingate.fontbox.table.avar;

import org.wingate.fontbox.type.F2DOT14;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;

public class AxisValueMap extends Entity {

    private Field<F2DOT14> fromCoordinate;
    private Field<F2DOT14> toCoordinate;

    public AxisValueMap() {
        name = "axisValueMaps[positionMapCount]";
        description = "The array of axis value map records for this axis.";
        fromCoordinate = new Field<>();
        fromCoordinate.setName("fromCoordinate");
        fromCoordinate.setDescription("A normalized coordinate value obtained using default normalization.");
        toCoordinate = new Field<>();
        toCoordinate.setName("toCoordinate");
        toCoordinate.setDescription("The modified, normalized coordinate value.");
    }

    public Field<F2DOT14> getFromCoordinate() {
        return fromCoordinate;
    }

    public void setFromCoordinate(Field<F2DOT14> fromCoordinate) {
        this.fromCoordinate = fromCoordinate;
    }

    public Field<F2DOT14> getToCoordinate() {
        return toCoordinate;
    }

    public void setToCoordinate(Field<F2DOT14> toCoordinate) {
        this.toCoordinate = toCoordinate;
    }
}
