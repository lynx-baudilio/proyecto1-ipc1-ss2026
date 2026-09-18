package usac.cunoc.ipc1.poketerminal.mapas.edificios;

import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class TiendaPokemon extends Edificio{
    
    private final LeerEntrada leerEntrada = new LeerEntrada();

    public TiendaPokemon() {
        super(5, 19);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return edificio.getTIENDA();
    }   

    @Override
    public void abrir(Partida partida) {
        boolean dentroDeLaTienda = true;
        while (dentroDeLaTienda) {
            Ansi ansi = new Ansi();
            ansi.limpiarPantalla();
            Jugador jugador = partida.getJugador();

            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╔════════════════════════════════════════════╗" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "║" + Ansi.AZUL + "           TIENDA POKÉMON                    " + Ansi.BLANCO + "║" + Ansi.RESET);
            System.out.println(Ansi.NEGRITA + Ansi.BLANCO + "╠════════════════════════════════════════════╣" + Ansi.RESET);
            System.out.println("Vendedor: ¡Bienvenido! Tienes ₱" + jugador.getPokemonedas());
            System.out.println("[1] Pokébola      ₱200");
            System.out.println("[2] Poción        ₱300  (restaura 20 HP)");
            System.out.println("[3] Superpoción   ₱600  (restaura 50 HP)");
            System.out.println("[4] Antídoto      ₱100  (cura envenenado)");
            System.out.println("[5] Antiparaliz   ₱200  (cura paralizado)");
            System.out.println("[6] Restaura todo ₱700  (restaura todo)");
            System.out.println("[Q] Salir");
            System.out.println("╚════════════════════════════════════════════╝");

            String opcionElegida = leerEntrada.texto("Opción").toLowerCase().trim();

            switch (opcionElegida) {
                case "1":
                    if (jugador.gastar(200)) {
                        jugador.getMochila().agregarPokebolas(1);
                        System.out.println("¡Compraste una Pokébola!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "2":
                    if (jugador.gastar(300)) {
                        jugador.getMochila().agregarPociones(1);
                        System.out.println("¡Compraste una Poción!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "3":
                    if (jugador.gastar(600)) {
                        jugador.getMochila().agregarSuperPociones(1);
                        System.out.println("¡Compraste una Superpoción!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "4":
                    if (jugador.gastar(100)) {
                        jugador.getMochila().agregarAntidotos(1);
                        System.out.println("¡Compraste un Antídoto!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "5":
                    if (jugador.gastar(200)) {
                        jugador.getMochila().agregarAntiparaliz(1);
                        System.out.println("¡Compraste un Antiparaliz!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "6":
                    if (jugador.gastar(700)) {
                        jugador.getMochila().agregarRestauraTodo(1);
                        System.out.println("¡Compraste un Restaura todo!");
                    } else {
                        System.out.println("No tienes suficiente dinero.");
                    }
                    leerEntrada.enter();
                    break;
                case "q":
                    dentroDeLaTienda = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    leerEntrada.enter();
            }
        }
    }
}