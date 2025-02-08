package org.wingate.fontbox.table;

import java.nio.ByteBuffer;

public interface TableIO {
    public void read(ByteBuffer buffer, int offset, int length);
}
