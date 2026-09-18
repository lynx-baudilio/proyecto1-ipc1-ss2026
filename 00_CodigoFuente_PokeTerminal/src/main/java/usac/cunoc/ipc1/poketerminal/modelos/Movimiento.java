package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private int potencia;
    private String tipo;
    private String efecto;

    public Movimiento(String nombre, int potencia, String tipo, String efecto) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
        this.efecto = efecto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEfecto() {
        return efecto;
    }

    public boolean esFisico() {
        return "FISICO".equals(tipo);
    }

    public boolean esDeEstado() {
        return "ESTADO".equals(tipo);
    }
}