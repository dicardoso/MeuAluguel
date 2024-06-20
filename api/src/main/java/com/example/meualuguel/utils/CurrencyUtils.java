package com.example.meualuguel.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {

    private static final String[] UNITS = {
            "", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
            "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"
    };

    private static final String[] TENS = {
            "", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"
    };

    private static final String[] HUNDREDS = {
            "", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"
    };

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 0) {
            return "menos " + convert(-number);
        }

        String words = "";

        if ((number / 1000000) > 0) {
            words += convert(number / 1000000) + " milhão ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += convert(number / 1000) + " mil ";
            number %= 1000;
            if (number > 0 && number < 100) {
                words += "e ";
            }
        }

        if ((number / 100) > 0) {
            words += HUNDREDS[number / 100] + " ";
            number %= 100;
            if (number > 0) {
                words += "e ";
            }
        }

        if (number > 0) {
            if (number < 20) {
                words += UNITS[number];
            } else {
                words += TENS[number / 10];
                if ((number % 10) > 0) {
                    words += " e " + UNITS[number % 10];
                }
            }
        }

        return words.trim();
    }

    public static String convertDoubleToWords(double number) {
        int integerPart = (int) number;
        int decimalPart = (int) Math.round((number - integerPart) * 100);

        String integerPartWords = convert(integerPart);

        if (decimalPart == 0) {
            return integerPartWords + " reais";
        }

        String decimalPartWords = convert(decimalPart);

        return integerPartWords + " reais e " + decimalPartWords + " centavos";
    }

    public static String formatCurrency(double value) {
        Locale br = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(br).format(value);
    }
}
