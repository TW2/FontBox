package org.wingate.fontbox.type;

public class FWORD {
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
