package usac.cunoc.ipc1.poketerminal;

import java.util.Scanner;
import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.ui.AsciiArt;
import usac.cunoc.ipc1.poketerminal.ui.PixelArt;

public class PoketerminalApp {
    
    private final Scanner scanner = new Scanner(System.in);
    private final AsciiArt asciiArt = new AsciiArt();
    private final PixelArt pixelArt = new PixelArt();
    private final Ansi ansi = new Ansi();

    private int opcionSeleccionada = 1;
    private boolean programaActivo = true;
    
    public void iniciar() {
        mostrarInicio();
        mostrarMenu();
    }
    
    private void mostrarInicio() {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getBORDE_SUPERIOR());
        System.out.println(asciiArt.getTEXTO_TITULO());
        System.out.println(pixelArt.getPORTADA());
        System.out.println(asciiArt.getBORDE_INFERIOR());
        scanner.nextLine();
    }

    private void mostrarMenu() {

        String entrada;

        do {
            ansi.limpiarPantalla();
            System.out.println(asciiArt.getPOKE_START());
            System.out.println((opcionSeleccionada == 1 ? asciiArt.getNUEVA_PARTIDA(true) : asciiArt.getNUEVA_PARTIDA(false)));
            System.out.println((opcionSeleccionada == 2 ? asciiArt.getCARGAR_PARTIDA(true) : asciiArt.getCARGAR_PARTIDA(false)));
            System.out.println((opcionSeleccionada == 3 ? asciiArt.getSALIR(true) : asciiArt.getSALIR(false)));
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
                    System.out.println("Tecla inválida. Presiona ENTER para volver a intentar");
                    scanner.nextLine();
            }

        } while (programaActivo);
    }

    private void ejecutarOpcionSeleccionada() {
        switch (opcionSeleccionada) {
            case 1:
                iniciarNuevaPartida();
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
    
    private void iniciarNuevaPartida() {        
        
        mostrarDialogoProfesorOak("Hola :D. Te doy la bienvenida al mejor mundo Pokémon!");
        scanner.nextLine();
        mostrarDialogoProfesorOak("Yo soy el Profesor Oak. Estoy para ayudarte en este mundo que está habitado por criaturas llamadas pokémon.");
        scanner.nextLine();
        mostrarDialogoProfesorOak("Para algunos los pokemones son mascotas, y para otros son gallos de pelea.");
        scanner.nextLine();
        mostrarDialogoProfesorOak("Pero don't worry dijo aquel, porque yo estudio a los pokemones como profesión.");
        scanner.nextLine();
        mostrarDialogoProfesorOak("Pero pues si, empecemos por lo principal, ¿Cuál es tu nombre?");
        scanner.nextLine();
        
        MapaCiudad mapaCiudad = new MapaCiudad();
        mapaCiudad.imprimirMapa();
    }
    
    private void mostrarDialogoProfesorOak(String mensaje) {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getBORDE_SUPERIOR());
        System.out.println(pixelArt.getPROFESOR_OAK());
        System.out.println(Ansi.NEGRITA + Ansi.AMARILLO + " PROFESOR OAK:" + Ansi.RESET);
        System.out.println(Ansi.NEGRITA + Ansi.MORADO + " " + mensaje + Ansi.RESET);
        System.out.println(asciiArt.getBORDE_INFERIOR());
    }
    
}