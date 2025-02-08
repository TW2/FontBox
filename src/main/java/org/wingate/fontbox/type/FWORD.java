package org.wingate.fontbox.type;

public class FWORD extends ValueType {

    private int fword;

    public FWORD(int value) {
        this.fword = value;
        SIZE = 16;
    }

    public FWORD() {
        this(0);
    }

    public int getFword() {
        return fword;
    }

    public void setFword(int fword) {
        this.fword = fword;
    }
}
