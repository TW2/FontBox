package org.wingate.fontbox.type;

public class UFWORD extends ValueType {

    private UInt16 ufword;

    public UFWORD(UInt16 value) {
        this.ufword = value;
        SIZE = 16;
    }

    public UFWORD() {
        this(new UInt16((0)));
    }

    public UFWORD(byte[] bytes) {
        this(UInt16.decode(bytes));
    }

    public UInt16 getUfword() {
        return ufword;
    }

    public void setUfword(UInt16 ufword) {
        this.ufword = ufword;
    }
}
