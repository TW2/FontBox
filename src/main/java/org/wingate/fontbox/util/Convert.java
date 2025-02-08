package org.wingate.fontbox.util;

public class Convert {

    public static String toHex(byte b){
        return Integer.toHexString(Integer.parseInt(Byte.toString(b)));
    }

    public static String toHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(toHex(b));
        }
        return sb.toString();
    }

}
