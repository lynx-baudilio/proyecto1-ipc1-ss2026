package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class GimnasioPokemon extends Edificio {

    public GimnasioPokemon() {
        super(8, 29);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        String Y = Ansi.AMARILLO;
        String B = Ansi.BLANCO;
        String G = Ansi.GRIS;
        String A = Ansi.AZUL;
        String C = Ansi.CYAN;
        String RESET = Ansi.RESET;
        String N = Ansi.GRIS + "·";

        String[][] pixelArt = {
            // Fila 0: Techo superior redondeado y aleros superiores (arcos de la fachada)
            {N, N, A + "█", A + "▓", A + "█", A + "█", A + "▓", A + "▒", Y + "█", Y + "█", Y + "█", C + "▓", C + "▓", C + "█", C + "█", C + "█", C + "▓", C + "▓", Y + "█", Y + "█", Y + "▓", A + "▒", A + "▓", A + "█", A + "█", A + "▓", A + "█", N, N + RESET},
            // Fila 3: Base del techo de cúpula con sombra y volumen
            {N, A + "█", Y + "█", Y + "█", Y + "▓", Y + "▒", Y + "█", Y + "█", Y + "█", C + "▒", C + "▓", C + "█", A + "▒", A + "█", A + "█", A + "█", A + "▒", C + "█", C + "▓", C + "▒", Y + "█", Y + "█", Y + "▓", Y + "▒", Y + "█", Y + "█", Y + "░", A + "█", N + RESET},
            // Fila 4: Borde del techo y ventanales frontales superiores
            {A + "█", Y + "█", Y + "▓", Y + "▒", Y + "█", Y + "█", Y + "▓", Y + "▒", C + "▄", C + "▓", C + "▓", A + "▒", A + "▓", A + "▓", A + "▓", A + "▓", A + "▓", A + "▒", C + "▓", C + "▓", C + "▄", Y + "▒", Y + "█", Y + "█", Y + "▓", Y + "▒", Y + "█", Y + "░", A + "█" + RESET},
            // Fila 5: Ventanales frontales superiores del Gimnasio
            {G + "▒", C + "▓", A + "▓", A + "█", A + "▓", C + "▓", G + "░", G + "░", C + "▓", A + "█", B + "▓", B + "▓", B + "[", Y + "G", Y + " ", Y + "P", B + "]", B + "▓", B + "▓", A + "█", C + "▓", G + "░", G + "░", C + "▓", A + "▓", A + "█", A + "▓", C + "▓", G + "▒" + RESET},
            // Fila 6: Letrero central [ (P) ] y ventanales
            {G + "▒", C + "▓", A + "▓", A + "█", A + "▓", C + "▓", G + "░", G + "▒", C + "▀", C + "▓", A + "▒", C + "▓", C + "█", A + "▓", A + "▓", A + "▓", C + "█", C + "▓", A + "▒", C + "▓", C + "▀", G + "▒", G + "░", C + "▓", A + "▓", A + "█", A + "▓", C + "▓", G + "▒" + RESET},
            // Fila 7: Pared frontal clara y voladizo sobre la puerta
            {G + "▒", G + "░", G + "░", G + "▒", G + "░", G + "░", G + "░", G + "░", G + "▒", G + "░", C + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", C + "█", G + "░", G + "▒", G + "░", G + "░", G + "░", G + "░", G + "▒", G + "░", G + "░", G + "▒" + RESET},
            // Fila 8: Paredes laterales, pilares y puerta de cristal del Gimnasio
            {G + "▒", G + "░", G + "▒", G + "░", G + "▒", G + "░", G + "░", G + "▒", G + "░", G + "▒", G + "░", G + "█", C + "▓", Y + "┌", Y + "▀", Y + "┐", C + "▓", G + "█", G + "░", G + "▒", G + "░", G + "▒", G + "░", G + "░", G + "▒", G + "░", G + "▒", G + "░", G + "▒" + RESET},
            // Fila 9: Cimientos y base del edificio
            {G + "█", G + "█", G + "▓", G + "▓", G + "▓", G + "▓", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", C + "▓", Y + "└", Y + "Ω", Y + "┘", C + "▓", G + "█", G + "█", G + "█", G + "█", G + "█", G + "█", G + "▓", G + "▓", G + "▓", G + "▓", G + "█", G + "█" + RESET}
        };
        
        return pixelArt;
    }
    
}
