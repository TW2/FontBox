package org.wingate.fontbox.util;

import org.wingate.fontbox.type.*;

import java.nio.ByteBuffer;

public class Reader {

    public static ValueType read(ByteBuffer buffer, int offset, ValueType of){
        byte[] bytes = new byte[of.getSize()];
        buffer.get(offset, bytes, 0, of.getSize());

        ValueType result = null;

        switch(of){
            case F2DOT14 x -> result = new F2DOT14(bytes);
            case Fixed x -> result = new Fixed(bytes);
            case FWORD x -> result = new FWORD(bytes);
            case LONGDATETIME x -> result = new LONGDATETIME(bytes);
            case UFWORD x -> result = new UFWORD(bytes);
            case UInt8 x -> result = new UInt8(bytes);
            case UInt16 x -> result = new UInt16(bytes);
            case UInt24 x -> result = new UInt24(bytes);
            case UInt32 x -> result = new UInt32(bytes);
            case Version16Dot16 x -> result = new Version16Dot16(bytes);
            default -> { }
        }

        return result;
    }

    public static short readShort(ByteBuffer buffer, int offset, int size){
        byte[] bytes = new byte[size];
        buffer.get(offset, bytes, 0, size);
        return buffer.getShort();
    }

    public static int readInt(ByteBuffer buffer, int offset, int size){
        byte[] bytes = new byte[size];
        buffer.get(offset, bytes, 0, size);
        return buffer.getInt();
    }

    public static long readLong(ByteBuffer buffer, int offset, int size){
        byte[] bytes = new byte[size];
        buffer.get(offset, bytes, 0, size);
        return buffer.getLong();
    }

}
