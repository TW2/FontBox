package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.type.UInt32;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;

public class Base extends Entity implements TableIO {

    private Field<UInt16> majorVersion;
    private Field<UInt16> minorVersion;
    private Field<UInt16> horizAxisOffset;
    private Field<UInt16> vertAxisOffset;
    // When version is 1.0, do not use itemVarStoreOffset
    // When version is 1.1, must use itemVarStoreOffset
    private Field<UInt32> itemVarStoreOffset;

    public Base() {
        name = "BASE";
        description = "Baseline Table";
        helpLinks.add("https://learn.microsoft.com/en-us/typography/opentype/spec/base");

        majorVersion = new Field<>(new UInt16(1));
        minorVersion = new Field<>(new UInt16(1));
        horizAxisOffset = new Field<>(new UInt16(0));
        vertAxisOffset = new Field<>(new UInt16(0));
        itemVarStoreOffset = new Field<>(new UInt32(0));
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

        // Read horizontal axis offset
        horizAxisOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        // Read vertical axis offset
        vertAxisOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        if(minorVersion.getUnit().getUint16() == 1){
            // Read item var store offset
            itemVarStoreOffset = new Field<>((UInt32) Reader.read(buffer, cursor, new UInt32(0)));
            cursor += UInt32.SIZE / Byte.SIZE;
        }
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

    public Field<UInt16> getHorizAxisOffset() {
        return horizAxisOffset;
    }

    public void setHorizAxisOffset(Field<UInt16> horizAxisOffset) {
        this.horizAxisOffset = horizAxisOffset;
    }

    public Field<UInt16> getVertAxisOffset() {
        return vertAxisOffset;
    }

    public void setVertAxisOffset(Field<UInt16> vertAxisOffset) {
        this.vertAxisOffset = vertAxisOffset;
    }

    public Field<UInt32> getItemVarStoreOffset() {
        return itemVarStoreOffset;
    }

    public void setItemVarStoreOffset(Field<UInt32> itemVarStoreOffset) {
        this.itemVarStoreOffset = itemVarStoreOffset;
    }
}
