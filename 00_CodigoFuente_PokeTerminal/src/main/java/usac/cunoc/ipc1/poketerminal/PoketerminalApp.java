package usac.cunoc.ipc1.poketerminal;

import java.util.Scanner;
import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.ui.AsciiArt;
import usac.cunoc.ipc1.poketerminal.ui.DialogoNPC;
import usac.cunoc.ipc1.poketerminal.ui.PixelArt;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class PoketerminalApp {
    
    private final Scanner scanner = new Scanner(System.in);
    private final LeerEntrada leerEntrada = new LeerEntrada();
    private final Ansi ansi = new Ansi();
    private final AsciiArt asciiArt = new AsciiArt();
    private final PixelArt pixelArt = new PixelArt();
    private final DialogoNPC mostrarDialogo = new DialogoNPC();

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
            
            entrada = leerEntrada.texto("Si quieres confirmar la opción seleccionada: X + ENTER\nSi quieres seleccionar la opción de arriba: W + ENTER\nSi quieres seleccionar la opción de abajo: S + ENTER");

            switch (entrada.toLowerCase()) {
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
        String nombrePartida = pedirNombreDePartida();
        
        mostrarDialogo.profesorOak("Hola :D. Te doy la bienvenida al mejor mundo Pokémon!");
        leerEntrada.enter();
        mostrarDialogo.profesorOak("Yo soy el Profesor Oak. Estoy para ayudarte en este mundo que está habitado por criaturas llamadas pokémon.");
        leerEntrada.enter();
        mostrarDialogo.profesorOak("Para algunos los pokemones son mascotas, y para otros son gallos de pelea.");
        leerEntrada.enter();
        mostrarDialogo.profesorOak("Pero don't worry dijo aquel, porque yo estudio a los pokemones como profesión.");
        leerEntrada.enter();
        
        mostrarDialogo.profesorOak("Pero pues si, empecemos por lo principal, ¿Cuál es tu nombre?");
        String nombreJugador = leerEntrada.texto("Ingresa tu nombre de entrenador");
        
        mostrarDialogo.profesorOak("¡Que calidad conocerte " + nombreJugador + ":D!");
        leerEntrada.enter();
        mostrarDialogo.profesorOak("Ahora debes eligir tu pokemon inicial.");
        leerEntrada.enter();

        int opcionPokemon = Integer.valueOf(leerEntrada.texto("Elige tu pokémon inicial:\n[1] Bulbasaur\n[2] Squirtle\n[3] Charmander"));
        
        String pokemonElegido = "";
        switch (opcionPokemon) {
            case 1:
                pokemonElegido = "bulbasaur";
                break;
            case 2:
                pokemonElegido = "squirtle";
                break;
            case 3:
                pokemonElegido = "charmander";
                break;
            default:
                System.out.println("Coloca un número válido :c");
        }
        
        mostrarDialogo.profesorOak("Ala y no de pollo :o. ¡Excelente decisión con " + pokemonElegido + "!");
        leerEntrada.enter();
        
        String apodoPokemon = leerEntrada.texto("¿Qué apodo le quieres dar a tu " + pokemonElegido + "? (Presione ENTER si no quieres agregarle apodo");
        
        if (apodoPokemon.isEmpty()) {
            apodoPokemon = pokemonElegido;
        }
        
        mostrarDialogo.profesorOak("Nítido entonces :D. " + apodoPokemon + " se une a tu aventura");
        leerEntrada.enter();
        
        ansi.limpiarPantalla();
        MapaCiudad mapaCiudad = new MapaCiudad();
        mapaCiudad.imprimirMapa();
    }
    
    private String pedirNombreDePartida() {
        asciiArt.getINGRESAR_NOMBRE_PARTIDA();
        return leerEntrada.texto("Escriba un nombre para identificar tu partida :p");
    }
}