package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Jugador implements Serializable {
    
    private static final long SERIAL_VERSION_UID = 1L;
    
    private static final int POKEMONES_MAX = 6;
    private String nombreJugador;
    private int pokemonesActuales;
    private Posicion posicion;
    private Pokemon[] equipoPokemon;
    
    public Jugador(String nombreJugador, Posicion posicion, Pokemon pokemonInicial) {
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.equipoPokemon = new Pokemon[POKEMONES_MAX];
        this.equipoPokemon[0] = pokemonInicial;
        this.pokemonesActuales = 1;
    }
    
    public void agregarPokemon(Pokemon pokemon) {
        if (pokemonesActuales < POKEMONES_MAX) {
            equipoPokemon[pokemonesActuales] = pokemon;
            pokemonesActuales = pokemonesActuales + 1;
        }
    }
    
    public static int getPOKEMONES_MAX() {
        return POKEMONES_MAX;
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

    public Pokemon[] getEquipoPokemon() {
        return equipoPokemon;
    }
}