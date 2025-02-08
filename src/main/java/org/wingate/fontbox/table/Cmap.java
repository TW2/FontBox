package org.wingate.fontbox.table;

import org.wingate.fontbox.type.UInt16;

public class Cmap {
    // SubTable PlatformID
    public enum PlatformID {
        Unicode(0, "Unicode"),
        Macintosh(1, "Macintosh"),
        ISO(2, "ISO"), // deprecated
        Windows(3, "Windows"),
        Custom(4, "Custom");

        final int value;
        final String platformIdName;

        PlatformID(int value, String platformIdName){
            this.value = value;
            this.platformIdName = platformIdName;
        }

        public int getValue() {
            return value;
        }

        public String getPlatformIdName() {
            return platformIdName;
        }

        public static PlatformID fromBytes(byte[] bytes){
            PlatformID platformID = PlatformID.Unicode;
            int value = UInt16.decode(bytes).getUint16();

            for(PlatformID pid : values()){
                if(pid.getValue() == value){
                    platformID = pid;
                    break;
                }
            }

            return platformID;
        }

        public static PlatformID fromName(String name){
            PlatformID platformID = PlatformID.Unicode;

            for(PlatformID pid : values()){
                if(pid.getPlatformIdName().equalsIgnoreCase(name)){
                    platformID = pid;
                    break;
                }
            }

            return platformID;
        }
    }

    public enum UnicodePlatformID {
        Unicode__1_0(0, "Unicode 1.0"), // deprecated
        Unicode__1_1(1, "Unicode 1.1"), // deprecated
        ISO_IEC_10646(2, "ISO/IEC 1064"), // deprecated
        Unicode__2_0_BMP(3, "Unicode 2.0 BMP"),
        Unicode__2_0_Full(4, "Unicode 2.0 full"),
        Unicode_variation_subTable_14(5, "Unicode/subtable format 14"),
        Unicode_full_subTable_13(6, "Unicode/subtable format 13");

        final int value;
        final String platformIdName;

        UnicodePlatformID(int value, String platformIdName){
            this.value = value;
            this.platformIdName = platformIdName;
        }

        public int getValue() {
            return value;
        }

        public String getPlatformIdName() {
            return platformIdName;
        }

        public static UnicodePlatformID fromBytes(byte[] bytes){
            UnicodePlatformID platformID = UnicodePlatformID.Unicode__2_0_Full;
            int value = UInt16.decode(bytes).getUint16();

            for(UnicodePlatformID pid : values()){
                if(pid.getValue() == value){
                    platformID = pid;
                    break;
                }
            }

            return platformID;
        }

        public static UnicodePlatformID fromName(String name){
            UnicodePlatformID platformID = UnicodePlatformID.Unicode__2_0_Full;

            for(UnicodePlatformID pid : values()){
                if(pid.getPlatformIdName().equalsIgnoreCase(name)){
                    platformID = pid;
                    break;
                }
            }

            return platformID;
        }
    }

    public enum WindowsPlatformID {
        Symbol(0, "Symbol"),
        UnicodeBMP(1, "Unicode BMP"),
        ShiftJIS(2, "ShiftJIS"),
        PRC(3, "PRC"),
        Big5(4, "Big5"),
        Wansung(5, "Wansung"),
        Johab(6, "Johab"),
        R1(7, "Reserved"),
        R2(8, "Reserved"),
        R3(9, "Reserved"),
        UnicodeFull(10, "Unicode full repertoire");

        final int encodingID;
        final String name;

        WindowsPlatformID(int encodingID, String name){
            this.encodingID = encodingID;
            this.name = name;
        }

        public int getEncodingID() {
            return encodingID;
        }

        public String getName() {
            return name;
        }
    }

    private UInt16 version;
    private UInt16 numTables;


}
