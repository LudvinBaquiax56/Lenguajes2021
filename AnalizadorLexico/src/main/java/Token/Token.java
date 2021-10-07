/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Token;

/**
 *
 * @author baquiax
 */
public class Token {

    private String token;
    private TipoToken tipoToken;
    private int fila;
    private int columna;
    private String ruta;
    private int cantidad;
    private int cantidadToken;

    public Token() {
        this.token = "";
        this.tipoToken = null;
    }

    /**
     *
     * @param token
     * @param tipoToken
     * @param fila
     * @param columna
     */
    public Token(String token, TipoToken tipoToken, int fila, int columna, String ruta) {
        this.token = token;
        this.tipoToken = tipoToken;
        this.fila = fila;
        this.columna = columna;
        this.ruta = ruta;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the tipoToken
     */
    public TipoToken getTipoToken() {
        return tipoToken;
    }

    /**
     * @param tipoToken the tipoToken to set
     */
    public void setTipoToken(TipoToken tipoToken) {
        this.tipoToken = tipoToken;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the cantidadToken
     */
    public int getCantidadToken() {
        return cantidadToken;
    }

    /**
     * @param cantidadToken the cantidadToken to set
     */
    public void setCantidadToken(int cantidadToken) {
        this.cantidadToken = cantidadToken;
    }

}
