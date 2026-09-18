package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;

public class EstadisticasPartida implements Serializable {

    private static final long serialVersionUID = 1L;

    private int batallasSalvajes;
    private int batallasEntrenadores;
    private int pokebolasLanzadas;
    private int capturasExitosas;

    public void registrarBatallaSalvaje() {
        batallasSalvajes = batallasSalvajes + 1;
    }

    public void registrarBatallaEntrenador() {
        batallasEntrenadores = batallasEntrenadores + 1;
    }

    public void registrarPokebolaLanzada() {
        pokebolasLanzadas = pokebolasLanzadas + 1;
    }

    public void registrarCaptura() {
        capturasExitosas = capturasExitosas + 1;
    }

    public int getBatallasTotales() {
        return batallasSalvajes + batallasEntrenadores;
    }

    public int getBatallasSalvajes() {
        return batallasSalvajes;
    }

    public int getBatallasEntrenadores() {
        return batallasEntrenadores;
    }

    public int getPokebolasLanzadas() {
        return pokebolasLanzadas;
    }

    public int getCapturasExitosas() {
        return capturasExitosas;
    }
}