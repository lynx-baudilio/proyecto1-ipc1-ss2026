package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private static final long SERIAL_VERSION_UID = 1L;
    
    private String especie;
    private String apodo;
    private int id;
    private int nivel;
    private int vidaActual;
    private int vidaMax;
    //private MovimientoPokemon[] movimientos;

    public Pokemon(String especie, String apodo, int id, int nivel, int vidaActual, int vidaMax) {
        this.especie = especie;
        this.apodo = apodo;
        this.id = id;
        this.nivel = nivel;
        this.vidaActual = vidaActual;
        this.vidaMax = vidaMax;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEspecie() {
        return especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
    
    
}
