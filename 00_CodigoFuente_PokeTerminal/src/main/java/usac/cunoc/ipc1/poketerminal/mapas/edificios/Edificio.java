package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.ui.PixelArt;

public abstract class Edificio {
    
    protected int fila;
    protected int columna;
    protected int alto;
    protected int ancho;
    protected String[][] pixelArt;
    
    protected PixelArt edificio = new PixelArt();
    
    public Edificio(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        
        this.pixelArt = construirPixelArt();
    }
    
    protected abstract String[][] construirPixelArt();
    
    public void estamparEdificioEnMapa(int fila, int columna, String[][] cuadricula) {
        this.fila = fila;
        this.columna = columna;
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cuadricula[fila + i][columna + j] = pixelArt[i][j];
            }
        }
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }
    
}
