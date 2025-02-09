package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;

public class BaseLangSys extends Entity implements TableIO {

    private ByteBuffer baseLangSysTag;
    private Field<UInt16> minMaxOffset;

    public BaseLangSys() {
        baseLangSysTag = null;
        minMaxOffset = new Field<>(new UInt16(0));
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        byte[] bytes = new byte[4];
        buffer.get(offset, bytes, 0, 4);
        baseLangSysTag = ByteBuffer.wrap(bytes);
        minMaxOffset = new Field<>((UInt16) Reader.read(buffer, offset + 4, new UInt16(0)));
    }

    public ByteBuffer getBaseLangSysTag() {
        return baseLangSysTag;
    }

    public void setBaseLangSysTag(ByteBuffer baseLangSysTag) {
        this.baseLangSysTag = baseLangSysTag;
    }

    public Field<UInt16> getMinMaxOffset() {
        return minMaxOffset;
    }

    public void setMinMaxOffset(Field<UInt16> minMaxOffset) {
        this.minMaxOffset = minMaxOffset;
    }
}
