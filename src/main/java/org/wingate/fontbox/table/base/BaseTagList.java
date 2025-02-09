package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class BaseTagList extends Entity implements TableIO {

    private Field<UInt16> baseTagCount;
    private List<ByteBuffer> baselineTags;

    public BaseTagList() {
        // Number of baseline identification tags in this text direction — may be zero (0).
        baseTagCount = new Field<>(new UInt16(0));
        // Array of 4-byte baseline identification tags — must be in alphabetical order.
        baselineTags = new ArrayList<>();
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        // Cursor
        int cursor = offset;

        baseTagCount = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        for(int i=0; i<baseTagCount.getUnit().getUint16(); i++){
            byte[] bytes = new byte[4];
            ByteBuffer b2 = buffer.get(cursor, bytes, 0, 4);
            baselineTags.add(b2);
            cursor += 4;
        }
    }

    public Field<UInt16> getBaseTagCount() {
        return baseTagCount;
    }

    public void setBaseTagCount(Field<UInt16> baseTagCount) {
        this.baseTagCount = baseTagCount;
    }

    public List<ByteBuffer> getBaselineTags() {
        return baselineTags;
    }

    public void setBaselineTags(List<ByteBuffer> baselineTags) {
        this.baselineTags = baselineTags;
    }
}
