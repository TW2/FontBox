package org.wingate.fontbox.util;

import java.io.*;
import java.nio.ByteBuffer;

public class Load {

    public static ByteBuffer fromResource(String resource){
        try (InputStream in = Load.class.getResourceAsStream(resource)) {
            if (in != null) {
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
                    out.write(in.readAllBytes());
                    return ByteBuffer.wrap(out.toByteArray());
                }
            }
        } catch (IOException _) { }
        return null;
    }

}
