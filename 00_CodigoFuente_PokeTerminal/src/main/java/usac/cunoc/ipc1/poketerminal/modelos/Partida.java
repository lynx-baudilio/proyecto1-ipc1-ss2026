package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;
import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;

public class Partida implements Serializable {
    
    private static final long SERIAL_VERSION_UID = 1L;
    
    private String nombrePartida;
    private Jugador jugador;
    private MapaCiudad[] ciudades = new MapaCiudad[3];
    private int ciudadActual;
    
    public Partida(String nombrePartida, Jugador jugador) {
        this.nombrePartida = nombrePartida;
        this.jugador = jugador;
        this.ciudadActual = 0;
        
        this.ciudades[0] = new MapaCiudad("1");
        this.ciudades[1] = new MapaCiudad("2");
        this.ciudades[2] = new MapaCiudad("3");
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public MapaCiudad getCiudadActual() {
        return ciudades[ciudadActual];
    }

    public void setCiudades(MapaCiudad[] ciudades) {
        this.ciudades = ciudades;
    }
}