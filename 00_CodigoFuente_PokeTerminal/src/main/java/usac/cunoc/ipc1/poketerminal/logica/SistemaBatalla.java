package usac.cunoc.ipc1.poketerminal.logica;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.modelos.Jugador;
import usac.cunoc.ipc1.poketerminal.modelos.Movimiento;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;
import usac.cunoc.ipc1.poketerminal.utilidades.LeerEntrada;

public class SistemaBatalla {

    private final Random generadorAleatorio = new Random();
    private final LeerEntrada leerEntrada = new LeerEntrada();

    // ============================================================
    // BATALLA CONTRA POKÉMON SALVAJE
    // ============================================================
    public boolean iniciarBatallaSalvaje(Jugador jugador, Pokemon pokemonSalvaje) {
        System.out.println(Ansi.AMARILLO + "¡Un " + pokemonSalvaje.getEspecie()
                + " salvaje nivel " + pokemonSalvaje.getNivel() + " ha aparecido!" + Ansi.RESET);
        leerEntrada.enter();

        Pokemon pokemonActual = obtenerPrimerPokemonVivo(jugador);
        if (pokemonActual == null) {
            return false;
        }

        while (pokemonActual.getVidaActual() > 0 && pokemonSalvaje.getVidaActual() > 0) {
            mostrarEstadoCombate(pokemonActual, pokemonSalvaje.getEspecie(), pokemonSalvaje);

            String opcionElegida = leerEntrada.texto(
                    "[1] Atacar | [2] Usar objeto | [3] Cambiar | [4] Huir").trim();

            switch (opcionElegida) {
                case "1":
                    ejecutarAtaqueJugador(pokemonActual, pokemonSalvaje);
                    if (pokemonSalvaje.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonSalvaje, pokemonActual);
                    }
                    break;
                case "2":
                    if (usarObjetoEnBatalla(jugador, pokemonActual, pokemonSalvaje)) {
                        return true;
                    }
                    if (pokemonSalvaje.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonSalvaje, pokemonActual);
                    }
                    break;
                case "3":
                    Pokemon pokemonCambiado = cambiarPokemon(jugador);
                    if (pokemonCambiado != null) {
                        pokemonActual = pokemonCambiado;
                    }
                    if (pokemonSalvaje.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonSalvaje, pokemonActual);
                    }
                    break;
                case "4":
                    System.out.println("¡Escapaste con éxito!");
                    leerEntrada.enter();
                    return false;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            if (pokemonActual.getVidaActual() <= 0) {
                Pokemon siguientePokemon = obtenerPrimerPokemonVivo(jugador);
                if (siguientePokemon == null) {
                    System.out.println(Ansi.ROJO + "¡Todos tus Pokémon han sido debilitados!" + Ansi.RESET);
                    jugador.pagarMitadDinero();
                    jugador.curarEquipo();
                    leerEntrada.enter();
                    return false;
                }
                pokemonActual = siguientePokemon;
            }
        }

        if (pokemonSalvaje.getVidaActual() <= 0) {
            int experienciaObtenida = Formulas.experienciaGanada(pokemonSalvaje.getNivel());
            System.out.println("¡Derrotaste al " + pokemonSalvaje.getEspecie() + "!");
            System.out.println(pokemonActual.ganarExperiencia(experienciaObtenida, generadorAleatorio));
            pokemonActual.registrarDebilitamiento();
            leerEntrada.enter();
        }
        return true;
    }

    // ============================================================
    // BATALLA CONTRA ENTRENADOR
    // ============================================================
    public boolean iniciarBatallaEntrenador(Jugador jugador, Pokemon[] equipoRival, String nombreEntrenador) {
        System.out.println(Ansi.ROJO + "¡" + nombreEntrenador + " quiere combatir!" + Ansi.RESET);
        leerEntrada.enter();

        Pokemon pokemonActual = obtenerPrimerPokemonVivo(jugador);
        if (pokemonActual == null) {
            return false;
        }

        int indiceRival = 0;
        Pokemon pokemonRival = buscarSiguientePokemonVivo(equipoRival, indiceRival);
        if (pokemonRival == null) {
            return true;
        }

        while (pokemonActual.getVidaActual() > 0 && pokemonRival != null) {
            mostrarEstadoCombate(pokemonActual, pokemonRival.getEspecie(), pokemonRival);

            String opcionElegida = leerEntrada.texto(
                    "[1] Atacar | [2] Usar objeto | [3] Cambiar").trim();

            switch (opcionElegida) {
                case "1":
                    ejecutarAtaqueJugador(pokemonActual, pokemonRival);
                    if (pokemonRival.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonRival, pokemonActual);
                    }
                    break;
                case "2":
                    usarObjetoEnBatalla(jugador, pokemonActual, null);
                    if (pokemonRival.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonRival, pokemonActual);
                    }
                    break;
                case "3":
                    Pokemon pokemonCambiado = cambiarPokemon(jugador);
                    if (pokemonCambiado != null) {
                        pokemonActual = pokemonCambiado;
                    }
                    if (pokemonRival.getVidaActual() > 0) {
                        ejecutarAtaqueEnemigo(pokemonRival, pokemonActual);
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            if (pokemonActual.getVidaActual() <= 0) {
                Pokemon siguientePokemon = obtenerPrimerPokemonVivo(jugador);
                if (siguientePokemon == null) {
                    System.out.println(Ansi.ROJO + "¡Fuiste derrotado!" + Ansi.RESET);
                    jugador.pagarMitadDinero();
                    jugador.curarEquipo();
                    leerEntrada.enter();
                    return false;
                }
                pokemonActual = siguientePokemon;
            }

            if (pokemonRival.getVidaActual() <= 0) {
                int experienciaObtenida = Formulas.experienciaGanada(pokemonRival.getNivel());
                System.out.println(pokemonActual.ganarExperiencia(experienciaObtenida, generadorAleatorio));
                pokemonActual.registrarDebilitamiento();
                indiceRival = indiceRival + 1;
                pokemonRival = buscarSiguientePokemonVivo(equipoRival, indiceRival);
            }
        }

        int premioDinero = generadorAleatorio.nextInt(351) + 150;
        jugador.agregarDinero(premioDinero);
        System.out.println(Ansi.VERDE + "¡Ganaste! Recibes ₱" + premioDinero + Ansi.RESET);
        leerEntrada.enter();
        return true;
    }

    private Pokemon buscarSiguientePokemonVivo(Pokemon[] equipo, int indiceInicial) {
        for (int indice = indiceInicial; indice < equipo.length; indice++) {
            if (equipo[indice] != null && equipo[indice].getVidaActual() > 0) {
                return equipo[indice];
            }
        }
        return null;
    }

    private void mostrarEstadoCombate(Pokemon pokemonJugador, String especieRival, Pokemon pokemonRival) {
        System.out.println("\n--- " + pokemonJugador.getApodo() + " HP: "
                + pokemonJugador.getVidaActual() + "/" + pokemonJugador.getVidaMaxima()+ " ---");
        System.out.println("--- " + especieRival + " HP: "
                + pokemonRival.getVidaActual() + "/" + pokemonRival.getVidaMaxima()+ " ---");
    }

    // ============================================================
    // ATAQUES
    // ============================================================
    private void ejecutarAtaqueJugador(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        Movimiento[] movimientosDisponibles = pokemonAtacante.getMovimientos();
        System.out.println("Movimientos disponibles:");
        for (int indice = 0; indice < movimientosDisponibles.length; indice++) {
            System.out.println("  [" + (indice + 1) + "] "
                    + movimientosDisponibles[indice].getNombre()
                    + " (Pot: " + movimientosDisponibles[indice].getPotencia() + ")");
        }

        int indiceMovimiento;
        try {
            indiceMovimiento = Integer.parseInt(
                    leerEntrada.texto("Selecciona un movimiento").trim()) - 1;
        } catch (NumberFormatException excepcion) {
            indiceMovimiento = 0;
        }
        if (indiceMovimiento < 0 || indiceMovimiento >= movimientosDisponibles.length) {
            indiceMovimiento = 0;
        }

        Movimiento movimientoElegido = movimientosDisponibles[indiceMovimiento];
        int variacionAleatoria = generadorAleatorio.nextInt(16) + 85;
        int danioInfligido = Formulas.calcularDanio(
                variacionAleatoria,
                pokemonAtacante.getNivel(),
                pokemonAtacante.getPuntosAtaque(),
                Math.max(movimientoElegido.getPotencia(), 1),
                pokemonDefensor.getPuntosDefensa()
        );
        pokemonDefensor.recibirDanio(danioInfligido);
        System.out.println(pokemonAtacante.getApodo() + " usó " + movimientoElegido.getNombre()
                + " e infligió " + danioInfligido + " de daño.");

        if ("Doble filo".equals(movimientoElegido.getNombre())) {
            int danioRetroceso = danioInfligido / 5;
            pokemonAtacante.recibirDanio(danioRetroceso);
            System.out.println(pokemonAtacante.getApodo() + " sufrió "
                    + danioRetroceso + " de daño por retroceso.");
        }

        String efectoMovimiento = movimientoElegido.getEfecto();
        if (efectoMovimiento != null && efectoMovimiento.contains("PARALIZAR")) {
            int probabilidadParalizar = efectoMovimiento.contains("15") ? 15 : 20;
            if (generadorAleatorio.nextInt(100) < probabilidadParalizar) {
                pokemonDefensor.setTurnosParalizado(2);
                System.out.println(pokemonDefensor.getApodo() + " quedó paralizado!");
            }
        }
        if (efectoMovimiento != null && efectoMovimiento.contains("VENENO")) {
            if (generadorAleatorio.nextInt(100) < 15) {
                pokemonDefensor.setEnvenenado(true);
                System.out.println(pokemonDefensor.getApodo() + " quedó envenenado!");
            }
        }
    }

    private void ejecutarAtaqueEnemigo(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        if (pokemonAtacante.getTurnosParalizado() > 0 || pokemonAtacante.getTurnosDormido() > 0) {
            pokemonAtacante.reducirContadoresEstado();
            System.out.println(pokemonAtacante.getApodo() + " no puede moverse.");
            return;
        }

        Movimiento[] movimientosDisponibles = pokemonAtacante.getMovimientos();
        Movimiento movimientoElegido = movimientosDisponibles[generadorAleatorio.nextInt(movimientosDisponibles.length)];

        int variacionAleatoria = generadorAleatorio.nextInt(16) + 85;
        int danioInfligido = Formulas.calcularDanio(
                variacionAleatoria,
                pokemonAtacante.getNivel(),
                pokemonAtacante.getPuntosAtaque(),
                Math.max(movimientoElegido.getPotencia(), 1),
                pokemonDefensor.getPuntosDefensa()
        );
        pokemonDefensor.recibirDanio(danioInfligido);
        System.out.println(pokemonAtacante.getApodo() + " usó " + movimientoElegido.getNombre()
                + " e infligió " + danioInfligido + " de daño.");

        if (pokemonAtacante.estaEnvenenado()) {
            int danioVeneno = Formulas.porcentajeEntero(pokemonAtacante.getVidaMaxima(), 8);
            pokemonAtacante.recibirDanio(danioVeneno);
            System.out.println(pokemonAtacante.getApodo() + " sufre "
                    + danioVeneno + " de daño por veneno.");
        }
    }

    // ============================================================
    // OBJETOS Y CAMBIO DE POKÉMON
    // ============================================================
    private boolean usarObjetoEnBatalla(Jugador jugador, Pokemon pokemonActual, Pokemon pokemonSalvaje) {
        System.out.println("Mochila:");
        jugador.getMochila().listar();
        String opcionElegida = leerEntrada.texto(
                "[P]okébola | [C] Poción | [X] Cancelar").toLowerCase().trim();

        if (opcionElegida.equals("x")) {
            return false;
        }

        if (opcionElegida.equals("p") && pokemonSalvaje != null) {
            if (jugador.equipoLleno()) {
                System.out.println("Tu equipo está lleno.");
                leerEntrada.enter();
                return false;
            }
            if (!jugador.getMochila().usarPokebola()) {
                System.out.println("No tienes Pokébolas.");
                leerEntrada.enter();
                return false;
            }
            int numeroAleatorio = generadorAleatorio.nextInt(pokemonSalvaje.getVidaMaxima() + 1);
            if (numeroAleatorio > pokemonSalvaje.getVidaActual()) {
                System.out.println("¡Capturaste a " + pokemonSalvaje.getEspecie() + "!");
                String apodoNuevo = leerEntrada.texto("Apodo (ENTER para omitir):");
                if (!apodoNuevo.trim().isEmpty()) {
                    pokemonSalvaje.setApodo(apodoNuevo);
                }
                jugador.agregarPokemon(pokemonSalvaje);
                leerEntrada.enter();
                return true;
            } else {
                System.out.println("¡El Pokémon escapó de la Pokébola!");
                leerEntrada.enter();
            }
        } else if (opcionElegida.equals("c")) {
            if (jugador.getMochila().usarPocion()) {
                pokemonActual.curar(20);
                System.out.println(pokemonActual.getApodo() + " recuperó 20 HP.");
            } else {
                System.out.println("No tienes pociones.");
            }
            leerEntrada.enter();
        }
        return false;
    }

    private Pokemon cambiarPokemon(Jugador jugador) {
        Pokemon[] equipoPokemon = jugador.getEquipoPokemon();
        System.out.println("Elige un Pokémon:");
        for (int indice = 0; indice < jugador.getPokemonesActuales(); indice++) {
            System.out.println("  [" + (indice + 1) + "] " + equipoPokemon[indice].lineaEquipo());
        }
        try {
            int indiceSeleccionado = Integer.parseInt(leerEntrada.texto("Opción").trim()) - 1;
            if (indiceSeleccionado >= 0 && indiceSeleccionado < jugador.getPokemonesActuales()
                    && equipoPokemon[indiceSeleccionado].getVidaActual() > 0) {
                return equipoPokemon[indiceSeleccionado];
            }
        } catch (NumberFormatException excepcion) {
            return null;
        }
        return null;
    }

    private Pokemon obtenerPrimerPokemonVivo(Jugador jugador) {
        for (Pokemon pokemon : jugador.getEquipoPokemon()) {
            if (pokemon != null && pokemon.getVidaActual() > 0) {
                return pokemon;
            }
        }
        return null;
    }
}