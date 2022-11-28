package com.gp.ejerciciotorneo.util;

public class NumeroUtils {
    /**
     * devuelve si un numero es potencia de 2
     * @param numero parametro a comprobar
     * @return true si es potencia
     */
    public static boolean esPotenciaDeDos(int numero){

        return (numero & (numero - 1)) == 0;

    }
}
