package usac.cunoc.ipc1.poketerminal.ui;

public class Ansi {
    
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String GRIS = "\u001B[90m";
    
    public void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }    
}
