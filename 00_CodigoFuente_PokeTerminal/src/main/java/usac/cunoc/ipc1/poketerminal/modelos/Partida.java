package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;
import java.util.Random;
import usac.cunoc.ipc1.poketerminal.catalogos.CatalogoCiudades;
import usac.cunoc.ipc1.poketerminal.catalogos.CatalogoNPCs;
import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;

public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombrePartida;
    private Jugador jugador;
    private MapaCiudad[] ciudades;
    private int ciudadActual;
    private int siguienteIdPokemon;
    private EstadisticasPartida estadisticas;
    private boolean hallRegistrado;

    public Partida(String nombrePartida, Jugador jugador) {
        this.nombrePartida = nombrePartida;
        this.jugador = jugador;
        this.ciudades = new MapaCiudad[3];
        this.siguienteIdPokemon = 1;
        this.estadisticas = new EstadisticasPartida();
        this.hallRegistrado = false;
        generarMundo();
    }

    private void generarMundo() {
        Random generadorAleatorio = new Random();
        CatalogoCiudades catalogoCiudades = new CatalogoCiudades();
        CatalogoNPCs catalogoNPCs = new CatalogoNPCs();

        String[] nombresCiudades = catalogoCiudades.obtenerNombresAleatorios();
        String[] nombresGimnasios = catalogoNPCs.obtenerGimnasiosUnicos(3);
        String[] nombresLideres = catalogoNPCs.obtenerLideresUnicos(3);
        String[] nombresEntrenadores = catalogoNPCs.obtenerEntrenadoresUnicos(9);
        Medalla[] medallas = catalogoNPCs.obtenerMedallasUnicas(3);

        for (int indiceCiudad = 0; indiceCiudad < 3; indiceCiudad++) {
            EntrenadorNPC lider = new EntrenadorNPC(nombresLideres[indiceCiudad], true);
            EntrenadorNPC[] entrenadores = new EntrenadorNPC[]{
                new EntrenadorNPC(nombresEntrenadores[indiceCiudad * 3], false),
                new EntrenadorNPC(nombresEntrenadores[indiceCiudad * 3 + 1], false),
                new EntrenadorNPC(nombresEntrenadores[indiceCiudad * 3 + 2], false)
            };
            medallas[indiceCiudad].setCiudad(nombresCiudades[indiceCiudad]);
            Gimnasio gimnasio = new Gimnasio(
                    nombresGimnasios[indiceCiudad], lider, entrenadores, medallas[indiceCiudad]);
            ciudades[indiceCiudad] = new MapaCiudad(nombresCiudades[indiceCiudad], gimnasio);
        }

        this.ciudadActual = generadorAleatorio.nextInt(3);
        this.jugador.setPosicion(ciudades[ciudadActual].generarPosicionJugadorValida());
    }

    public int generarIdPokemon() {
        siguienteIdPokemon = siguienteIdPokemon + 1;
        return siguienteIdPokemon;
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

    public int getIndiceCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(int indiceCiudad) {
        if (indiceCiudad >= 0 && indiceCiudad < ciudades.length) {
            this.ciudadActual = indiceCiudad;
        }
    }

    public MapaCiudad[] getCiudades() {
        return ciudades;
    }

    public EstadisticasPartida getEstadisticas() {
        return estadisticas;
    }

    public boolean isHallRegistrado() {
        return hallRegistrado;
    }

    public void setHallRegistrado(boolean hallRegistrado) {
        this.hallRegistrado = hallRegistrado;
    }
}