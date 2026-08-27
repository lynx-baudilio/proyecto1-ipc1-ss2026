package usac.cunoc.ipc1.poketerminal.mapas;

import usac.cunoc.ipc1.poketerminal.utilidades.EstiloEnConsola;

public abstract class Mapa {
    
    protected String[][] cuadricula;
    protected int filas;
    protected int columnas;
    
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;

        cuadricula = new String[filas][columnas];
        
        generarEsqueleto();
    }
    
    public void imprimirMapa() {
        System.out.println("Mapa de prueba xd");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(cuadricula[i][j]);
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
                    cuadricula[i][j] = EstiloEnConsola.GRIS + "·" + EstiloEnConsola.RESET;
                }
            }
        }
    }   
}
