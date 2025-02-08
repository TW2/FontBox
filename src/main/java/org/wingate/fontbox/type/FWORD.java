package org.wingate.fontbox.type;

import java.nio.ByteBuffer;

public class FWORD extends ValueType {

    private int fword;

    public FWORD(int value) {
        this.fword = value;
        SIZE = 16;
    }

    public FWORD() {
        this(0);
    }

    public FWORD(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        this(buffer.getInt());
    }

    public int getFword() {
        return fword;
    }

    public void setFword(int fword) {
        this.fword = fword;
    }
}
