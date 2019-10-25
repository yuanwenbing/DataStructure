package com.yuan.inter.string;

public class StringTest {

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
//        System.out.println(stringTest.getStringMaxLength());
        stringTest.equalStr();

    }

    private int getStringMaxLength() {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < 2 << 24; i++) {
            sb.append("a");
        }
        String str = sb.toString();
        return str.length();
    }

    private void equalStr() {

        String b = "abc";
        String c = "abc";

        String a = new String("abc");
        String d = a.intern();

        System.out.println( a== b);
    }
}
