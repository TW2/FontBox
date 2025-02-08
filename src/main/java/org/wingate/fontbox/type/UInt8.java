package org.wingate.fontbox.type;

public class UInt8 {
    private static final int MAX_VALUE_INT = 0xff;
    private static final int SIZE = 8;
    public static final int BYTES = SIZE / Byte.SIZE;
    public static final UInt8 MAX_VALUE = new UInt8(MAX_VALUE_INT);

    private int uint8;

    public UInt8(int value) {
        this.uint8 = value;
    }

    public static byte[] encode(UInt8 value) {
        return new byte[]{(byte) value.getUint8()};
    }

    public static UInt8 decode(byte[] bytes) {
        return new UInt8(bytes[0] & 0xFF);
    }

    public int getUint8() {
        return uint8;
    }

    public void setUint8(int uint8) {
        this.uint8 = uint8;
    }

    public static int getOffset8(){
        return 0x00;
    }
}
