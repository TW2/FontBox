package org.wingate.fontbox.type;

import java.nio.ByteBuffer;

// 16 bits signed (eq. to int)
public class F2DOT14 {

    public static final int SIZE = 16;
    public static final int BYTES = SIZE / Byte.SIZE;

    private byte[] f2dot14;

    public F2DOT14(byte[] value) {
        this.f2dot14 = value;
    }

    public byte[] getF2dot14() {
        return f2dot14;
    }

    public void setF2dot14(byte[] f2dot14) {
        this.f2dot14 = f2dot14;
    }

    public static double toDecimal(F2DOT14 value){
        ByteBuffer mantissa = ByteBuffer.wrap(value.getF2dot14(), 0, 2);
        ByteBuffer fraction = ByteBuffer.wrap(value.getF2dot14(), 2, 14);

        int vSignInteger = mantissa.getInt();
        double vFraction = fraction.getDouble() / 16384d;

        double result = vSignInteger + vFraction;

        System.out.println(result);

        return result;
    }
}
