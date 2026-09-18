package usac.cunoc.ipc1.poketerminal.ui;

public class DialogoNPC {
    
    private final Ansi ansi = new Ansi();
    private final AsciiArt asciiArt = new AsciiArt();
    private final PixelArt pixelArt = new PixelArt();
    
    public void profesorOak(String mensaje) {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getBORDE_SUPERIOR());
        System.out.println(pixelArt.getPROFESOR_OAK());
        System.out.println(Ansi.NEGRITA + Ansi.AMARILLO + " PROFESOR OAK:" + Ansi.RESET);
        System.out.println(Ansi.NEGRITA + Ansi.MORADO + " " + mensaje + Ansi.RESET);
        System.out.println(asciiArt.getBORDE_INFERIOR());
    }
}