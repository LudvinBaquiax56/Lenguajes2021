/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Token.TipoToken;
import Token.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class AnalizadorLexico {

    private List<Token> tokensValidos;
    private List<Token> tokensDeError;
    private Automata automata;
    private int fila;
    private int columna;
    private int posicion = 0;

    public AnalizadorLexico() {
        this.tokensValidos = new ArrayList<>();
        this.tokensDeError = new ArrayList<>();
        this.automata = new Automata();
    }

    public void analizar(String textoComple) {
        fila = 1;
        columna = 1;
        while (posicion < textoComple.length()) {
            int estadoActual = 0;
            String stringToken = "";
            char temporal = textoComple.charAt(posicion);
            boolean continuar = true;
            String ruta = "";
            if (validarSaltoLinea(temporal)) {
                columna = 1;
                fila++;
            }
            while (posicion < textoComple.length() && (continuar)) {
                if ((validarEspacio(textoComple.charAt(posicion)))
                        || (validarSaltoLinea(textoComple.charAt(posicion)))
                        || (estadoActual == -1)) {
                    continuar = false;
                } else {
                    ruta = ruta + "Me movi del estado " + estadoActual;
                    temporal = textoComple.charAt(posicion);
                    stringToken += textoComple.charAt(posicion);

                    estadoActual = automata.estado(estadoActual, temporal);
                    ruta = ruta + " con el caracter " + temporal + " al estado " + estadoActual + "\n";
                }
                columna++;
                posicion++;
            }
            int columnaToken = columna - stringToken.length() - 1;
            if (estadoActual == Automata.NUMERO) {
                getTokensValidos().add(new Token(stringToken, TipoToken.NUMERO, fila, columnaToken, ruta));
            } else if (estadoActual == Automata.DECIMAL) {
                //int columnaToken = columna - stringToken.length();
                getTokensValidos().add(new Token(stringToken, TipoToken.DECIMAL, fila, columnaToken, ruta));
            } else if (stringToken.length() == 1 && (temporal == '.'
                    || temporal == ',' || temporal == ';' || temporal == ':')) {
                //int columnaToken = columna - stringToken.length();
                getTokensValidos().add(new Token(stringToken, TipoToken.PUNTUACION, fila, columnaToken, ruta));
            } else if (stringToken.length() == 1 && (temporal == '('
                    || temporal == ')' || temporal == '{'
                    || temporal == '}' || temporal == '[' || temporal == ']')) {
                //int columnaToken = columna - stringToken.length();
                getTokensValidos().add(new Token(stringToken, TipoToken.AGRUPACION, fila, columnaToken, ruta));
            } else if (stringToken.length() == 1 && (temporal == '+'
                    || temporal == '-' || temporal == '*'
                    || temporal == '/' || temporal == '%')) {
                //int columnaToken = columna - stringToken.length();
                getTokensValidos().add(new Token(stringToken, TipoToken.ARITMETICO, fila, columnaToken, ruta));
            } else if (estadoActual == Automata.IDENTIFICADOR) {
                //int columnaToken = columna - stringToken.length();
                getTokensValidos().add(new Token(stringToken, TipoToken.IDENTIFICADOR, fila, columnaToken, ruta));
            } else {
                //int columnaToken = columna - stringToken.length();
                if (!(validarEspacio(temporal) || validarSaltoLinea(temporal))) {
                    getTokensDeError().add(new Token(stringToken, TipoToken.ERROR, fila, columnaToken, ruta));
                }
            }
            System.out.println("token actual " + stringToken);
        }
        resumen();
    }

    /**
     * Valida si el siguiente caracter es un Salto de Linea
     *
     * @param caracter
     * @return
     */
    public boolean validarSaltoLinea(char caracter) {
        int valorCaracter = (int) caracter;
        return valorCaracter == 10;
    }

    /**
     * Valida si el siguiente caracter es un Espacio
     *
     * @param caracter
     * @return
     */
    public boolean validarEspacio(char caracter) {
        int valorCaracter = (int) caracter;
        return valorCaracter == 32;
    }

    private void resumen() {
        System.out.println("resumen");
        System.out.println("----------------------------------------------------");
        for (Token tokensValido : this.getTokensValidos()) {
            System.out.print(tokensValido.getToken() + " -- " + "F: " + tokensValido.getFila() + " C: " + tokensValido.getColumna());
            System.out.print(tokensValido.getTipoToken());
            System.out.print("**" + tokensValido.getRuta());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("Erores");
        for (Token token : this.getTokensDeError()) {
            System.out.print(token.getToken() + " -- " + "F: " + token.getFila() + " C: " + token.getColumna());
            System.out.println(token.getTipoToken());
        }
    }

    /**
     * @return the tokensValidos
     */
    public List<Token> getTokensValidos() {
        return tokensValidos;
    }

    /**
     * @return the tokensDeError
     */
    public List<Token> getTokensDeError() {
        return tokensDeError;
    }

}
