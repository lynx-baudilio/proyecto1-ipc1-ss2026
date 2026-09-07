package usac.cunoc.ipc1.poketerminal.utilidades;

import java.util.Scanner;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class LeerEntrada {
    
    private final Scanner scanner = new Scanner(System.in);
    
    public String texto(String mensaje) {
        System.out.print(
                Ansi.VERDE + mensaje + 
                Ansi.RESET + "\n" + flecha());
        String entrada = scanner.nextLine();
        System.out.println(Ansi.RESET);
        return entrada;
    }
    
    public void enter() {
        System.out.print(Ansi.NEGRITA + 
                Ansi.AMARILLO + "(-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-)" + 
                Ansi.BLANCO + " Presiona ENTER " + 
                Ansi.AMARILLO + "(-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-) (-)" +
                Ansi.RESET + "\n                                                             " + flecha());
        scanner.nextLine();
        System.out.println(Ansi.RESET);
    }
    
    private String flecha() {
        return Ansi.NEGRITA + Ansi.CYAN + "»";
    }
    
}
