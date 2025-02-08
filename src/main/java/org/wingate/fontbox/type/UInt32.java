package org.wingate.fontbox.type;

public class UInt32 {
    private static final long MAX_VALUE_INT = 0xffffffffL;
    public static final int SIZE = 32;
    public static final int BYTES = SIZE / Byte.SIZE;
    public static final UInt32 ZERO = new UInt32(0);
    public static final UInt32 MAX_VALUE = new UInt32(MAX_VALUE_INT);

    private long uint32;

    public UInt32(long value) {
        this.uint32 = value;
    }

    public static byte[] encode(UInt32 value) {
        byte[] bytes = new byte[BYTES];
        bytes[3] = (byte) (value.getUint32());
        bytes[2] = (byte) (value.getUint32() >>>  8);
        bytes[1] = (byte) (value.getUint32() >>> 16);
        bytes[0] = (byte) (value.getUint32() >>> 24);
        return bytes;
    }

    public static UInt32 decode(byte[] bytes) {
        return new UInt32( (bytes[3] & 0xFF) + ((bytes[2] & 0xFF) << 8) +
                        ((bytes[1] & 0xFF) << 16) + ((long) (bytes[0] & 0xFF) << 24));
    }

    public long getUint32() {
        return uint32;
    }

    public void setUint32(long uint32) {
        this.uint32 = uint32;
    }

    public static long getOffset32() {
        return 0x00000000;
    }
}
