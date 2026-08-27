package usac.cunoc.ipc1.poketerminal;

import com.sun.source.tree.BreakTree;
import usac.cunoc.ipc1.poketerminal.utilidades.EstiloEnConsola;
import java.util.Scanner;
import javax.xml.stream.util.EventReaderDelegate;

public class MenuPrincipal {
    
    private Scanner scanner = new Scanner(System.in);
    private EstiloEnConsola estilo = new EstiloEnConsola();
    
    private int opcionSeleccionada = 1;
    private boolean programaActivo = true;
    
    public void mostrarMenu() {
        
        String entrada;
        
        do {            
            estilo.limpiarPantalla();
            System.out.println("====== Menú Principal ======");
            System.out.println((opcionSeleccionada == 1 ? EstiloEnConsola.MORADO + "-> " : "   ") + "[1] Iniciar Nueva Partida" + EstiloEnConsola.RESET);
            System.out.println((opcionSeleccionada == 2 ? EstiloEnConsola.MORADO + "-> " : "   ") + "[2] Cargar Partida" + EstiloEnConsola.RESET);
            System.out.println((opcionSeleccionada == 3 ? EstiloEnConsola.MORADO + "-> " : "   ") + "[3] Salir" + EstiloEnConsola.RESET);
            System.out.println("============================");
            System.out.print("Usar W + ENTER (arriba) ó S + ENTER (abajo) y X + ENTER para confirmar selección: ");
            
            entrada = scanner.nextLine().toLowerCase().trim();
            
            switch (entrada) {
                case "w":
                    if (opcionSeleccionada > 1) {
                        opcionSeleccionada = opcionSeleccionada - 1;
                    }
                    break;
                case "s":
                    if (opcionSeleccionada < 3) {
                        opcionSeleccionada = opcionSeleccionada + 1;
                    }
                    break;
                case "x":
                    ejecutarOpcionSeleccionada();
                    break;
                default:
                    System.out.println("Tecla no válida. Presiona ENTER para volver a intentar");
                    scanner.nextLine();
            }
            
        } while (programaActivo);
    }
    
    private void ejecutarOpcionSeleccionada() {
        switch (opcionSeleccionada) {
            case 1:
                System.out.println("Iniciando nueva partida");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Cargando partida");
                scanner.nextLine();
                break;
            case 3:
                System.out.println("Cerrando programa");
                programaActivo = false;
                break;
        }
    }
}
