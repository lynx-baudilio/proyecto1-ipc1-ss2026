package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class TiendaPokemon extends Edificio{

    public TiendaPokemon() {
        super(5, 19);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        
        String A = Ansi.AZUL;
        String B = Ansi.BLANCO;
        String G = Ansi.GRIS;
        String C = Ansi.CYAN;
        String M = Ansi.MORADO;
        String V = Ansi.VERDE;
        String RESET = Ansi.RESET;
        String N = Ansi.GRIS + "·";

        String[][] pixelArt = {
            // Fila 0: Techo azul superior inclinado (borde redondeado)
            {N, N, A + "█", A + "▓", A + "▓", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "▓", A + "▓", A + "█", N, N + RESET},
            // Fila 1: Techo azul frontal con patrón de tejas
            {N, A + "█", A + "▓", A + "▒", A + "░", A + "▓", A + "▒", B + "[", V + "T", V + " ", V + "P", B + "]", A + "▒", A + "░", A + "▓", A + "▒", A + "░", A + "█", N + RESET},
            // Fila 2: Alero inferior azul y letrero central Pokébola (P)
            {A + "█", A + "▓", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "█", A + "▓", A + "█" + RESET},
            // Fila 3: Paredes blancas/grises, cartel [SHOP] y tope de puerta
            {G + "▒", G + "░", B + "[", M + "S", M + "H", M + "O", M + "P", B + "]", G + "░", G + "░", C + "█", A + "┌", A + "▀", A + "┐", C + "▒", G + "░", G + "░", G + "░", G + "▒" + RESET},
            // Fila 5: Base sólida del edificio y entrada principal
            {G + "█", G + "█", G + "▓", G + "▓", G + "▓", G + "▓", G + "▓", G + "▓", G + "▓", G + "▓", C + "█", A + "└", A + "Ω", A + "┘", C + "▒", G + "▓", G + "▓", G + "█", G + "█" + RESET}
        };

        return pixelArt;
    }
    
}
