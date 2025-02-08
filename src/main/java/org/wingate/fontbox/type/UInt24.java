package org.wingate.fontbox.type;

public class UInt24 extends ValueType {
    private static final int MAX_VALUE_INT = 0x00ffffff;
    public static final UInt24 ZERO = new UInt24(0);
    public static final UInt24 MAX_VALUE = new UInt24(MAX_VALUE_INT);

    private int uint24;

    public UInt24(int value) {
        this.uint24 = value;
        SIZE = 24;
    }

    public UInt24(byte[] bytes) {
        this(UInt24.decode(bytes).getUint24());
    }

    public static byte[] encode(UInt24 value) {
        byte[] bytes = new byte[SIZE / Byte.SIZE];
        bytes[2] = (byte) (value.getUint24());
        bytes[1] = (byte) (value.getUint24() >>>  8);
        bytes[0] = (byte) (value.getUint24() >>> 16);
        return bytes;
    }

    public static UInt24 decode(byte[] bytes) {
        return new UInt24((bytes[2] & 0xFF) +
                ((bytes[1] & 0xFF) << 8) +
                ((bytes[0] & 0xFF) << 16));
    }

    public int getUint24() {
        return uint24;
    }

    public void setUint24(int uint24) {
        this.uint24 = uint24;
    }

    public static int getOffset24(){
        return 0x000000;
    }
}
