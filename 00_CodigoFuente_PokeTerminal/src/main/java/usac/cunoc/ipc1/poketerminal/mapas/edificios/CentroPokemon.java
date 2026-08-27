package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class CentroPokemon extends Edificio {
    
    public CentroPokemon() {
        super(6, 23);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        
        String R = Ansi.ROJO;
        String B = Ansi.BLANCO;
        String G = Ansi.GRIS;
        String A = Ansi.AZUL;
        String C = Ansi.CYAN;
        String RESET = Ansi.RESET;
        String N = Ansi.GRIS + "·";

        String[][] pixelArt = {
            // Fila 0: Arco de cristal central y marco azul superior
            {N, N, N, N, A + "█", A + "▓", C + "░", C + "▒", C + "▓", C + "▓", C + "█", C + "█", C + "█", C + "▓", C + "▓", C + "▒", C + "░", A + "▓", A + "█", N, N, N, N + RESET},
            // Fila 1: Marco azul con techo de nubes y el logo centrado (P)
            {N, N, A + "█", A + "▓", C + "░", C + "░", C + "▒", B + "▓", B + "▓", B + "[", R + "C", R + " ", R + "P", B + "]", B + "▓", B + "▓", C + "▒", C + "░", C + "░", A + "▓", A + "█", N, N + RESET},
            // Fila 2: Techos/Domos rojos curvados y la copa del logo Pokébola
            {N, A + "█", R + "▓", R + "█", R + "█", R + "█", R + "▓", R + "░", R + "█", C + "█", C + "█", C + "█", C + "█", C + "█", R + "█", R + "░", R + "▓", R + "█", R + "█", R + "█", R + "▓", A + "█", N + RESET},
            // Fila 4: Paredes blancas/grises superiores, techo de la puerta y ventanitas
            {G + "█", G + "░", G + "░", B + "█", G + "░", G + "░", G + "░", R + "▀", R + "█", R + "█", R + "█", R + "█", R + "█", R + "█", R + "█", R + "▀", G + "░", G + "░", G + "░", B + "█", G + "░", G + "░", G + "█" + RESET},
            // Fila 6: Parte inferior y marco de la puerta automática
            {G + "█", G + "░", G + "▒", C + "█", G + "▒", G + "░", G + "░", G + "░", C + "▒", C + "░", R + "┌", R + "▀", R + "┐", C + "░", C + "▒", G + "░", G + "░", G + "░", G + "▒", C + "█", G + "▒", G + "░", G + "█" + RESET},
            // Fila 7: Base del edificio y entrada
            {G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", C + "▒", C + "░", R + "└", R + "Ω", R + "┘", C + "░", C + "▒", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█" + RESET}
        };

        return pixelArt;
    }
}
