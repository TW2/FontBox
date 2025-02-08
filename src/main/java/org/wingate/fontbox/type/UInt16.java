package org.wingate.fontbox.type;

public class UInt16 extends ValueType {

    private int uint16;

    public UInt16(int value) {
        this.uint16 = value;
        SIZE = 16;
    }

    public UInt16(byte[] bytes) {
        this(UInt16.decode(bytes).getUint16());
    }

    public static byte[] encode(UInt16 value) {
        byte[] bytes = new byte[SIZE / Byte.SIZE];
        bytes[1] = (byte) (value.getUint16());
        bytes[0] = (byte) (value.getUint16() >>>  8);
        return bytes;
    }

    public static UInt16 decode(byte[] bytes) {
        return new UInt16((bytes[1] & 0xFF) + ((bytes[0] & 0xFF) << 8));
    }

    public int getUint16() {
        return uint16;
    }

    public void setUint16(int uint16) {
        this.uint16 = uint16;
    }

    public static int getOffset16(){
        return 0x0000;
    }
}
