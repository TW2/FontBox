package org.wingate.fontbox.table.avar;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.F2DOT14;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Avar extends Entity implements TableIO {

    private Field<UInt16> majorVersion;
    private Field<UInt16> minorVersion;
    private Field<UInt16> reserved;
    private Field<UInt16> axisCount;
    private List<Field<SegmentMap>> axisSegmentMaps;

    public Avar() {
        name = "avar";
        description = "Axis Variations Table";
        helpLinks.add("https://learn.microsoft.com/en-us/typography/opentype/spec/avar");

        majorVersion = new Field<>(new UInt16(1));
        minorVersion = new Field<>(new UInt16(0));
        reserved = new Field<>(new UInt16(0));
        axisCount = new Field<>(new UInt16(0));

        axisSegmentMaps = new ArrayList<>();
    }

    public Field<UInt16> getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(Field<UInt16> majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Field<UInt16> getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Field<UInt16> minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Field<UInt16> getReserved() {
        return reserved;
    }

    public void setReserved(Field<UInt16> reserved) {
        this.reserved = reserved;
    }

    public Field<UInt16> getAxisCount() {
        return axisCount;
    }

    public void setAxisCount(Field<UInt16> axisCount) {
        this.axisCount = axisCount;
    }

    public List<Field<SegmentMap>> getAxisSegmentMaps() {
        return axisSegmentMaps;
    }

    public void setAxisSegmentMaps(List<Field<SegmentMap>> axisSegmentMaps) {
        this.axisSegmentMaps = axisSegmentMaps;
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        // Cursor
        int cursor = offset;

        // Read major version
        majorVersion = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        // Read minor version
        minorVersion = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        // Read (reserved)
        reserved = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        // Read axis count
        axisCount = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        // Init segment map
        for(int i=0; i<axisCount.getUnit().getUint16(); i++){
            // Read segment map
            Field<UInt16> pos = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
            cursor += UInt16.SIZE / Byte.SIZE;
            SegmentMap sm = new SegmentMap(pos);
            for(int j=0; j<pos.getUnit().getUint16(); j++){
                // Read axis value map
                AxisValueMap axis = new AxisValueMap();
                axis.setFromCoordinate(new Field<>((F2DOT14) Reader.read(buffer, cursor, new F2DOT14(new byte[0]))));
                cursor += F2DOT14.SIZE / Byte.SIZE;
                axis.setToCoordinate(new Field<>((F2DOT14) Reader.read(buffer, cursor, new F2DOT14(new byte[0]))));
                cursor += F2DOT14.SIZE / Byte.SIZE;
                sm.getAxisValueMaps().add(new Field<>(axis));
            }
            axisSegmentMaps.add(new Field<>(sm));
        }

    }
}
