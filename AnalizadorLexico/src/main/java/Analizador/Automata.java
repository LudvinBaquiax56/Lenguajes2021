/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

/**
 *
 * @author baquiax
 */
public class Automata {

    int[][] matrizDeTrancisiones = {
        //       L,  D,  .,  ,,  ;,  :,  (,  ),  {,  },  [,  ],  +,  -,  *,  /,  %
        //       0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16
        /*S0*/{1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
        /*S1*/ {1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        /*S2*/ {-1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        /*S3*/ {-1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        /*S4*/ {-1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        /*S5*/ {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
    public static final int IDENTIFICADOR = 1;
    public static final int NUMERO = 2;
    public static final int DECIMAL = 4;
    int[] estadosDeAceptacion = {IDENTIFICADOR, NUMERO, DECIMAL, 5};

    public Automata() {
    }

    /**
     * Retorna el estado en base a un estado y un caracter
     *
     * @param estado
     * @param caracter
     * @return
     */
    public int estado(int estado, char caracter) {
        try {
            int valorCaracter = valorCaracter(caracter);
            return matrizDeTrancisiones[estado][valorCaracter];
        } catch (Exception e) {
            return - 1;
        }
    }

    /**
     * Retorna el valor del caracter en nuestro alfabeto
     *
     * @param caracter
     * @return
     */
    public int valorCaracter(char caracter) {
        if (Character.isLetter(caracter)) {
            return 0;
        } else if (Character.isDigit(caracter)) {
            return 1;
        } else if (caracter == '.') {
            return 2;
        } else if (caracter == ',') {
            return 3;
        } else if (caracter == ';') {
            return 4;
        } else if (caracter == ':') {
            return 5;
        } else if (caracter == '(') {
            return 6;
        } else if (caracter == ')') {
            return 7;
        } else if (caracter == '{') {
            return 8;
        } else if (caracter == '}') {
            return 9;
        } else if (caracter == '[') {
            return 10;
        } else if (caracter == ']') {
            return 11;
        } else if (caracter == '+') {
            return 12;
        } else if (caracter == '-') {
            return 13;
        } else if (caracter == '*') {
            return 14;
        } else if (caracter == '/') {
            return 15;
        } else if (caracter == '%') {
            return 16;
        } else {
            return -1;
        }
    }

    /**
     * Retorna verdadero si el estado esta en un estado de aceptacion de lo
     * contrario retorna falso
     *
     * @param estado
     * @return
     */
    public boolean validarEstado(int estado) {
        for (int i = 0; i < estadosDeAceptacion.length; i++) {
            if (estadosDeAceptacion[i] == estado) {
                return true;
            }
        }
        return false;
    }

}
