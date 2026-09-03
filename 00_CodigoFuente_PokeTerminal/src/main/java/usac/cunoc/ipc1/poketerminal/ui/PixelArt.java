package usac.cunoc.ipc1.poketerminal.ui;

public class PixelArt {
    
    private static final String RESET = Ansi.RESET;
    private static final String R = Ansi.ROJO;
    private static final String V = Ansi.VERDE;
    private static final String Y = Ansi.AMARILLO;
    private static final String A = Ansi.AZUL;
    private static final String M = Ansi.MORADO;
    private static final String C = Ansi.CYAN;
    private static final String B = Ansi.BLANCO;
    private static final String G = Ansi.GRIS;
    private static final String N = Ansi.GRIS + "·";

    private final String[][] GIMNASIO_POKEMON = {
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
    
    private final String[][] CENTRO_POKEMON = {
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
    
    private final String[][] TIENDA_POKEMON = {
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

    public String[][] getGIMNASIO() {
        return GIMNASIO_POKEMON;
    }

    public String[][] getCENTRO() {
        return CENTRO_POKEMON;
    }

    public String[][] getTIENDA() {
        return TIENDA_POKEMON;
    }

    
}
