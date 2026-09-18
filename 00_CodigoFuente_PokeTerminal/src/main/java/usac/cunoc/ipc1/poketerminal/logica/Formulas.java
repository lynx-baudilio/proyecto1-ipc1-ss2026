package usac.cunoc.ipc1.poketerminal.logica;

public final class Formulas {

    private Formulas() {
    }

    public static int incrementoEstadistica(int base, int variacion, int nivel) {
        return ((base + variacion) * 2 * nivel) / 100 + 5;
    }

    public static int incrementoSalud(int base, int variacion, int nivel) {
        return ((base + variacion) * 2 * nivel) / 100 + nivel + 10;
    }

    public static int calcularDanio(int variacion, int nivel, int ataque, int potencia, int defensa) {
        int defensaSegura = defensa < 1 ? 1 : defensa;
        int ataqueSeguro = ataque < 1 ? 1 : ataque;
        double factorInterno = (((0.2 * nivel) + 1.0) * ataqueSeguro * potencia)
                / (25.0 * defensaSegura) + 2.0;
        int danioCalculado = (int) Math.floor(0.01 * variacion * factorInterno);
        return Math.max(danioCalculado, 1);
    }

    public static int experienciaGanada(int nivelOponente) {
        int experiencia = (nivelOponente * nivelOponente) / 2;
        return Math.max(experiencia, 1);
    }

    public static int experienciaRequerida(int proximoNivel) {
        return proximoNivel * proximoNivel;
    }

    public static int nivelGenerado(int sumaNiveles, int cantidadPokemones, double multiplicador) {
        if (cantidadPokemones <= 0) {
            return 1;
        }
        int nivelCalculado = (int) Math.floor((sumaNiveles * multiplicador) / cantidadPokemones);
        return Math.max(nivelCalculado, 1);
    }

    public static int porcentajeEntero(int total, int porcentaje) {
        int valorCalculado = (total * porcentaje) / 100;
        if (valorCalculado < 1 && total > 0 && porcentaje > 0) {
            return 1;
        }
        return valorCalculado;
    }
}