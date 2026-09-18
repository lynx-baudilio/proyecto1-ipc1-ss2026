package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.catalogos.CatalogoPokemones;
import usac.cunoc.ipc1.poketerminal.logica.Formulas;
import usac.cunoc.ipc1.poketerminal.logica.SistemaBatalla;
import usac.cunoc.ipc1.poketerminal.modelos.EntrenadorNPC;
import usac.cunoc.ipc1.poketerminal.modelos.Gimnasio;
import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.utilidades.GestorDeArchivos;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class GimnasioPokemon extends Edificio {
    
    private final LeerEntrada leerEntrada = new LeerEntrada();
    private final CatalogoPokemones catalogoPokemones = new CatalogoPokemones();
    private final SistemaBatalla sistemaBatalla = new SistemaBatalla();
    private final GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
    private final Random generadorAleatorio = new Random();
    
    public GimnasioPokemon() {
        super(8, 29);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return edificio.getGIMNASIO();
    }   

    @Override
    public void abrir(Partida partida) {
        Gimnasio gimnasio = partida.getCiudadActual().getGimnasio();
        boolean dentroDelGimnasio = true;

        while (dentroDelGimnasio) {
            Ansi ansi = new Ansi();
            ansi.limpiarPantalla();

            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╔════════════════════════════════════════════════════════╗" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "║" + Ansi.AMARILLO + "  " + gimnasio.getNombre() + "  " + Ansi.BLANCO + "║" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╠════════════════════════════════════════════════════════╣" + Ansi.RESET);
            System.out.println("║  [1] Entrenador: " + gimnasio.buscarEntrenadorPorIndice(0).getNombre());
            System.out.println("║  [2] Entrenador: " + gimnasio.buscarEntrenadorPorIndice(1).getNombre());
            System.out.println("║  [3] Entrenador: " + gimnasio.buscarEntrenadorPorIndice(2).getNombre());
            System.out.println("║  [4] Líder: " + gimnasio.getLider().getNombre());
            System.out.println("║  [Q] Salir al mapa de la ciudad");
            System.out.println("╚════════════════════════════════════════════════════════╝");

            String opcionElegida = leerEntrada.texto("Opción").toLowerCase().trim();

            switch (opcionElegida) {
                case "1":
                    retarEntrenador(partida, gimnasio.buscarEntrenadorPorIndice(0), 0.6);
                    break;
                case "2":
                    retarEntrenador(partida, gimnasio.buscarEntrenadorPorIndice(1), 0.6);
                    break;
                case "3":
                    retarEntrenador(partida, gimnasio.buscarEntrenadorPorIndice(2), 0.6);
                    break;
                case "4":
                    retarEntrenador(partida, gimnasio.getLider(), 0.75);
                    break;
                case "q":
                    dentroDelGimnasio = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    leerEntrada.enter();
            }
        }
    }

    private void retarEntrenador(Partida partida, EntrenadorNPC entrenador, double multiplicadorNivel) {
        if (entrenador.estaDerrotado()) {
            System.out.println(entrenador.getNombre() + ": ¡Ya me has derrotado antes!");
            leerEntrada.enter();
            return;
        }

        if (!entrenador.equipoYaGenerado()) {
            generarEquipoEntrenador(partida.getJugador(), entrenador, multiplicadorNivel);
        }

        System.out.println(entrenador.getNombre() + ": ¡A luchar!");
        leerEntrada.enter();

        boolean ganoBatalla = sistemaBatalla.iniciarBatallaEntrenador(
                partida.getJugador(), entrenador.getEquipo(), entrenador.getNombre());
        partida.getEstadisticas().registrarBatallaEntrenador();

        if (ganoBatalla) {
            entrenador.setDerrotado(true);
            if (entrenador.esLider()) {
                otorgarMedalla(partida);
            }
        }
    }

    private void generarEquipoEntrenador(Jugador jugador, EntrenadorNPC entrenador, double multiplicador) {
        int cantidadPokemonesJugador = jugador.getPokemonesActuales();
        int cantidadPokemonesRival = generadorAleatorio.nextInt(cantidadPokemonesJugador) + 1;
        int nivelPokemonesRival = Formulas.nivelGenerado(
                jugador.sumaNiveles(), cantidadPokemonesJugador, multiplicador);

        Pokemon[] equipoRival = new Pokemon[cantidadPokemonesRival];
        for (int indice = 0; indice < cantidadPokemonesRival; indice++) {
            int identificadorEspecie = generadorAleatorio.nextInt(25) + 1;
            equipoRival[indice] = catalogoPokemones.crearPokemon(
                    identificadorEspecie, null, nivelPokemonesRival);
        }
        entrenador.setEquipo(equipoRival);
    }

    private void otorgarMedalla(Partida partida) {
        Gimnasio gimnasio = partida.getCiudadActual().getGimnasio();
        Jugador jugador = partida.getJugador();

        if (!jugador.yaTieneMedalla(gimnasio.getMedalla().getNombre())) {
            jugador.agregarMedalla(gimnasio.getMedalla());
            System.out.println(Ansi.VERDE + "¡Obtuviste la " + gimnasio.getMedalla().getNombre() + "!" + Ansi.RESET);
        }

        if (jugador.tieneTresMedallas() && !partida.isHallRegistrado()) {
            registrarEnHallDeLaFama(partida);
            partida.setHallRegistrado(true);
        }
        leerEntrada.enter();
    }

    private void registrarEnHallDeLaFama(Partida partida) {
        Jugador jugador = partida.getJugador();
        StringBuilder registro = new StringBuilder();

        registro.append("=== HALL DE LA FAMA ===\n");
        registro.append("Entrenador: ").append(jugador.getNombreJugador()).append("\n");
        registro.append("Balance final: ₱").append(jugador.getPokemonedas()).append("\n");
        registro.append("Medallas:\n");
        for (int indice = 0; indice < jugador.getMedallasObtenidas(); indice++) {
            registro.append("  ").append(jugador.getMedallas()[indice].textoPerfil()).append("\n");
        }
        registro.append("Equipo victorioso:\n");
        for (int indice = 0; indice < jugador.getPokemonesActuales(); indice++) {
            Pokemon pokemon = jugador.getEquipoPokemon()[indice];
            registro.append("  ").append(pokemon.getApodo())
                    .append(" (").append(pokemon.getEspecie()).append(") Nv.")
                    .append(pokemon.getNivel())
                    .append(" HP Máx ").append(pokemon.getVidaMaxima()).append("\n");
        }
        registro.append("Estadísticas:\n");
        registro.append("  Batallas totales: ").append(partida.getEstadisticas().getBatallasTotales()).append("\n");
        registro.append("  Salvajes: ").append(partida.getEstadisticas().getBatallasSalvajes()).append("\n");
        registro.append("  Entrenadores: ").append(partida.getEstadisticas().getBatallasEntrenadores()).append("\n");
        registro.append("  Pokébolas lanzadas: ").append(partida.getEstadisticas().getPokebolasLanzadas()).append("\n");
        registro.append("  Capturas exitosas: ").append(partida.getEstadisticas().getCapturasExitosas()).append("\n");
        registro.append("  MVP: ").append(jugador.obtenerMvp().getApodo()).append("\n");
        registro.append("=====================================\n");

        gestorDeArchivos.registrarHall(registro.toString());
        System.out.println(Ansi.AMARILLO + "¡Has sido registrado en el Hall de la Fama!" + Ansi.RESET);
    }
}