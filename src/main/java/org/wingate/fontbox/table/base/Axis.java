package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;

public class Axis extends Entity implements TableIO {

    private Field<UInt16> baseTagListOffset;
    private Field<UInt16> baseScriptListOffset;

    public Axis() {
        baseTagListOffset = new Field<>(new UInt16(0));
        baseScriptListOffset = new Field<>(new UInt16(0));
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        // Cursor
        int cursor = offset;

        // Read major version
        baseTagListOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        // Read minor version
        baseScriptListOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
    }

    public Field<UInt16> getBaseTagListOffset() {
        return baseTagListOffset;
    }

    public void setBaseTagListOffset(Field<UInt16> baseTagListOffset) {
        this.baseTagListOffset = baseTagListOffset;
    }

    public Field<UInt16> getBaseScriptListOffset() {
        return baseScriptListOffset;
    }

    public void setBaseScriptListOffset(Field<UInt16> baseScriptListOffset) {
        this.baseScriptListOffset = baseScriptListOffset;
    }
}
