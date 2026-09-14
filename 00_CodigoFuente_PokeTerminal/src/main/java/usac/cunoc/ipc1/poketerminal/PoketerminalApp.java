package usac.cunoc.ipc1.poketerminal;

import java.util.Scanner;
import usac.cunoc.ipc1.poketerminal.catalogos.CatalogoPokemones;
import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;
import usac.cunoc.ipc1.poketerminal.modelos.Posicion;
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
    private final CatalogoPokemones pokedex = new CatalogoPokemones();

    private int opcionSeleccionada = 1;
    private boolean pokemonYaSeleccionado = false;
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

            switch (entrada.toLowerCase().trim()) {
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
        ansi.limpiarPantalla();
        
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
        
        opcionSeleccionada = 1;
        
        do {
            ansi.limpiarPantalla();
            eleccionPokemon();
        } while (!pokemonYaSeleccionado);
        
        Pokemon pokemonInicial = pokedex.crearPokemon(idPokemon(), null, 1);
        
        mostrarDialogo.profesorOak("Ala y no de pollo :o. ¡Excelente decisión con " + pokemonInicial.getEspecie() + "!");
        leerEntrada.enter();
        
        String apodoPokemon = leerEntrada.texto("¿Qué apodo le quieres dar a tu " + pokemonInicial.getEspecie()+ "? (Presione ENTER si no quieres agregarle apodo");
        
        if (!apodoPokemon.trim().isEmpty()) {
            pokemonInicial.setApodo(apodoPokemon);
        }
        
        mostrarDialogo.profesorOak("Nítido :D. " + pokemonInicial.getApodo() + " se une a tu aventura");
        leerEntrada.enter();
        
        Posicion posicion = new Posicion(2, 2);
        Jugador jugador = new Jugador(nombreJugador, posicion, pokemonInicial);
        System.out.println("Se supone que todo bien :p");
        scanner.nextLine();
        
        ansi.limpiarPantalla();
        Partida partidaActual = new Partida(nombrePartida, jugador);
        
        mostrarDialogo.profesorOak("¡Nítido " + nombreJugador + "! Ahora te entrego a tu pokemon y suerte :D");
        leerEntrada.enter();
        
        ansi.limpiarPantalla();
        partidaActual.getCiudadActual().imprimirMapa();
    }
    
    private void eleccionPokemon() {        
        System.out.println(asciiArt.getELEGIR_POKEMON());
        System.out.println(pixelArt.getPOKEMONES_DE_ELECCION());
        System.out.println(asciiArt.getNOMBRES_POKEMONES());
        
        System.out.println(pixelArt.getSELECCIONAR_CUADRO(opcionSeleccionada));
        
        String entrada = leerEntrada.texto("Si quieres confirmar la opción seleccionada: X + ENTER\nSi quieres seleccionar la opción de la derecha: D + ENTER\nSi quieres seleccionar la opción de la izquierda: A + ENTER");
        
        switch (entrada.toLowerCase().trim()) {
            case "a":
                if (opcionSeleccionada > 1) {
                    opcionSeleccionada = opcionSeleccionada - 1;
                }
                break;
            case "d":
                if (opcionSeleccionada < 3) {
                    opcionSeleccionada = opcionSeleccionada + 1;
                }
                break;
            case "x":
                pokemonYaSeleccionado = true;
                return;
            default:
                System.out.println("Entrada inválida. Presiona ENTER para volver a intentar");
                scanner.nextLine();        
        }
    }
    
    private int idPokemon() {
        switch (opcionSeleccionada) {
            case 1:
                return 1;
            case 2:
                return 7;
            case 3:
                return 4;
        }
        return 1;
    }
    
    private String pedirNombreDePartida() {
        System.out.println(asciiArt.getINGRESAR_NOMBRE_PARTIDA());
        return leerEntrada.texto("Escriba un nombre para identificar tu partida :p");
    }
}