package org.wingate.fontbox.io;

import org.wingate.fontbox.type.UInt32;
import org.wingate.fontbox.util.Convert;

public class TableRecord {

    // tableRecords[numTables]
    // Table records array—one for each top-level table in the font.
    public enum TableName{
        Unknown(new byte[]{0x00, 0x00, 0x00, 0x00}, "Unknown"),
        FFTM(new byte[]{0x46, 0x46, 0x54, 0x4D}, "FFTM"),
        GDEF(new byte[]{0x47, 0x44, 0x45, 0x46}, "GDEF"),
        GPOS(new byte[]{0x47, 0x50, 0x4F, 0x53}, "GPOS"),
        GSUB(new byte[]{0x47, 0x53, 0x55, 0x42}, "GSUB"),
        OS_2(new byte[]{0x4F, 0x53, 0x2F, 0x32}, "OS/2"),
        cmap(new byte[]{0x63, 0x6D, 0x61, 0x70}, "cmap"),
        gasp(new byte[]{0x67, 0x61, 0x73, 0x70}, "gasp"),
        glyf(new byte[]{0x67, 0x6C, 0x79, 0x66}, "glyf"),
        head(new byte[]{0x68, 0x65, 0x61, 0x64}, "head"),
        hhea(new byte[]{0x68, 0x68, 0x65, 0x61}, "hhea"),
        hmtx(new byte[]{0x68, 0x6D, 0x74, 0x78}, "hmtx"),
        loca(new byte[]{0x6C, 0x6F, 0x63, 0x61}, "loca"),
        maxp(new byte[]{0x6D, 0x61, 0x78, 0x70}, "maxp"),
        name(new byte[]{0x6E, 0x61, 0x6D, 0x65}, "name"),
        post(new byte[]{0x70, 0x6F, 0x73, 0x74}, "post");

        final byte[] bytes;
        final String tableName;

        TableName(byte[] bytes, String tableName){
            this.bytes = bytes;
            this.tableName = tableName;
        }

        public byte[] getBytes() {
            return bytes;
        }

        public String getTableName() {
            return tableName;
        }

        public static TableName get(byte[] bytes){
            TableName record = Unknown;

            for(TableName tr : values()){
                byte[] trBytes = tr.getBytes();
                if(
                        bytes[0] == trBytes[0] &&
                                bytes[1] == trBytes[1] &&
                                bytes[2] == trBytes[2] &&
                                bytes[3] == trBytes[3]
                ){
                    record = tr;
                    break;
                }
            }

            return record;
        }

        public static TableName get(String tableName){
            TableName record = Unknown;

            for(TableName tr : values()){
                if(tr.getTableName().equals(tableName)){
                    record = tr;
                    break;
                }
            }

            return record;
        }
    }

    private TableName tableName;
    private String checksum;
    private UInt32 offset;
    private UInt32 length;

    public TableRecord(){
        tableName = TableName.Unknown;
        checksum = "00000000";
        offset = UInt32.decode(new byte[]{0x00, 0x00, 0x00, 0x00});
        length = new UInt32(0);
    }

    public static TableRecord create(byte[] tag, byte[] checksum, byte[] offset, byte[] length){
        TableRecord tr = new TableRecord();

        tr.tableName = TableName.get(tag);
        tr.checksum = getCheckSumFromBytes(checksum);
        tr.offset = UInt32.decode(offset);
        tr.length = UInt32.decode(length);

        return tr;
    }

    private static String getCheckSumFromBytes(byte[] bytes){
        return Convert.toHex(bytes);
    }

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public UInt32 getOffset() {
        return offset;
    }

    public void setOffset(UInt32 offset) {
        this.offset = offset;
    }

    public UInt32 getLength() {
        return length;
    }

    public void setLength(UInt32 length) {
        this.length = length;
    }
}
