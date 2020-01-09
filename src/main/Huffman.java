package main;

public class Huffman {
    public static class HuffmanCode {
        private int code;
        private int numberOfBits;

        public HuffmanCode() {
            this.code = 0;
            this.numberOfBits = 0;
        }

        public HuffmanCode(int code, int numberOfBits) {
            this.code = code;
            this.numberOfBits = numberOfBits;
        }

        public String convertCode2BinaryString() {
            String result = "";
            result = String.format("%" + numberOfBits + "s", Integer.toBinaryString(code)).replace(' ', '0');
            return result;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getNumberOfBits() {
            return numberOfBits;
        }

        public void setNumberOfBits(int numberOfBits) {
            this.numberOfBits = numberOfBits;
        }
    }

    public static int[] DcLuminanceCodesPerBitsize = {0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
    public static int[] DcLuminanceValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    public static int[] AcLuminanceCodesPerBitsize = {0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125};
    public static int[] AcLuminanceValues = {0x01, 0x02, 0x03, 0x00, 0x04, 0x11, 0x05, 0x12, 0x21, 0x31, 0x41, 0x06, 0x13, 0x51, 0x61, 0x07, 0x22, 0x71, 0x14, 0x32, 0x81, 0x91, 0xA1, 0x08,
            0x23, 0x42, 0xB1, 0xC1, 0x15, 0x52, 0xD1, 0xF0, 0x24, 0x33, 0x62, 0x72, 0x82, 0x09, 0x0A, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x25, 0x26, 0x27, 0x28,
            0x29, 0x2A, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3A, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59,
            0x5A, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89,
            0x8A, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97, 0x98, 0x99, 0x9A, 0xA2, 0xA3, 0xA4, 0xA5, 0xA6, 0xA7, 0xA8, 0xA9, 0xAA, 0xB2, 0xB3, 0xB4, 0xB5, 0xB6,
            0xB7, 0xB8, 0xB9, 0xBA, 0xC2, 0xC3, 0xC4, 0xC5, 0xC6, 0xC7, 0xC8, 0xC9, 0xCA, 0xD2, 0xD3, 0xD4, 0xD5, 0xD6, 0xD7, 0xD8, 0xD9, 0xDA, 0xE1, 0xE2,
            0xE3, 0xE4, 0xE5, 0xE6, 0xE7, 0xE8, 0xE9, 0xEA, 0xF1, 0xF2, 0xF3, 0xF4, 0xF5, 0xF6, 0xF7, 0xF8, 0xF9, 0xFA};
    public static int[] DcChrominanceCodesPerBitsize = {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
    public static int[] DcChrominanceValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    public static int[] AcChrominanceCodesPerBitsize = {0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119};
    public static int[] AcChrominanceValues = {0x00, 0x01, 0x02, 0x03, 0x11, 0x04, 0x05, 0x21, 0x31, 0x06, 0x12, 0x41, 0x51, 0x07, 0x61, 0x71, 0x13, 0x22, 0x32, 0x81, 0x08, 0x14, 0x42, 0x91,
            0xA1, 0xB1, 0xC1, 0x09, 0x23, 0x33, 0x52, 0xF0, 0x15, 0x62, 0x72, 0xD1, 0x0A, 0x16, 0x24, 0x34, 0xE1, 0x25, 0xF1, 0x17, 0x18, 0x19, 0x1A, 0x26,
            0x27, 0x28, 0x29, 0x2A, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3A, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58,
            0x59, 0x5A, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87,
            0x88, 0x89, 0x8A, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97, 0x98, 0x99, 0x9A, 0xA2, 0xA3, 0xA4, 0xA5, 0xA6, 0xA7, 0xA8, 0xA9, 0xAA, 0xB2, 0xB3, 0xB4,
            0xB5, 0xB6, 0xB7, 0xB8, 0xB9, 0xBA, 0xC2, 0xC3, 0xC4, 0xC5, 0xC6, 0xC7, 0xC8, 0xC9, 0xCA, 0xD2, 0xD3, 0xD4, 0xD5, 0xD6, 0xD7, 0xD8, 0xD9, 0xDA,
            0xE2, 0xE3, 0xE4, 0xE5, 0xE6, 0xE7, 0xE8, 0xE9, 0xEA, 0xF2, 0xF3, 0xF4, 0xF5, 0xF6, 0xF7, 0xF8, 0xF9, 0xFA};

    public static HuffmanCode[] GenerateHuffmanTable(int[] numberOfCode, int[] codeValues) {
        HuffmanCode[] result = new HuffmanCode[255];
        for (int i = 0; i < result.length; i++) {
            result[i] = new HuffmanCode();
        }
        int huffmancode = 0;
        int indexCodeValues = 0;
        for (int numberOfBits = 1; numberOfBits <= 16; numberOfBits++) {
            for (int i = 0; i < numberOfCode[numberOfBits - 1]; i++) {
                result[codeValues[indexCodeValues]] = new HuffmanCode(huffmancode, numberOfBits);
                indexCodeValues++;
                huffmancode++;
            }
            huffmancode <<= 1;
        }
        return result;
    }

    public static HuffmanCode[] GenerateValueTable() {
        int maximumValue = 2048;
        HuffmanCode[] codeWords = new HuffmanCode[maximumValue];
        int numberOfBits = 1;
        int mask = 1;
        for (int value = 1; value < maximumValue; value++) {
            if (value > mask) {
                numberOfBits++;
                mask = (mask << 1) | 1;
            }
            codeWords[value] = new HuffmanCode(value, numberOfBits);
        }
        codeWords[0] = new HuffmanCode(0, 0);
        return codeWords;
    }

    public static String EncodeBlock(int[] arrafterzigzac, HuffmanCode[] huffmanDC, HuffmanCode[] huffmanAC,HuffmanCode[] codeWords) {
        String result = "";
        //sinh 4 bang huffman cho ky tu 1.
//        HuffmanCode[] huffmanLuminanceDC = GenerateHuffmanTable(DcLuminanceCodesPerBitsize, DcLuminanceValues);
//        HuffmanCode[] huffmanLuminanceAC = GenerateHuffmanTable(AcLuminanceCodesPerBitsize, AcLuminanceValues);
//        HuffmanCode[] huffmanChrominanceDC = GenerateHuffmanTable(DcChrominanceCodesPerBitsize, DcChrominanceValues);
//        HuffmanCode[] huffmanChrominanceAC = GenerateHuffmanTable(AcChrominanceCodesPerBitsize, AcChrominanceValues);

        //bang huffman cho ky tu 2.
//        HuffmanCode[] codeWords = GenerateValueTable();
        int dc = arrafterzigzac[0];
        String dcBits = EncodeDC(dc, huffmanDC, codeWords);
        result = result.concat(dcBits);
        String acBits = EncodeAC(arrafterzigzac, huffmanAC, codeWords);
        result = result.concat(acBits);
        return result;
    }

    public static String EncodeDC(int dc, HuffmanCode[] huffmanDC, HuffmanCode[] codeWords) {

        String result = "";
        int numberOfBits = codeWords[dc].numberOfBits;
        HuffmanCode kytu1 = huffmanDC[numberOfBits];
        HuffmanCode kytu2 = codeWords[dc];

        String bit1, bit2;
        if (dc > 0) {
            kytu2 = codeWords[dc];
        }

        if (dc < 0) {
            dc *= -1;
            int mask = 0;
            for (int i = 0; i < numberOfBits; i++) {
                mask = (mask << 1) | 1;
            }
            System.out.println(mask);
            kytu2.code = kytu2.code ^ (int) (Math.pow(2, numberOfBits) - 1);

        }

        bit1 = kytu1.convertCode2BinaryString();
        result = result.concat(bit1);
        if (dc != 0) {
            bit2 = kytu2.convertCode2BinaryString();
            result = result.concat(bit2);
        }
        result = result.replace(' ', '0');
        return result;
    }

    public static String EncodeAC(int[] ac, HuffmanCode[] huffmanAC, HuffmanCode[] codeWords) {
        // Tìm những vị trí có hệ số ac != 0
        int runlength = 0;
        int posNonZero = 0;
        String bit1, bit2, result = new String();
        HuffmanCode kytu1, kytu2;
        for (int i = 0; i < ac.length; i++) {
            if (ac[i] != 0) {
                posNonZero = i;
            }
        }
        for (int i = 1; i <= posNonZero; i++) {
            while (ac[i] == 0) {
                runlength++;
                if (runlength > 15) {
                    int index = 240;
                    kytu1 = huffmanAC[index];
                    bit1 = kytu1.convertCode2BinaryString();
                    result = result.concat(bit1);
                    runlength = 0;
                }
                i++;
            }
            kytu2 = codeWords[ac[i]];
            bit2 = kytu2.convertCode2BinaryString();
            int size = kytu2.numberOfBits;
            int index = (runlength << 4) + size;
            kytu1 = huffmanAC[index];
            bit1 = kytu1.convertCode2BinaryString();
            result = result.concat(bit1);
            result = result.concat(bit2);
            runlength = 0;
        }
        if (posNonZero < 63) {
            kytu1 = huffmanAC[0];
            bit1 = kytu1.convertCode2BinaryString();
            result = result.concat(bit1);
        }
        result = result.replace(' ', '0');
        return result;
    }

}
