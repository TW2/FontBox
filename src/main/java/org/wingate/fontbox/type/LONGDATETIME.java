package org.wingate.fontbox.type;

import java.math.BigInteger;

public class LONGDATETIME extends ValueType {

    private BigInteger longDateTime;

    public LONGDATETIME(BigInteger value) {
        this.longDateTime = value;
        SIZE = 64;
    }

    public BigInteger getLongDateTime() {
        return longDateTime;
    }

    public void setLongDateTime(BigInteger longDateTime) {
        this.longDateTime = longDateTime;
    }
}
