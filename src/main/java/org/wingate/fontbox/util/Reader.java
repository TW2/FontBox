package org.wingate.fontbox.util;

import org.wingate.fontbox.type.*;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Reader {

    public static Object get(ByteBuffer buffer, int offset, Object ofClass){

        switch(ofClass){
            case F2DOT14 x -> {
                byte[] bytes = new byte[F2DOT14.SIZE];
                buffer.get(offset, bytes, 0, F2DOT14.SIZE);
                return new F2DOT14(bytes);
            }
            case Fixed x -> {
                return null;
            }
            case FWORD x -> {
                return null;
            }
            case LONGDATETIME x -> {
                return null;
            }
            case UFWORD x -> {
                return null;
            }
            case Byte x -> {
                return null;
            }
            case UInt8 x -> {
                return null;
            }
            case Short x -> {
                return null;
            }
            case UInt16 x -> {
                return null;
            }
            case UInt24 x -> {
                return null;
            }
            case Integer x -> {
                return null;
            }
            case UInt32 x -> {
                return null;
            }
            case BigInteger x -> {
                return null;
            }
            default -> throw new IllegalStateException("Unexpected value: " + ofClass);
        }

    }
}
