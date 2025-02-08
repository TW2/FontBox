package org.wingate.fontbox;

import org.wingate.fontbox.io.FontX;
import org.wingate.fontbox.util.Load;

import java.nio.ByteBuffer;

public class FontBox {
    public static void main(String[] args) {
        ByteBuffer buffer = Load.fromResource("/org/wingate/fontbox/000.ttf");
        assert buffer != null;
        FontX fx = FontX.readFont(buffer);
        fx.debug();
    }
}
