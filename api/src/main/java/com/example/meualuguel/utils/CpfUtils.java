package com.example.meualuguel.utils;

public class CpfUtils {
    public static String formatCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i);
            }

            int firstCheckDigit = 11 - (sum % 11);
            if (firstCheckDigit >= 10) firstCheckDigit = 0;
            if (firstCheckDigit != cpf.charAt(9) - '0') return false;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }

            int secondCheckDigit = 11 - (sum % 11);
            if (secondCheckDigit >= 10) secondCheckDigit = 0;
            return secondCheckDigit == (cpf.charAt(10) - '0');

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
