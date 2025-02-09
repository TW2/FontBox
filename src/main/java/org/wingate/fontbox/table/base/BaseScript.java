package org.wingate.fontbox.table.base;

import org.wingate.fontbox.table.TableIO;
import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.util.Entity;
import org.wingate.fontbox.util.Field;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class BaseScript extends Entity implements TableIO {

    private Field<UInt16> baseValuesOffset;
    private Field<UInt16> defaultMinMaxOffset;
    private Field<UInt16> baseLangSysCount;
    private List<BaseLangSys> baseLangSysRecords;

    public BaseScript() {
        baseValuesOffset = new Field<>(new UInt16(0));
        defaultMinMaxOffset = new Field<>(new UInt16(0));
        baseLangSysCount = new Field<>(new UInt16(0));
        baseLangSysRecords = new ArrayList<>();
    }

    @Override
    public void read(ByteBuffer buffer, int offset, int length) {
        int cursor = offset;

        baseValuesOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        defaultMinMaxOffset = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        baseLangSysCount = new Field<>((UInt16) Reader.read(buffer, cursor, new UInt16(0)));
        cursor += UInt16.SIZE / Byte.SIZE;

        for(int i=0; i<baseLangSysCount.getUnit().getUint16(); i++){
            BaseLangSys bls = new BaseLangSys();
            bls.read(buffer, cursor, 6);
            cursor += 6;
            baseLangSysRecords.add(bls);
        }
    }

    public Field<UInt16> getBaseValuesOffset() {
        return baseValuesOffset;
    }

    public void setBaseValuesOffset(Field<UInt16> baseValuesOffset) {
        this.baseValuesOffset = baseValuesOffset;
    }

    public Field<UInt16> getDefaultMinMaxOffset() {
        return defaultMinMaxOffset;
    }

    public void setDefaultMinMaxOffset(Field<UInt16> defaultMinMaxOffset) {
        this.defaultMinMaxOffset = defaultMinMaxOffset;
    }

    public Field<UInt16> getBaseLangSysCount() {
        return baseLangSysCount;
    }

    public void setBaseLangSysCount(Field<UInt16> baseLangSysCount) {
        this.baseLangSysCount = baseLangSysCount;
    }

    public List<BaseLangSys> getBaseLangSysRecords() {
        return baseLangSysRecords;
    }

    public void setBaseLangSysRecords(List<BaseLangSys> baseLangSysRecords) {
        this.baseLangSysRecords = baseLangSysRecords;
    }
}
