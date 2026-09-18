package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numero;
    private String nombre;
    private int baseSalud;
    private int baseAtaque;
    private int baseDefensa;
    private int baseVelocidad;
    private String[] nombresMovimientos;

    public Especie(int numero, String nombre, int baseSalud, int baseAtaque,
            int baseDefensa, int baseVelocidad, String[] nombresMovimientos) {
        this.numero = numero;
        this.nombre = nombre;
        this.baseSalud = baseSalud;
        this.baseAtaque = baseAtaque;
        this.baseDefensa = baseDefensa;
        this.baseVelocidad = baseVelocidad;
        this.nombresMovimientos = nombresMovimientos;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBaseSalud() {
        return baseSalud;
    }

    public int getBaseAtaque() {
        return baseAtaque;
    }

    public int getBaseDefensa() {
        return baseDefensa;
    }

    public int getBaseVelocidad() {
        return baseVelocidad;
    }

    public String[] getNombresMovimientos() {
        return nombresMovimientos;
    }
}