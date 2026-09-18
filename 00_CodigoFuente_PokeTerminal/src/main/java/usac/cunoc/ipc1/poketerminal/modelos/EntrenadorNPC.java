package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class EntrenadorNPC implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private boolean lider;
    private boolean derrotado;
    private Pokemon[] equipo;

    public EntrenadorNPC(String nombre, boolean lider) {
        this.nombre = nombre;
        this.lider = lider;
        this.derrotado = false;
        this.equipo = null;
    }

    public boolean equipoYaGenerado() {
        return equipo != null;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esLider() {
        return lider;
    }

    public boolean estaDerrotado() {
        return derrotado;
    }

    public void setDerrotado(boolean derrotado) {
        this.derrotado = derrotado;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }
}