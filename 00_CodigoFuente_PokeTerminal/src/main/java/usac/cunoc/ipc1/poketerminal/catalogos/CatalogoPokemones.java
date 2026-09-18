package usac.cunoc.ipc1.poketerminal.catalogos;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.modelos.Especie;
import usac.cunoc.ipc1.poketerminal.modelos.Movimiento;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;

public class CatalogoPokemones {

    private final Random generadorAleatorio = new Random();
    private final CatalogoMovimientos catalogoMovimientos = new CatalogoMovimientos();

    private static final Especie[] ESPECIES = {
        new Especie(1, "Bulbasaur", 30, 30, 30, 30, new String[]{"Placaje", "Gruñido", "Hoja afilada"}),
        new Especie(2, "Ivysaur", 40, 40, 40, 40, new String[]{"Descanso", "Drenadoras", "Hoja afilada"}),
        new Especie(3, "Venusaur", 50, 50, 50, 50, new String[]{"Drenadoras", "Hoja afilada", "Rayo solar"}),
        new Especie(4, "Charmander", 30, 40, 30, 40, new String[]{"Placaje", "Gruñido", "Giro fuego"}),
        new Especie(5, "Charmeleon", 40, 40, 40, 50, new String[]{"Doble filo", "Giro fuego", "Lanzallamas"}),
        new Especie(6, "Charizard", 50, 50, 50, 60, new String[]{"Giro fuego", "Lanzallamas", "Anillo Igneo"}),
        new Especie(7, "Squirtle", 30, 30, 40, 30, new String[]{"Placaje", "Látigo", "Rayo burbuja"}),
        new Especie(8, "Wartortle", 40, 40, 50, 40, new String[]{"Mordisco", "Protección", "Rayo burbuja"}),
        new Especie(9, "Blastoise", 50, 50, 60, 50, new String[]{"Mordisco", "Rayo burbuja", "Hidrocañón"}),
        new Especie(10, "Caterpie", 30, 20, 30, 30, new String[]{"Placaje", "Disparo demora"}),
        new Especie(11, "Metapod", 30, 20, 40, 20, new String[]{"Fortaleza"}),
        new Especie(12, "Butterfree", 40, 30, 30, 50, new String[]{"Disparo demora", "Fortaleza", "Supersónico"}),
        new Especie(13, "Weedle", 30, 30, 20, 30, new String[]{"Picotazo venenoso", "Disparo demora"}),
        new Especie(14, "Kakuna", 30, 20, 30, 30, new String[]{"Fortaleza"}),
        new Especie(15, "Beedrill", 40, 60, 30, 50, new String[]{"Ataque furia", "Fortaleza", "Picotazo"}),
        new Especie(16, "Pidgey", 30, 30, 30, 40, new String[]{"Placaje", "Gruñido"}),
        new Especie(17, "Pidgeotto", 40, 40, 40, 50, new String[]{"Placaje", "Gruñido", "Ataque Ala"}),
        new Especie(18, "Pidgeot", 50, 50, 50, 60, new String[]{"Vuelo", "Ataque Ala", "Doble filo"}),
        new Especie(19, "Rattata", 20, 40, 30, 50, new String[]{"Placaje", "Ataque rápido", "Látigo"}),
        new Especie(20, "Raticate", 40, 50, 40, 60, new String[]{"Mordisco", "Descanso"}),
        new Especie(21, "Spearow", 30, 40, 20, 50, new String[]{"Placaje", "Gruñido", "Ataque furia"}),
        new Especie(22, "Fearow", 40, 60, 40, 60, new String[]{"Ataque Ala", "Picotazo", "Doble filo"}),
        new Especie(23, "Ekans", 30, 40, 30, 40, new String[]{"Placaje", "Picotazo venenoso", "Mordisco"}),
        new Especie(24, "Arbok", 40, 60, 50, 50, new String[]{"Picotazo venenoso", "Mordisco", "Impactrueno"}),
        new Especie(25, "Pikachu", 30, 40, 30, 60, new String[]{"Atactrueno", "Impactrueno", "Rayo"})
    };

    public Pokemon crearPokemon(int identificadorEspecie, String apodo, int nivel) {
        Especie especie = buscarEspecie(identificadorEspecie);
        if (especie == null) {
            especie = ESPECIES[0];
        }
        String apodoFinal = (apodo == null || apodo.trim().isEmpty()) ? especie.getNombre() : apodo;

        int puntosVida;
        int puntosAtaque;
        int puntosDefensa;
        int puntosVelocidad;

        if (nivel <= 1) {
            puntosVida = especie.getBaseSalud();
            puntosAtaque = especie.getBaseAtaque();
            puntosDefensa = especie.getBaseDefensa();
            puntosVelocidad = especie.getBaseVelocidad();
        } else {
            puntosVida = calcularEstadistica(especie.getBaseSalud(), nivel) + nivel + 10;
            puntosAtaque = calcularEstadistica(especie.getBaseAtaque(), nivel);
            puntosDefensa = calcularEstadistica(especie.getBaseDefensa(), nivel);
            puntosVelocidad = calcularEstadistica(especie.getBaseVelocidad(), nivel);
        }

        String[] nombresMovimientos = especie.getNombresMovimientos();
        Movimiento[] movimientosPokemon = new Movimiento[nombresMovimientos.length];
        for (int indice = 0; indice < nombresMovimientos.length; indice++) {
            movimientosPokemon[indice] = catalogoMovimientos.buscarPorNombre(nombresMovimientos[indice]);
        }

        return new Pokemon(
                generadorAleatorio.nextInt(100000) + 1,
                especie.getNumero(),
                especie.getNombre(),
                apodoFinal,
                nivel,
                0,
                puntosVida,
                puntosVida,
                puntosAtaque,
                puntosDefensa,
                puntosVelocidad,
                especie.getBaseSalud(),
                especie.getBaseAtaque(),
                especie.getBaseDefensa(),
                especie.getBaseVelocidad(),
                movimientosPokemon
        );
    }

    private int calcularEstadistica(int valorBase, int nivel) {
        int variacionAleatoria = generadorAleatorio.nextInt(32);
        return ((valorBase + variacionAleatoria) * 2 * nivel) / 100 + 5;
    }

    public Especie buscarEspecie(int identificador) {
        for (Especie especie : ESPECIES) {
            if (especie.getNumero() == identificador) {
                return especie;
            }
        }
        return null;
    }

    public Especie[] getEspecies() {
        return ESPECIES;
    }

    public void listarEspecies(String filtroBusqueda) {
        String filtroNormalizado = (filtroBusqueda == null) ? "" : filtroBusqueda.toLowerCase().trim();
        for (Especie especie : ESPECIES) {
            if (filtroNormalizado.isEmpty()
                    || especie.getNombre().toLowerCase().contains(filtroNormalizado)) {
                System.out.printf("#%02d %-12s HP:%d ATK:%d DEF:%d VEL:%d%n",
                        especie.getNumero(),
                        especie.getNombre(),
                        especie.getBaseSalud(),
                        especie.getBaseAtaque(),
                        especie.getBaseDefensa(),
                        especie.getBaseVelocidad());
            }
        }
    }
}
