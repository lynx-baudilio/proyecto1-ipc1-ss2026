package usac.cunoc.ipc1.poketerminal.catalogos;

import usac.cunoc.ipc1.poketerminal.modelos.Movimiento;

public class CatalogoMovimientos {

    private final Movimiento[] movimientos = new Movimiento[]{
        new Movimiento("Placaje", 35, "FISICO", "NINGUNO"),
        new Movimiento("Ataque rápido", 40, "FISICO", "PRIORIDAD"),
        new Movimiento("Picotazo venenoso", 20, "FISICO", "VENENO_15"),
        new Movimiento("Mordisco", 60, "FISICO", "NINGUNO"),
        new Movimiento("Ataque furia", 15, "FISICO", "MULTI_GOLPE"),
        new Movimiento("Picotazo", 40, "FISICO", "NINGUNO"),
        new Movimiento("Vuelo", 90, "FISICO", "DOS_TURNOS"),
        new Movimiento("Ataque Ala", 100, "FISICO", "NINGUNO"),
        new Movimiento("Doble filo", 100, "FISICO", "RECULO_20"),
        new Movimiento("Lanzallamas", 90, "FISICO", "QUEMADURA"),
        new Movimiento("Anillo Igneo", 120, "FISICO", "DESCANSO_SIGUIENTE"),
        new Movimiento("Rayo burbuja", 70, "FISICO", "BAJAR_VEL_5"),
        new Movimiento("Hidrocañón", 120, "FISICO", "DESCANSO_SIGUIENTE"),
        new Movimiento("Hoja afilada", 80, "FISICO", "NINGUNO"),
        new Movimiento("Rayo solar", 120, "FISICO", "CARGAR_TURNO"),
        new Movimiento("Atactrueno", 90, "FISICO", "NINGUNO"),
        new Movimiento("Impactrueno", 50, "FISICO", "PARALIZAR_15"),
        new Movimiento("Rayo", 100, "FISICO", "PARALIZAR_20"),
        new Movimiento("Giro fuego", 35, "FISICO", "ATRAPAR"),
        new Movimiento("Gruñido", 0, "ESTADO", "BAJAR_ATAQUE_20"),
        new Movimiento("Látigo", 0, "ESTADO", "BAJAR_DEFENSA_20"),
        new Movimiento("Disparo demora", 0, "ESTADO", "BAJAR_VEL_25"),
        new Movimiento("Fortaleza", 0, "ESTADO", "SUBIR_DEFENSA"),
        new Movimiento("Supersónico", 0, "ESTADO", "CONFUSION"),
        new Movimiento("Descanso", 0, "ESTADO", "CURAR_Y_DORMIR"),
        new Movimiento("Drenadoras", 0, "ESTADO", "DRENAR_7"),
        new Movimiento("Protección", 0, "ESTADO", "BLOQUEAR_70")
    };

    public Movimiento buscarPorNombre(String nombreMovimiento) {
        if (nombreMovimiento == null) {
            return movimientos[0];
        }
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getNombre().equalsIgnoreCase(nombreMovimiento.trim())) {
                return movimiento;
            }
        }
        return movimientos[0];
    }
}