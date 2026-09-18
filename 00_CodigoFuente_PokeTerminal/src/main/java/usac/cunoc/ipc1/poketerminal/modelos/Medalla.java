package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class Medalla implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String icono;
    private String ciudad;

    public Medalla(String nombre, String icono, String ciudad) {
        this.nombre = nombre;
        this.icono = icono;
        this.ciudad = ciudad;
    }

    public String textoPerfil() {
        return icono + " " + nombre + " (" + ciudad + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public String getIcono() {
        return icono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}