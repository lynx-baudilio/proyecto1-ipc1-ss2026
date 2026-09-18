package usac.cunoc.ipc1.poketerminal.ui;

import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;
import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.modelos.Posicion;

public class Pantalla {
    private Ansi ansi = new Ansi();
    private AsciiArt asciiArt = new AsciiArt();

    public void imprimirMenuPrincipal(int opcionSeleccionada) {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getPOKE_START());
        System.out.println((opcionSeleccionada == 1 ? asciiArt.getNUEVA_PARTIDA(true) : asciiArt.getNUEVA_PARTIDA(false)));
        System.out.println((opcionSeleccionada == 2 ? asciiArt.getCARGAR_PARTIDA(true) : asciiArt.getCARGAR_PARTIDA(false)));
        System.out.println((opcionSeleccionada == 3 ? asciiArt.getSALIR(true) : asciiArt.getSALIR(false)));
    }

    public void imprimirEncabezado(Jugador jugador, String nombreCiudad) {
        System.out.println(Ansi.AMARILLO + "Entrenador: " + jugador.getNombreJugador()
                + " | Ciudad: " + nombreCiudad + Ansi.RESET);
    }

    public void imprimirMapa(MapaCiudad mapa, Jugador jugador) {
        Posicion pos = jugador.getPosicion();
        String[][] cuadricula = mapa.getCuadricula();

        for (int i = 0; i < mapa.getFilas(); i++) {
            for (int j = 0; j < mapa.getColumnas(); j++) {
                if (i == pos.getFila() && j == pos.getColumna()) {
                    System.out.print(jugador.getSimbolo());
                } else {
                    System.out.print(cuadricula[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void imprimirMapaAereo(Partida partida, int seleccion) {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getBORDE_SUPERIOR());
        System.out.println(asciiArt.getMAPA_AEREO());
        System.out.println(asciiArt.getBORDE_INFERIOR());
        System.out.println();

        MapaCiudad[] ciudades = partida.getCiudades();

        for (int i = 0; i < ciudades.length; i++) {
            boolean esSeleccionada = (i == seleccion);
            String nombre = ciudades[i].getNombreCiudad();
            System.out.println(obtenerAsciiCiudad(nombre, esSeleccionada));
        }
    }

    private String obtenerAsciiCiudad(String nombre, boolean seleccionado) {
        switch (nombre.toUpperCase()) {
            case "PUEBLO PALETA":
                return asciiArt.getCIUDAD_PUEBLO_PALETA(seleccionado);
            case "CIUDAD VERDE":
                return asciiArt.getCIUDAD_VERDE(seleccionado);
            case "CIUDAD PLATEADA":
                return asciiArt.getCIUDAD_PLATEADA(seleccionado);
            case "CIUDAD CERÚLEA":
                return asciiArt.getCIUDAD_CERULEA(seleccionado);
            case "CIUDAD CARMÍN":
                return asciiArt.getCIUDAD_CARMIN(seleccionado);
            case "CIUDAD AZULONA":
                return asciiArt.getCIUDAD_AZULONA(seleccionado);
            default:
                return asciiArt.getCIUDAD_PUEBLO_PALETA(seleccionado);
        }
    }
}