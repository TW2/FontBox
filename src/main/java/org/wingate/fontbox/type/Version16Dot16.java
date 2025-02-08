package org.wingate.fontbox.type;

public enum Version16Dot16 {
    Unknown(new byte[]{0x00, 0x00, 0x00, 0x00}, "Unknown"),
    TrueType(new byte[]{0x00, 0x01, 0x00, 0x00}, "TrueType Default"),
    TrueTypeApple(new byte[]{0x54, 0x52, 0x55, 0x45}, "TrueType Apple"),
    Type1(new byte[]{0x54, 0x59, 0x50, 0x31}, "Type1"),
    CFF_OTTO(new byte[]{0x4F, 0x54, 0x54, 0x4F}, "CFF");

    final byte[] version;
    final String name;

    Version16Dot16(byte[] version, String name){
        this.version = version;
        this.name = name;
    }

    public byte[] getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public static Version16Dot16 get(byte[] bytes){
        Version16Dot16 vd = Unknown;

        for(Version16Dot16 v : values()){
            byte[] vBytes = v.getVersion();
            if(
                bytes[0] == vBytes[0] &&
                bytes[1] == vBytes[1] &&
                bytes[2] == vBytes[2] &&
                bytes[3] == vBytes[3]
            ){
                vd = v;
                break;
            }
        }

        return vd;
    }
}
