package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class BaseScriptList extends Entity implements TableIO {

    private Field<UInt16> baseScriptCount;
    private List<BaseScriptRecord> baseScriptRecords;

    public BaseScriptList() {
        baseScriptCount = new Field<>(new UInt16(0));
        baseScriptRecords = new ArrayList<>();
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        int cursor = offset;
        baseScriptCount = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;
        for(int i=0; i<baseScriptCount.getUnit().getUint16(); i++){
            BaseScriptRecord rec = new BaseScriptRecord();
            rec.read(buffer, cursor, 4);
            cursor += 4;
            baseScriptRecords.add(rec);
        }
    }

    public Field<UInt16> getBaseScriptCount() {
        return baseScriptCount;
    }

    public void setBaseScriptCount(Field<UInt16> baseScriptCount) {
        this.baseScriptCount = baseScriptCount;
    }

    public List<BaseScriptRecord> getBaseScriptRecords() {
        return baseScriptRecords;
    }

    public void setBaseScriptRecords(List<BaseScriptRecord> baseScriptRecords) {
        this.baseScriptRecords = baseScriptRecords;
    }
}
