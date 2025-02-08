package org.wingate.fontbox.type;

public abstract class ValueType implements ValueTypeInterface {

    protected static int SIZE = 0;

    @Override
    public int getSize() {
        return SIZE;
    }
}
