package org.wingate.fontbox.type;

public abstract class ValueType implements ValueTypeInterface {

    public static int SIZE = 0;

    @Override
    public int getSize() {
        return SIZE;
    }
}
