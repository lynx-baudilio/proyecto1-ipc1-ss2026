package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Mochila implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pokebolas;
    private int pociones;
    private int superPociones;
    private int antidotos;
    private int antiparaliz;
    private int restauraTodo;

    public Mochila() {
        this.pokebolas = 5;
        this.pociones = 1;
        this.superPociones = 0;
        this.antidotos = 0;
        this.antiparaliz = 0;
        this.restauraTodo = 0;
    }

    public int getPokebolas() {
        return pokebolas;
    }

    public void agregarPokebolas(int cantidad) {
        pokebolas = pokebolas + cantidad;
    }

    public boolean usarPokebola() {
        if (pokebolas > 0) {
            pokebolas = pokebolas - 1;
            return true;
        }
        return false;
    }

    public int getPociones() {
        return pociones;
    }

    public void agregarPociones(int cantidad) {
        pociones = pociones + cantidad;
    }

    public boolean usarPocion() {
        if (pociones > 0) {
            pociones = pociones - 1;
            return true;
        }
        return false;
    }

    public int getSuperPociones() {
        return superPociones;
    }

    public void agregarSuperPociones(int cantidad) {
        superPociones = superPociones + cantidad;
    }

    public boolean usarSuperPocion() {
        if (superPociones > 0) {
            superPociones = superPociones - 1;
            return true;
        }
        return false;
    }

    public int getAntidotos() {
        return antidotos;
    }

    public void agregarAntidotos(int cantidad) {
        antidotos = antidotos + cantidad;
    }

    public boolean usarAntidoto() {
        if (antidotos > 0) {
            antidotos = antidotos - 1;
            return true;
        }
        return false;
    }

    public int getAntiparaliz() {
        return antiparaliz;
    }

    public void agregarAntiparaliz(int cantidad) {
        antiparaliz = antiparaliz + cantidad;
    }

    public boolean usarAntiparaliz() {
        if (antiparaliz > 0) {
            antiparaliz = antiparaliz - 1;
            return true;
        }
        return false;
    }

    public int getRestauraTodo() {
        return restauraTodo;
    }

    public void agregarRestauraTodo(int cantidad) {
        restauraTodo = restauraTodo + cantidad;
    }

    public boolean usarRestauraTodo() {
        if (restauraTodo > 0) {
            restauraTodo = restauraTodo - 1;
            return true;
        }
        return false;
    }

    public void listar() {
        System.out.println("  Pokébolas: " + pokebolas);
        System.out.println("  Pociones: " + pociones);
        System.out.println("  Superpociones: " + superPociones);
        System.out.println("  Antídotos: " + antidotos);
        System.out.println("  Antiparaliz: " + antiparaliz);
        System.out.println("  Restaura todo: " + restauraTodo);
    }
}