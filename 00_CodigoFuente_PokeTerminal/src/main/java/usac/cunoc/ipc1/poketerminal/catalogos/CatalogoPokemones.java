package usac.cunoc.ipc1.poketerminal.catalogos;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.modelos.Movimiento;
import usac.cunoc.ipc1.poketerminal.modelos.Pokemon;

public class CatalogoPokemones {
    
    private final Random random = new Random();
    private final CatalogoMovimientos catalogoMovimientos = new CatalogoMovimientos();

    public Pokemon crearPokemon(int id, String apodo, int nivel) {
        switch (id) {
            case 1:
                return construirPokemon(1, "Bulbasaur", apodo, nivel, 30, 30, 30, 30, new String[]{"Placaje", "Gruñido", "Hoja afilada"});
            case 2:
                return construirPokemon(2, "Ivysaur", apodo, nivel, 40, 40, 40, 40, new String[]{"Descanso", "Drenadoras", "Hoja afilada"});
            case 3:
                return construirPokemon(3, "Venusaur", apodo, nivel, 50, 50, 50, 50, new String[]{"Drenadoras", "Hoja afilada", "Rayo solar"});
            case 4:
                return construirPokemon(4, "Charmander", apodo, nivel, 30, 40, 30, 40, new String[]{"Placaje", "Gruñido", "Giro fuego"});
            case 5:
                return construirPokemon(5, "Charmeleon", apodo, nivel, 40, 40, 40, 50, new String[]{"Doble filo", "Giro fuego", "Lanzallamas"});
            case 6:
                return construirPokemon(6, "Charizard", apodo, nivel, 50, 50, 50, 60, new String[]{"Giro fuego", "Lanzallamas", "Anillo Igneo"});
            case 7:
                return construirPokemon(7, "Squirtle", apodo, nivel, 30, 30, 40, 30, new String[]{"Placaje", "Látigo", "Rayo burbuja"});
            case 8:
                return construirPokemon(8, "Wartortle", apodo, nivel, 40, 40, 50, 40, new String[]{"Mordisco", "Protección", "Rayo burbuja"});
            case 9:
                return construirPokemon(9, "Blastoise", apodo, nivel, 50, 50, 60, 50, new String[]{"Mordisco", "Rayo burbuja", "Hidrocañon"});
            case 10:
                return construirPokemon(10, "Caterpie", apodo, nivel, 30, 20, 30, 30, new String[]{"Placaje", "Disparo demora"});
            case 11:
                return construirPokemon(11, "Metapod", apodo, nivel, 30, 20, 40, 20, new String[]{"Fortaleza"});
            case 12:
                return construirPokemon(12, "Butterfree", apodo, nivel, 40, 30, 30, 50, new String[]{"Disparo demora", "Fortaleza", "Supersónico"});
            case 13:
                return construirPokemon(13, "Weedle", apodo, nivel, 30, 30, 20, 30, new String[]{"Picotazo venenoso", "Disparo demora"});
            case 14:
                return construirPokemon(14, "Kakuna", apodo, nivel, 30, 20, 30, 30, new String[]{"Fortaleza"});
            case 15:
                return construirPokemon(15, "Beedrill", apodo, nivel, 40, 60, 30, 50, new String[]{"Ataque furia", "Fortaleza", "Picotazo"});
            case 16:
                return construirPokemon(16, "Pidgey", apodo, nivel, 30, 30, 30, 40, new String[]{"Placaje", "Gruñido"});
            case 17:
                return construirPokemon(17, "Pidgeotto", apodo, nivel, 40, 40, 40, 50, new String[]{"Placaje", "Gruñido", "Ataque Ala"});
            case 18:
                return construirPokemon(18, "Pidgeot", apodo, nivel, 50, 50, 50, 60, new String[]{"Vuelo", "Ataque Ala", "Doble filo"});
            case 19:
                return construirPokemon(19, "Rattata", apodo, nivel, 20, 40, 30, 50, new String[]{"Placaje", "Ataque rápido", "Látigo"});
            case 20:
                return construirPokemon(20, "Raticate", apodo, nivel, 40, 50, 40, 60, new String[]{"Mordisco", "Descanso"});
            case 21:
                return construirPokemon(21, "Spearow", apodo, nivel, 30, 40, 20, 50, new String[]{"Placaje", "Gruñido", "Ataque furia"});
            case 22:
                return construirPokemon(22, "Fearow", apodo, nivel, 40, 60, 40, 60, new String[]{"Ataque Ala", "Picotazo", "Doble filo"});
            case 23:
                return construirPokemon(23, "Ekans", apodo, nivel, 30, 40, 30, 40, new String[]{"Placaje", "Picotazo venenoso", "Mordisco"});
            case 24:
                return construirPokemon(24, "Arbok", apodo, nivel, 40, 60, 50, 50, new String[]{"Picotazo venenoso", "Mordisco", "Impactrueno"});
            case 25:
                return construirPokemon(25, "Pikachu", apodo, nivel, 30, 40, 30, 60, new String[]{"Atactrueno", "Impactrueno", "Rayo"});
            default:
                return construirPokemon(1, "Bulbasaur", apodo, nivel, 30, 30, 30, 30, new String[]{"Placaje", "Gruñido", "Hoja afilada"});
        }
    }

    private Pokemon construirPokemon(int id, String especie, String apodo, int nivel, int vidaBase, int ataqueBase, int defensaBase, int velocidadBase, String[] nombresDeMovimientos) {
        String apodoFinal = (apodo == null || apodo.trim().isEmpty()) ? especie : apodo;

        int vidaMax;
        int puntosAtaque;
        int puntosDefensa;
        int puntosVelocidad;

        if (nivel == 1) {
            vidaMax = vidaBase;
            puntosAtaque = ataqueBase;
            puntosDefensa = defensaBase;
            puntosVelocidad = velocidadBase;
        } else {
            vidaMax = calcularSalud(vidaBase, nivel);
            puntosAtaque = calcularEstadistica(ataqueBase, nivel);
            puntosDefensa = calcularEstadistica(defensaBase, nivel);
            puntosVelocidad = calcularEstadistica(velocidadBase, nivel);
        }

        Movimiento[] movimientos = obtenerMovimientos(nombresDeMovimientos);
        return new Pokemon(id, especie, apodoFinal, nivel, 0, vidaMax, vidaMax, puntosAtaque, puntosDefensa, puntosVelocidad, movimientos);
    }

    private int calcularEstadistica(int base, int nivel) {
        int v = random.nextInt(32); 
        return ((base + v) * 2 * nivel) / 100 + 5;
    }

    private int calcularSalud(int base, int nivel) {
        int v = random.nextInt(32); 
        return ((base + v) * 2 * nivel) / 100 + nivel + 10;
    }

    private Movimiento[] obtenerMovimientos(String[] nombres) {
        Movimiento[] movimientos = new Movimiento[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            movimientos[i] = catalogoMovimientos.buscarPorNombre(nombres[i]);
        }
        return movimientos;
    }
    
}