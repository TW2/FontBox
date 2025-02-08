package org.wingate.fontbox.type;

import java.math.BigInteger;

public class LONGDATETIME {

    public static final int SIZE = 64;
    public static final int BYTES = SIZE / Byte.SIZE;

    private BigInteger longDateTime;

    public LONGDATETIME(BigInteger value) {
        this.longDateTime = value;
    }

    public BigInteger getLongDateTime() {
        return longDateTime;
    }

    public void setLongDateTime(BigInteger longDateTime) {
        this.longDateTime = longDateTime;
    }
}
