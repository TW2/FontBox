package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;

public class BaseScriptRecord extends Entity implements TableIO {

    private Field<ByteBuffer> baseScriptTag;
    private Field<UInt16> baseScriptOffset;

    public BaseScriptRecord(Field<ByteBuffer> baseScriptTag) {
        this.baseScriptTag = baseScriptTag;
        baseScriptOffset = new Field<>(new UInt16(0));
    }

    public BaseScriptRecord() {
        this(new Field<>(ByteBuffer.allocate(4)));
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        baseScriptOffset = new Field<>((UInt16) Reader.read(buffer, offset, new UInt16(0)));
    }

    public Field<ByteBuffer> getBaseScriptTag() {
        return baseScriptTag;
    }

    public void setBaseScriptTag(Field<ByteBuffer> baseScriptTag) {
        this.baseScriptTag = baseScriptTag;
    }

    public Field<UInt16> getBaseScriptOffset() {
        return baseScriptOffset;
    }

    public void setBaseScriptOffset(Field<UInt16> baseScriptOffset) {
        this.baseScriptOffset = baseScriptOffset;
    }
}
