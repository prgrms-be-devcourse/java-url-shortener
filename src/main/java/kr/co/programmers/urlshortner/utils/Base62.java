package kr.co.programmers.urlshortner.utils;

import org.springframework.stereotype.Component;

public class Base62 {

    // 인코딩 결과를 조금 더 길게 만들기 위해 사용되는 의미 없는 값
    private static final int PADDING = 100_000;
    static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static String encode(long value) {
        value *= PADDING;
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        return sb.toString();
    }

    public static long decode(String value) {
        int result = 0;
        int power = 1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result / PADDING;
    }
}
