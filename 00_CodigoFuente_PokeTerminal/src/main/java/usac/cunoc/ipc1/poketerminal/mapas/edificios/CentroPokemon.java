package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.utilidades.GestorDeArchivos;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class CentroPokemon extends Edificio {
    
    private final LeerEntrada leerEntrada = new LeerEntrada();
    private final GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
    
    public CentroPokemon() {
        super(6, 23);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return edificio.getCENTRO();
    }

    @Override
    public void abrir(Partida partida) {
        boolean dentroDelCentro = true;
        while (dentroDelCentro) {
            Ansi ansi = new Ansi();
            ansi.limpiarPantalla();
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╔════════════════════════════════════════════╗" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "║" + Ansi.ROJO + "           CENTRO POKÉMON                    " + Ansi.BLANCO + "║" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╠════════════════════════════════════════════╣" + Ansi.RESET);
            System.out.println("║   [E] Enfermera Joy     [T] Televisión      ║");
            System.out.println("║                                             ║");
            System.out.println("║   [Q] Salir al mapa de la ciudad             ║");
            System.out.println("╚════════════════════════════════════════════╝");

            String opcionElegida = leerEntrada.texto(
                    "[E] Hablar con Enfermera Joy | [T] Ver Televisión | [Q] Salir"
            ).toLowerCase().trim();

            switch (opcionElegida) {
                case "e":
                    partida.getJugador().curarEquipo();
                    System.out.println(Ansi.VERDE + "Enfermera Joy: ¡Tus Pokémon están completamente sanos!" + Ansi.RESET);
                    leerEntrada.enter();
                    break;
                case "t":
                    ansi.limpiarPantalla();
                    System.out.println(Ansi.NEGRITA + Ansi.CYAN + "=== HALL DE LA FAMA ===" + Ansi.RESET);
                    gestorDeArchivos.mostrarHall();
                    leerEntrada.enter();
                    break;
                case "q":
                    dentroDelCentro = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    leerEntrada.enter();
            }
        }
    }
}