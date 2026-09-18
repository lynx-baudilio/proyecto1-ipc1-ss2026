package usac.cunoc.ipc1.poketerminal.logica;

import usac.cunoc.ipc1.poketerminal.catalogos.CatalogoPokemones;
import usac.cunoc.ipc1.poketerminal.mapas.MapaCiudad;
import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;
import usac.cunoc.ipc1.poketerminal.modelos.Posicion;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.ui.AsciiArt;
import usac.cunoc.ipc1.poketerminal.ui.DialogoNPC;
import usac.cunoc.ipc1.poketerminal.ui.Pantalla;
import usac.cunoc.ipc1.poketerminal.ui.PixelArt;
import usac.cunoc.ipc1.poketerminal.utilidades.GestorDeArchivos;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class PoketerminalApp {

    private final LeerEntrada leerEntrada = new LeerEntrada();
    private final Pantalla pantalla = new Pantalla();
    private final Ansi ansi = new Ansi();
    private final AsciiArt asciiArt = new AsciiArt();
    private final PixelArt pixelArt = new PixelArt();
    private final DialogoNPC dialogoNPC = new DialogoNPC();
    private final CatalogoPokemones catalogoPokemones = new CatalogoPokemones();
    private final SistemaBatalla sistemaBatalla = new SistemaBatalla();
    private final GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();

    private boolean programaActivo = true;
    private int opcionSeleccionada = 1;
    private boolean pokemonYaSeleccionado = false;

    public void iniciarAplicacion() {
        mostrarPantallaDeInicio();
        mostrarMenuPrincipal();
    }

    // ============================================================
    // PANTALLA DE INICIO
    // ============================================================
    private void mostrarPantallaDeInicio() {
        ansi.limpiarPantalla();
        System.out.println(asciiArt.getBORDE_SUPERIOR());
        System.out.println(asciiArt.getTEXTO_TITULO());
        System.out.println(pixelArt.getPORTADA());
        System.out.println(asciiArt.getBORDE_INFERIOR());
        leerEntrada.enter();
    }

    // ============================================================
    // MENÚ PRINCIPAL
    // ============================================================
    private void mostrarMenuPrincipal() {
        while (programaActivo) {
            pantalla.imprimirMenuPrincipal(opcionSeleccionada);
            String entradaUsuario = leerEntrada.texto(
                    "CONTROLES: [W] ARRIBA | [S] ABAJO | [X] CONFIRMAR SELECCIÓN"
            ).toLowerCase().trim();

            switch (entradaUsuario) {
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
                    ejecutarOpcionMenuPrincipal();
                    break;
                default:
                    System.out.println("Tecla inválida. Presiona ENTER para volver a intentar.");
                    leerEntrada.enter();
            }
        }
    }

    private void ejecutarOpcionMenuPrincipal() {
        switch (opcionSeleccionada) {
            case 1:
                Partida partidaNueva = iniciarNuevaPartida();
                if (partidaNueva != null) {
                    explorarMundo(partidaNueva);
                }
                break;
            case 2:
                String nombrePartida = leerEntrada.texto("Ingresa el nombre de la partida a cargar:");
                Partida partidaCargada = gestorDeArchivos.cargarPartida(nombrePartida);
                if (partidaCargada != null) {
                    System.out.println("Partida cargada del entrenador: "
                            + partidaCargada.getJugador().getNombreJugador());
                    leerEntrada.enter();
                    explorarMundo(partidaCargada);
                } else {
                    System.out.println("No existe esa partida.");
                    leerEntrada.enter();
                }
                break;
            case 3:
                System.out.println("Cerrando PokeTerminal...");
                programaActivo = false;
                break;
        }
    }

    // ============================================================
    // INICIO DE NUEVA PARTIDA
    // ============================================================
    private Partida iniciarNuevaPartida() {
        ansi.limpiarPantalla();
        String nombrePartida = pedirNombreDePartida();

        dialogoNPC.profesorOak("Hola :D. ¡Te doy la bienvenida al mejor mundo Pokémon!");
        leerEntrada.enter();
        dialogoNPC.profesorOak("Yo soy el Profesor Oak. Este mundo está habitado por criaturas llamadas Pokémon.");
        leerEntrada.enter();
        dialogoNPC.profesorOak("Para algunos los Pokémon son mascotas, para otros son compañeros de batalla.");
        leerEntrada.enter();
        dialogoNPC.profesorOak("Pero bueno, empecemos por lo principal. ¿Cuál es tu nombre?");
        String nombreJugador = leerEntrada.texto("Ingresa tu nombre de entrenador");

        dialogoNPC.profesorOak("¡Qué gusto conocerte, " + nombreJugador + " :D!");
        leerEntrada.enter();
        dialogoNPC.profesorOak("Ahora debes elegir tu Pokémon inicial.");
        leerEntrada.enter();

        opcionSeleccionada = 1;
        pokemonYaSeleccionado = false;
        while (!pokemonYaSeleccionado) {
            ansi.limpiarPantalla();
            mostrarEleccionPokemon();
        }

        int identificadorPokemonInicial = obtenerIdentificadorPokemonInicial();
        Pokemon pokemonInicial = catalogoPokemones.crearPokemon(identificadorPokemonInicial, null, 1);

        dialogoNPC.profesorOak("¡Excelente decisión con " + pokemonInicial.getEspecie() + "!");
        leerEntrada.enter();

        String apodoPokemon = leerEntrada.texto(
                "¿Qué apodo le quieres dar a tu " + pokemonInicial.getEspecie() + "? (ENTER para omitir)"
        );
        if (!apodoPokemon.trim().isEmpty()) {
            pokemonInicial.setApodo(apodoPokemon);
        }

        dialogoNPC.profesorOak("¡" + pokemonInicial.getApodo() + " se une a tu aventura!");
        leerEntrada.enter();

        Jugador jugador = new Jugador(nombreJugador, new Posicion(0, 0), pokemonInicial);
        Partida partida = new Partida(nombrePartida, jugador);
        partida.getJugador().setPosicion(partida.getCiudadActual().generarPosicionJugadorValida());

        dialogoNPC.profesorOak("¡Ahora te entrego a tu Pokémon! ¡Mucha suerte, "
                + jugador.getNombreJugador() + "!");
        leerEntrada.enter();

        return partida;
    }

    private void mostrarEleccionPokemon() {
        System.out.println(asciiArt.getELEGIR_POKEMON());
        System.out.println(pixelArt.getPOKEMONES_DE_ELECCION());
        System.out.println(asciiArt.getNOMBRES_POKEMONES());
        System.out.println(pixelArt.getSELECCIONAR_CUADRO(opcionSeleccionada));

        String entradaUsuario = leerEntrada.texto(
                "CONTROLES: [A] IZQUIERDA | [D] DERECHA | [X] SELECCIONAR POKÉMON"
        ).toLowerCase().trim();

        switch (entradaUsuario) {
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
                break;
            default:
                System.out.println("Entrada inválida. Presiona ENTER para volver a intentar.");
                leerEntrada.enter();
        }
    }

    private int obtenerIdentificadorPokemonInicial() {
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
        System.out.println(pixelArt.getPEDIR_NOMBRE_DE_PARTIDA());
        return leerEntrada.texto("Escribe un nombre para identificar tu partida");
    }

    // ============================================================
    // EXPLORACIÓN DEL MUNDO
    // ============================================================
    private void explorarMundo(Partida partidaActual) {
        boolean explorando = true;
        while (explorando) {
            MapaCiudad ciudadActual = partidaActual.getCiudadActual();
            Jugador jugador = partidaActual.getJugador();

            ansi.limpiarPantalla();
            System.out.println(asciiArt.getBORDE_SUPERIOR());
            pantalla.imprimirEncabezado(jugador, ciudadActual.getNombreCiudad());
            pantalla.imprimirMapa(ciudadActual, jugador);
            System.out.println(asciiArt.getBORDE_INFERIOR());

            String entradaUsuario = leerEntrada.texto(
                    "Controles: [W/A/S/D] Mover | [X] Entrar/Interactuar | [1-6] Menú | [Q] Salir partida"
            ).toLowerCase().trim();

            if (entradaUsuario.equals("q")) {
                explorando = false;
                continue;
            }
            if (entradaUsuario.matches("[1-6]")) {
                ejecutarOpcionMenuGeneral(partidaActual, Integer.parseInt(entradaUsuario));
                continue;
            }
            if (entradaUsuario.equals("x")) {
                interactuarEnCiudad(partidaActual);
                continue;
            }

            int nuevaFila = jugador.getPosicion().getFila();
            int nuevaColumna = jugador.getPosicion().getColumna();
            switch (entradaUsuario) {
                case "w":
                    nuevaFila = nuevaFila - 1;
                    break;
                case "s":
                    nuevaFila = nuevaFila + 1;
                    break;
                case "a":
                    nuevaColumna = nuevaColumna - 1;
                    break;
                case "d":
                    nuevaColumna = nuevaColumna + 1;
                    break;
                default:
                    continue;
            }

            if (ciudadActual.esCasillaPasable(nuevaFila, nuevaColumna)) {
                jugador.getPosicion().setFila(nuevaFila);
                jugador.getPosicion().setColumna(nuevaColumna);
                verificarEncuentroSalvaje(partidaActual);
            }
        }
    }

    private void verificarEncuentroSalvaje(Partida partidaActual) {
        MapaCiudad ciudadActual = partidaActual.getCiudadActual();
        Jugador jugador = partidaActual.getJugador();
        String casillaActual = ciudadActual.getCuadricula()[jugador.getPosicion().getFila()][jugador.getPosicion().getColumna()];

        if (casillaActual.contains("¥")) {
            java.util.Random generadorAleatorio = new java.util.Random();
            if (generadorAleatorio.nextInt(100) < 15) {
                int nivelSalvaje = Formulas.nivelGenerado(
                        jugador.sumaNiveles(),
                        jugador.getPokemonesActuales(),
                        0.4
                );
                int identificadorEspecie = generadorAleatorio.nextInt(25) + 1;
                Pokemon pokemonSalvaje = catalogoPokemones.crearPokemon(
                        identificadorEspecie, null, nivelSalvaje);
                sistemaBatalla.iniciarBatallaSalvaje(jugador, pokemonSalvaje);
                partidaActual.getEstadisticas().registrarBatallaSalvaje();
            }
        }
    }

    private void interactuarEnCiudad(Partida partidaActual) {
        MapaCiudad ciudadActual = partidaActual.getCiudadActual();
        Jugador jugador = partidaActual.getJugador();
        int filaJugador = jugador.getPosicion().getFila();
        int columnaJugador = jugador.getPosicion().getColumna();
        String casillaActual = ciudadActual.getCuadricula()[filaJugador][columnaJugador];

        if (casillaActual.contains("Ω")) {
            if (casillaActual.contains(Ansi.ROJO)) {
                ciudadActual.getCentroPokemon().abrir(partidaActual);
            } else if (casillaActual.contains(Ansi.AZUL)) {
                ciudadActual.getTiendaPokemon().abrir(partidaActual);
            } else if (casillaActual.contains(Ansi.AMARILLO)) {
                ciudadActual.getGimnasioPokemon().abrir(partidaActual);
            }
        } else {
            System.out.println("No hay nada con qué interactuar aquí.");
            leerEntrada.enter();
        }
    }

    // ============================================================
    // MENÚ GENERAL
    // ============================================================
    private void ejecutarOpcionMenuGeneral(Partida partidaActual, int opcionElegida) {
        switch (opcionElegida) {
            case 1:
                mostrarMenuPokemon(partidaActual);
                break;
            case 2:
                mostrarMenuPokedex(partidaActual);
                break;
            case 3:
                mostrarMenuPerfil(partidaActual);
                break;
            case 4:
                mostrarMenuMochila(partidaActual);
                break;
            case 5:
                mostrarMenuMapa(partidaActual);
                break;
            case 6:
                guardarYSalir(partidaActual);
                break;
        }
    }

    private void mostrarMenuPokemon(Partida partidaActual) {
        Jugador jugador = partidaActual.getJugador();
        ansi.limpiarPantalla();
        System.out.println(Ansi.AMARILLO + "=== EQUIPO POKÉMON ===" + Ansi.RESET);
        for (int indice = 0; indice < jugador.getPokemonesActuales(); indice++) {
            System.out.println((indice + 1) + ". " + jugador.getEquipoPokemon()[indice].lineaEquipo());
        }
        System.out.println("\n[1-" + jugador.getPokemonesActuales() + "] Seleccionar | [X] Volver");
        String entradaUsuario = leerEntrada.texto("Opción").trim().toLowerCase();
        if (entradaUsuario.equals("x")) {
            return;
        }
        try {
            int indiceSeleccionado = Integer.parseInt(entradaUsuario) - 1;
            if (indiceSeleccionado >= 0 && indiceSeleccionado < jugador.getPokemonesActuales()) {
                subMenuPokemon(partidaActual, indiceSeleccionado);
            }
        } catch (NumberFormatException excepcion) {
            System.out.println("Opción inválida.");
            leerEntrada.enter();
        }
    }

    private void subMenuPokemon(Partida partidaActual, int indicePokemon) {
        Jugador jugador = partidaActual.getJugador();
        Pokemon pokemonSeleccionado = jugador.getEquipoPokemon()[indicePokemon];
        System.out.println("\n" + pokemonSeleccionado.lineaEquipo());
        System.out.println("[1] Reordenar | [2] Liberar | [X] Volver");
        String opcionElegida = leerEntrada.texto("Opción").trim().toLowerCase();

        if (opcionElegida.equals("1")) {
            try {
                int destino = Integer.parseInt(leerEntrada.texto(
                        "Nueva posición (1-" + jugador.getPokemonesActuales() + "):")) - 1;
                if (jugador.intercambiar(indicePokemon, destino)) {
                    System.out.println("Pokémon reordenado.");
                } else {
                    System.out.println("Posición inválida.");
                }
            } catch (NumberFormatException excepcion) {
                System.out.println("Entrada inválida.");
            }
            leerEntrada.enter();
        } else if (opcionElegida.equals("2")) {
            if (jugador.liberarPokemon(indicePokemon)) {
                System.out.println(pokemonSeleccionado.getApodo() + " fue liberado.");
            } else {
                System.out.println("No puedes liberar a tu último Pokémon.");
            }
            leerEntrada.enter();
        }
    }

    private void mostrarMenuPokedex(Partida partidaActual) {
        ansi.limpiarPantalla();
        System.out.println(Ansi.CYAN + "=== POKÉDEX ===" + Ansi.RESET);
        String filtroBusqueda = leerEntrada.texto(
                "Nombre a buscar (ENTER para listar todos):").trim();
        catalogoPokemones.listarEspecies(filtroBusqueda);
        leerEntrada.enter();
    }

    private void mostrarMenuPerfil(Partida partidaActual) {
        Jugador jugador = partidaActual.getJugador();
        ansi.limpiarPantalla();
        System.out.println(Ansi.AMARILLO + "=== PERFIL DEL ENTRENADOR ===" + Ansi.RESET);
        System.out.println("Nombre: " + jugador.getNombreJugador());
        System.out.println("Pokémonedas: ₱" + jugador.getPokemonedas());
        System.out.println("Medallas obtenidas: " + jugador.getMedallasObtenidas() + "/3");
        for (int indice = 0; indice < jugador.getMedallasObtenidas(); indice++) {
            System.out.println("  " + jugador.getMedallas()[indice].textoPerfil());
        }
        leerEntrada.enter();
    }

    private void mostrarMenuMochila(Partida partidaActual) {
        ansi.limpiarPantalla();
        System.out.println(Ansi.MORADO + "=== MOCHILA ===" + Ansi.RESET);
        partidaActual.getJugador().getMochila().listar();
        leerEntrada.enter();
    }

    private void mostrarMenuMapa(Partida partidaActual) {
        ansi.limpiarPantalla();
        int seleccion = partidaActual.getIndiceCiudadActual();
        boolean viajado = false;
        do {
            pantalla.imprimirMapaAereo(partidaActual, seleccion);
            String entrada = leerEntrada.texto("CONTROLES: [W] ARRIBA | [S] ABAJO | [X] CONFIRMAR VUELO");
            switch (entrada.toLowerCase().trim()) {
                case "w":
                    if (seleccion > 0) {
                        seleccion = seleccion - 1;
                    }
                    break;
                case "s":
                    if (seleccion < 2) {
                        seleccion = seleccion + 1;
                    }
                    break;
                case "x":
                    partidaActual.setCiudadActual(seleccion);
                    partidaActual.getJugador().setPosicion(partidaActual.getCiudadActual().generarPosicionJugadorValida());
                    viajado = true;
                    break;
            }
        } while (!viajado);
    }

    private void guardarYSalir(Partida partidaActual) {
        if (gestorDeArchivos.guardarPartida(partidaActual)) {
            System.out.println(Ansi.VERDE + "¡Partida guardada exitosamente!" + Ansi.RESET);
        } else {
            System.out.println(Ansi.ROJO + "Error al guardar la partida." + Ansi.RESET);
        }
        leerEntrada.enter();
        programaActivo = false;
    }
}