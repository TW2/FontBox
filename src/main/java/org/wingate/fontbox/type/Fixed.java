package org.wingate.fontbox.type;

import java.nio.ByteBuffer;

// 32 bits signed (eq. to long)
public class Fixed extends ValueType {

    private byte[] fixed;

    public Fixed(byte[] fixed) {
        this.fixed = fixed;
        SIZE = 32;
    }

    public byte[] getFixed() {
        return fixed;
    }

    public void setFixed(byte[] fixed) {
        this.fixed = fixed;
    }

    public static double toDouble(Fixed value){
        ByteBuffer u1 = ByteBuffer.wrap(value.getFixed(), 0, 16);
        ByteBuffer u2 = ByteBuffer.wrap(value.getFixed(), 16, 32);

        double result = u1.getDouble() / u2.getDouble();

        System.out.println(result);

        return result;
    }
}
