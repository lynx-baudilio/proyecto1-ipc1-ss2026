package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int CANTIDAD_MAXIMA_POKEMONES = 6;

    private String nombreJugador;
    private String simbolo;
    private int pokemonesActuales;
    private Posicion posicion;
    private Pokemon[] equipoPokemon;
    private int pokemonedas;
    private Mochila mochila;
    private Medalla[] medallas;
    private int medallasObtenidas;

    public Jugador(String nombreJugador, Posicion posicion, Pokemon pokemonInicial) {
        this.nombreJugador = nombreJugador;
        this.simbolo = Ansi.NEGRITA + Ansi.AMARILLO + "@" + Ansi.RESET;
        this.posicion = posicion;
        this.equipoPokemon = new Pokemon[CANTIDAD_MAXIMA_POKEMONES];
        this.equipoPokemon[0] = pokemonInicial;
        this.pokemonesActuales = 1;
        this.pokemonedas = 1000;
        this.mochila = new Mochila();
        this.medallas = new Medalla[3];
        this.medallasObtenidas = 0;
    }

    public boolean agregarPokemon(Pokemon pokemon) {
        if (pokemonesActuales < CANTIDAD_MAXIMA_POKEMONES) {
            equipoPokemon[pokemonesActuales] = pokemon;
            pokemonesActuales = pokemonesActuales + 1;
            return true;
        }
        return false;
    }

    public boolean equipoLleno() {
        return pokemonesActuales >= CANTIDAD_MAXIMA_POKEMONES;
    }

    public boolean liberarPokemon(int indice) {
        if (pokemonesActuales <= 1) {
            return false;
        }
        if (indice < 0 || indice >= pokemonesActuales) {
            return false;
        }
        for (int posicionActual = indice; posicionActual < pokemonesActuales - 1; posicionActual++) {
            equipoPokemon[posicionActual] = equipoPokemon[posicionActual + 1];
        }
        equipoPokemon[pokemonesActuales - 1] = null;
        pokemonesActuales = pokemonesActuales - 1;
        return true;
    }

    public boolean intercambiar(int indiceOrigen, int indiceDestino) {
        if (indiceOrigen < 0 || indiceDestino < 0
                || indiceOrigen >= pokemonesActuales || indiceDestino >= pokemonesActuales) {
            return false;
        }
        Pokemon pokemonTemporal = equipoPokemon[indiceOrigen];
        equipoPokemon[indiceOrigen] = equipoPokemon[indiceDestino];
        equipoPokemon[indiceDestino] = pokemonTemporal;
        return true;
    }

    public void agregarMedalla(Medalla medalla) {
        if (medallasObtenidas < 3) {
            medallas[medallasObtenidas] = medalla;
            medallasObtenidas = medallasObtenidas + 1;
        }
    }

    public boolean tieneTresMedallas() {
        return medallasObtenidas >= 3;
    }

    public boolean yaTieneMedalla(String nombreMedalla) {
        for (int indice = 0; indice < medallasObtenidas; indice++) {
            if (medallas[indice].getNombre().equals(nombreMedalla)) {
                return true;
            }
        }
        return false;
    }

    public Pokemon primerPokemonVivo() {
        for (int indice = 0; indice < pokemonesActuales; indice++) {
            if (equipoPokemon[indice] != null && !equipoPokemon[indice].estaDebilitado()) {
                return equipoPokemon[indice];
            }
        }
        return null;
    }

    public boolean tienePokemonVivo() {
        return primerPokemonVivo() != null;
    }

    public void curarEquipo() {
        for (int indice = 0; indice < pokemonesActuales; indice++) {
            if (equipoPokemon[indice] != null) {
                equipoPokemon[indice].restaurarCompleto();
            }
        }
    }

    public int sumaNiveles() {
        int sumaTotalNiveles = 0;
        for (int indice = 0; indice < pokemonesActuales; indice++) {
            if (equipoPokemon[indice] != null) {
                sumaTotalNiveles = sumaTotalNiveles + equipoPokemon[indice].getNivel();
            }
        }
        return sumaTotalNiveles;
    }

    public Pokemon obtenerMvp() {
        Pokemon pokemonMvp = equipoPokemon[0];
        for (int indice = 1; indice < pokemonesActuales; indice++) {
            if (equipoPokemon[indice] != null
                    && equipoPokemon[indice].getEnemigosDebilitados() > pokemonMvp.getEnemigosDebilitados()) {
                pokemonMvp = equipoPokemon[indice];
            }
        }
        return pokemonMvp;
    }

    public void pagarMitadDinero() {
        pokemonedas = pokemonedas / 2;
    }

    public void agregarDinero(int cantidad) {
        pokemonedas = pokemonedas + cantidad;
        if (pokemonedas < 0) {
            pokemonedas = 0;
        }
    }

    public boolean gastar(int precio) {
        if (pokemonedas < precio) {
            return false;
        }
        pokemonedas = pokemonedas - precio;
        return true;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getPokemonesActuales() {
        return pokemonesActuales;
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

    public int getPokemonedas() {
        return pokemonedas;
    }

    public void setPokemonedas(int pokemonedas) {
        this.pokemonedas = pokemonedas;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public Medalla[] getMedallas() {
        return medallas;
    }

    public int getMedallasObtenidas() {
        return medallasObtenidas;
    }
}