package org.wingate.fontbox.type;

public class UFWORD {
    private UInt16 ufword;

    public UFWORD(UInt16 value) {
        this.ufword = value;
    }

    public UFWORD() {
        ufword = new UInt16(0);
    }

    public UInt16 getUfword() {
        return ufword;
    }

    public void setUfword(UInt16 ufword) {
        this.ufword = ufword;
    }
}
