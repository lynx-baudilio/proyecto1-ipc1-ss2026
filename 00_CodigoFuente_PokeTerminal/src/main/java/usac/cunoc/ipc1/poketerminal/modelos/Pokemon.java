package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private static final long SERIAL_VERSION_UID = 1L;
    
    private int id;
    private String especie;
    private String apodo;
    private int nivel;
    private int exp;
    private int vidaActual;
    private int vidaMax;
    private int puntosAtaque;
    private int puntosDefensa;
    private int puntosVelocidad;
    private Movimiento[] movimientos;

    public Pokemon(int id, String especie, String apodo, int nivel, int exp, int vidaActual, int vidaMax, int puntosAtaque, int puntosDefensa, int puntosVelocidad, Movimiento[] movimientos) {
        this.id = id;
        this.especie = especie;
        this.apodo = apodo;
        this.nivel = nivel;
        this.exp = exp;
        this.vidaActual = vidaActual;
        this.vidaMax = vidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.puntosVelocidad = puntosVelocidad;
        this.movimientos = movimientos;
    }

    public static long getSERIAL_VERSION_UID() {
        return SERIAL_VERSION_UID;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExp() {
        return exp;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public int getPuntosVelocidad() {
        return puntosVelocidad;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }
}