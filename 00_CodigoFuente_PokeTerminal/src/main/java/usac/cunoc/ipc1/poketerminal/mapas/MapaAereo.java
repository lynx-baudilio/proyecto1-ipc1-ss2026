package usac.cunoc.ipc1.poketerminal.mapas;

import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.ui.Pantalla;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class MapaAereo {
    
    private final LeerEntrada leerEntrada = new LeerEntrada();
    private final Ansi ansi = new Ansi();

    public void abrir(Partida partidaActual) {
        int seleccion = partidaActual.getIndiceCiudadActual();
        boolean viajado = false;

        do {
            ansi.limpiarPantalla();
            imprimirMapaAereo(partidaActual, seleccion);

            String entrada = leerEntrada.texto(
                    "Controles: [A] Izquierda | [D] Derecha | [X] Confirmar Vuelo"
            ).toLowerCase().trim();

            switch (entrada) {
                case "a":
                    if (seleccion > 0) {
                        seleccion = seleccion - 1;
                    }
                    break;
                case "d":
                    if (seleccion < 2) {
                        seleccion = seleccion + 1;
                    }
                    break;
                case "x":
                    partidaActual.setCiudadActual(seleccion);
                    partidaActual.getJugador().setPosicion(partidaActual.getCiudadActual().generarPosicionJugadorValida());
                    viajado = true;
                    break;
            }
        } while (!viajado);
    }

    private void imprimirMapaAereo(Partida partida, int seleccion) {
        Pantalla pantalla = new Pantalla();
        pantalla.imprimirMapaAereo(partida, seleccion);
    }   
}