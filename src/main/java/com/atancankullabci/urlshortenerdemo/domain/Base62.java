package com.atancankullabci.urlshortenerdemo.domain;

/**
 * Converts a non-negative number to a short Base62 string and back.
 * Alphabet: 0-9 (0..9), a-z (10..35), A-Z (36..61).
 */
public final class Base62 {

    private static final String ALPHABET =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length(); // 62

    private Base62() {
    }

    public static String encode(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must be non-negative: " + number);
        }
        if (number == 0) {
            return String.valueOf(ALPHABET.charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % BASE);
            sb.append(ALPHABET.charAt(remainder));
            number /= BASE;
        }
        // remainders come out least-significant first
        return sb.reverse().toString();
    }

    public static long decode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("code must not be empty");
        }
        long result = 0;
        for (char c : code.toCharArray()) {
            int value = ALPHABET.indexOf(c);
            if (value < 0) {
                throw new IllegalArgumentException("invalid Base62 character: " + c);
            }
            result = Math.addExact(Math.multiplyExact(result, BASE), value);
        }
        return result;
    }
}
