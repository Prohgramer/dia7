package com.roshka.bootcamp;
import java.util.*;
import java.util.stream.Stream;

public class SmallerNumberSameDigits {
    public static ArrayList<String> lista_permutado=new ArrayList();
    public static void permutacion(String str)
    {
        // caso base
        // crea una ArrayList vacía para almacenar permutaciones
        // List<String> partial = new ArrayList<>();  no usamos este pq lo creamos en la misma clase para usar en cualquier lado de la clase.
        // inicializamos la lista con el primer caracter del string
        lista_permutado.add(String.valueOf(str.charAt(0)));
        // hacer para cada caracter de la string especificada
        for (int i = 1; i < str.length(); i++)
        {
            // considera permutaciones parciales previamente construidas una por una
            // (iterar hacia atrás para evitar ConcurrentModificationException)
            for (int j = lista_permutado.size() - 1; j >= 0 ; j--)
            {
                // elimina la permutación parcial actual de ArrayList
                String s = lista_permutado.remove(j);
                // Inserta el siguiente carácter de la string especificada en absoluto
                // posiciones posibles de la permutación parcial actual. Después
                // inserta cada una de estas strings recién construidas en la lista
                for (int k = 0; k <= s.length(); k++)
                {
                    // Consejo: use StringBuilder para la concatenación
                    lista_permutado.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                }
            }
        }
    }
    public static long nextSmaller(long n)
    {
        long ultimo_min;  //es el que nos va a decir nuestro ultimo numero pequenho.
        String str=Long.toString(n),str_ordenado;  //str el long.
        permutacion(str);  //permutaciones de los numeros(por si te olvidas ejemplo de 123.  132-213-231-312-321)
        char[] char_array=str.toCharArray();  //convertimos a array de char el numero que nos pasa como parametro para:
        Arrays.sort(char_array);  //poder ordenar y empezemos de ahi a comparar osea para usar como el numero mas chico.
        str_ordenado=String.valueOf(char_array);  //del char ordenado a string.
        ultimo_min=Long.parseLong(str_ordenado);
        for (int j = 0; j < lista_permutado.size(); j++) {
            if (n > Long.parseLong(lista_permutado.get(j)) && Long.parseLong(lista_permutado.get(j)) > ultimo_min) {  //aqui usamos el numero mas chico para ayudarnos a comparar
                ultimo_min = Long.parseLong(lista_permutado.get(j));
            }
        }
        if( str.length()==String.valueOf(ultimo_min).length() ) {return ultimo_min;} //comparamos que no haya un 0 delante
        return -1;
    }
    public static void main(String [] s){
        System.out.println(SmallerNumberSameDigits.nextSmaller(441));
        System.out.println(SmallerNumberSameDigits.nextSmaller(552));
        //System.out.println(SmallerNumberSameDigits.nextSmaller(123456798));
        System.out.println(SmallerNumberSameDigits.nextSmaller(21));
        System.out.println(SmallerNumberSameDigits.nextSmaller(211));
    }
}
