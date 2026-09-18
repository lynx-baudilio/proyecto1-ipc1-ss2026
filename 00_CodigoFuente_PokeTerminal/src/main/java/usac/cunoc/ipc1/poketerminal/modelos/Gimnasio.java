package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Gimnasio implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private EntrenadorNPC lider;
    private EntrenadorNPC[] entrenadores;
    private Medalla medalla;

    public Gimnasio(String nombre, EntrenadorNPC lider, EntrenadorNPC[] entrenadores, Medalla medalla) {
        this.nombre = nombre;
        this.lider = lider;
        this.entrenadores = entrenadores;
        this.medalla = medalla;
    }

    public EntrenadorNPC buscarEntrenadorPorIndice(int indice) {
        if (indice < 0 || indice >= entrenadores.length) {
            return null;
        }
        return entrenadores[indice];
    }

    public String getNombre() {
        return nombre;
    }

    public EntrenadorNPC getLider() {
        return lider;
    }

    public EntrenadorNPC[] getEntrenadores() {
        return entrenadores;
    }

    public Medalla getMedalla() {
        return medalla;
    }
}