package org.wingate.fontbox.type;

public class Version16Dot16 extends ValueType {

    public enum Type {
        Unknown(new byte[]{0x00, 0x00, 0x00, 0x00}, "Unknown"),
        TrueType(new byte[]{0x00, 0x01, 0x00, 0x00}, "TrueType Default"),
        TrueTypeApple(new byte[]{0x54, 0x52, 0x55, 0x45}, "TrueType Apple"),
        Type1(new byte[]{0x54, 0x59, 0x50, 0x31}, "Type1"),
        CFF_OTTO(new byte[]{0x4F, 0x54, 0x54, 0x4F}, "CFF");

        final byte[] version;
        final String name;

        Type(byte[] version, String name){
            this.version = version;
            this.name = name;
        }

        public byte[] getVersion() {
            return version;
        }

        public String getName() {
            return name;
        }

        public static Type get(byte[] bytes){
            Type vd = Unknown;

            for(Type v : values()){
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

    private Type type;

    public Version16Dot16(byte[] bytes){
        type = Type.get(bytes);
        SIZE = 32;
    }

    public Version16Dot16(){
        type = Type.Unknown;
        SIZE = 32;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
