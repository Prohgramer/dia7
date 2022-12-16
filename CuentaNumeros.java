package com.roshka.bootcamp;

import java.util.*;
public class CuentaNumeros {

    public static void main(String [] args) {
        CuentaNumeros.findAll(10, 3);
    }
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        final int digito_max = 9;
        final int digito_min = 1;

        int numero_max = digito_max;
        int numero_min = 1;

        long cant = 0L, min = 0L, max = 0L;


        if (sumDigits < 1 || numDigits < 1) {
            return new ArrayList<>(0);
        }

        for(int i = 1; i < numDigits; i++) {
            numero_max *= 10;
            numero_max += digito_max;

            numero_min *= 10;
            numero_min += digito_min;
        }

        for(long num = numero_min; num <= numero_max; num++) {
            if(esCreciente(num, numDigits) && esIgual(num, sumDigits, numDigits)) {
                if(cant == 0) {
                    min = num;
                    max = num;
                } else if(num > max) {
                    max = num;
                } else if(num < min) {
                    min = num;
                }

                cant++;
            }
        }
          if(cant == 0) {
            return new ArrayList<>(0);
        }
        return Arrays.asList(cant, min, max);
    }
    private static boolean esIgual(long number, long sum, int numDigits) {
        long sumAux = 0;
        String numberText = String.valueOf(number);

        for(int i = 0; i < numDigits; i++) {
            sumAux += Integer.parseInt(numberText.charAt(i) + "");
        }
        return sum == sumAux;
    }
    private static boolean esCreciente(long num, int numDigits) {

        String numberText = String.valueOf(num);
        int digit = Integer.parseInt(numberText.charAt(0) + "");
        for(int i = 1; i < numDigits; i++) {
            int aux = Integer.parseInt(numberText.charAt(i) + "");
            if(aux < digit) {
                return false;
            }
            digit = aux;
        }
        return true;
    }
}