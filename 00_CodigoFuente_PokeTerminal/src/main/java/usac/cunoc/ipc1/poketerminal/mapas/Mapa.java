package usac.cunoc.ipc1.poketerminal.mapas;

import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Posicion;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public abstract class Mapa {
    protected final int[][] ZONAS_VALIDAS = {
        {2, 3},
        {2, 36},
        {10, 3},
        {10, 36}
    };
    
    protected String[][] cuadricula;
    protected int filas;
    protected int columnas;
    
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;

        cuadricula = new String[filas][columnas];
        
        generarEsqueleto();
    }
    
    public void imprimirMapa(Jugador jugador) {
        Posicion posicion = jugador.getPosicion();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == posicion.getFila() && j == posicion.getColumna()) {
                    System.out.print(jugador.getSimbolo());
                } else {
                    System.out.print(cuadricula[i][j]);
                }
            }
            System.out.println();
        }
    }

    private void generarEsqueleto() {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if ((i > 0 && i < (filas - 1)) && (j == 0 || j == (columnas - 1))) {
                    cuadricula[i][j] = "║";
                } else if ((j > 0 && j < (columnas - 1)) && (i == 0 || i == (filas - 1))) {
                    cuadricula[i][j] = "═";
                } else if (i == 0 && j == 0) {
                    cuadricula[0][0] = "╔";
                } else if (i == (filas - 1) && j == 0) {
                    cuadricula[filas - 1][0] = "╚";
                } else if (i == 0 && j == (columnas - 1)) {
                    cuadricula[0][columnas - 1] = "╗";
                } else if (i == (filas - 1) && j == (columnas - 1)) {
                    cuadricula[filas - 1][columnas - 1] = "╝";
                } else {
                    cuadricula[i][j] = Ansi.GRIS + "·" + Ansi.RESET;
                }
            }
        }
    }
    
    public boolean esCasillaPasable(int f, int c) {
        if (f < 1 || f >= filas - 1 || c < 1 || c >= columnas - 1) {
            return false;
        }
        String casilla = cuadricula[f][c];
        return casilla.contains("·") || casilla.contains("¥") || casilla.contains("Ω");
    }
}
