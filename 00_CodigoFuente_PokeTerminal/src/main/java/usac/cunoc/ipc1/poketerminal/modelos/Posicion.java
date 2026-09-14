package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Posicion implements Serializable {
    
    private int fila;
    private int columna;
    
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}