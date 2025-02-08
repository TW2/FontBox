package org.wingate.fontbox.type;

public class FWORD {

    public static final int SIZE = 16;
    public static final int BYTES = SIZE / Byte.SIZE;

    private int fword;

    public FWORD(int value) {
        this.fword = value;
    }

    public FWORD() {
        fword = 0;
    }

    public int getFword() {
        return fword;
    }

    public void setFword(int fword) {
        this.fword = fword;
    }
}
