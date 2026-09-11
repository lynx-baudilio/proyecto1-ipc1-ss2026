package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Jugador implements Serializable {
    
    private static final int POKEMONES_MAX = 6;
    private String nombreJugador;
    private int pokemonesActuales;
    private Posicion posicion;
    
    public Jugador(String nombreJugador, Posicion posicion) {
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.pokemonesActuales = 1;
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPokemonesActuales() {
        return pokemonesActuales;
    }

    public void setPokemonesActuales(int pokemonesActuales) {
        this.pokemonesActuales = pokemonesActuales;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public static int getPOKEMONES_MAX() {
        return POKEMONES_MAX;
    }
    
}
