package org.wingate.fontbox.io;

import org.wingate.fontbox.type.UInt16;
import org.wingate.fontbox.type.Version16Dot16;
import org.wingate.fontbox.util.Reader;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class FontX {



    private Version16Dot16.Type version;
    private int numTables;

    private List<TableRecord> tableRecords;

    // Maximum power of 2 less than or equal to numTables,
    // times 16 ((2**floor(log2(numTables))) * 16,
    // where “**” is an exponentiation operator).
    private int searchRange;

    // Log2 of the maximum power of 2 less than or equal
    // to numTables (log2(searchRange/16),
    // which is equal to floor(log2(numTables))).
    private int entrySelector;

    // numTables times 16, minus searchRange ((numTables * 16) - searchRange).
    private int rangeShift;

    public FontX(){
        version = Version16Dot16.Type.Unknown;
        numTables = 0;
        tableRecords = new ArrayList<>();
        searchRange = 0;
        entrySelector = 0;
        rangeShift = 0;
    }

    public static FontX readFont(ByteBuffer buffer){
        FontX fx = new FontX();

        // Font version (sfnt)
        Version16Dot16 version = (Version16Dot16) Reader.read(buffer, 0, new Version16Dot16());
        fx.version = (version).getType();

        // numTables
        fx.numTables = ((UInt16) Reader.read(buffer, 4, new UInt16(0))).getUint16();

        // searchRange
        fx.searchRange = ((UInt16) Reader.read(buffer, 6, new UInt16(0))).getUint16();

        // entrySelector
        fx.entrySelector = ((UInt16) Reader.read(buffer, 8, new UInt16(0))).getUint16();

        // rangeShift
        fx.rangeShift = ((UInt16) Reader.read(buffer, 10, new UInt16(0))).getUint16();

        // n tables
        for(int i=0, z=12; i<fx.numTables; i++){
            // tag
            byte[] tag = new byte[4];
            buffer.get(z, tag, 0, 4); z+=4;
            // checksum
            byte[] checksum = new byte[4];
            buffer.get(z, checksum, 0, 4); z+=4;
            // offset
            byte[] offset = new byte[4];
            buffer.get(z, offset, 0, 4); z+=4;
            // length
            byte[] length = new byte[4];
            buffer.get(z, length, 0, 4); z+=4;

            // tableRecords
            fx.tableRecords.add(TableRecord.create(tag, checksum, offset, length));
        }

        return fx;
    }

    public void debug(){
        System.out.println("=== DEBUG ===");
        System.out.printf("Font version: %s\n", getVersion().getName());
        System.out.printf("Tables count: %d\n", getNumTables());
        System.out.printf("Search range: %d\n", getSearchRange());
        System.out.printf("Entry selector: %d\n", getEntrySelector());
        System.out.printf("Range shift: %d\n", getRangeShift());
        for(int i=0; i<tableRecords.size(); i++){
            TableRecord tr = tableRecords.get(i);
            System.out.printf("--> %d\n", i+1);
            System.out.printf("   TABLE: %s\n", tr.getTableName());
            System.out.printf("   Checksum: %s\n", tr.getChecksum());
            System.out.printf("   Offset: %d\n", tr.getOffset().getUint32());
            System.out.printf("   Length: %d\n", tr.getLength().getUint32());
        }
        System.out.println("-------------");
    }

    public Version16Dot16.Type getVersion() {
        return version;
    }

    public void setVersion(Version16Dot16.Type version) {
        this.version = version;
    }

    public int getNumTables() {
        return numTables;
    }

    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }

    public List<TableRecord> getTableRecords() {
        return tableRecords;
    }

    public void setTableRecords(List<TableRecord> tableRecords) {
        this.tableRecords = tableRecords;
    }

    public int getSearchRange() {
        return searchRange;
    }

    public void setSearchRange(int searchRange) {
        this.searchRange = searchRange;
    }

    public int getEntrySelector() {
        return entrySelector;
    }

    public void setEntrySelector(int entrySelector) {
        this.entrySelector = entrySelector;
    }

    public int getRangeShift() {
        return rangeShift;
    }

    public void setRangeShift(int rangeShift) {
        this.rangeShift = rangeShift;
    }
}
