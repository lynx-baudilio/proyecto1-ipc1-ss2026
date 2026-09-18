package usac.cunoc.ipc1.poketerminal.catalogos;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.modelos.Medalla;

public class CatalogoNPCs {

    private static final String[] NOMBRES_GIMNASIOS = {
        "Gimnasio Roca", "Gimnasio Agua", "Gimnasio Planta",
        "Gimnasio Fuego", "Gimnasio Eléctrico", "Gimnasio Psíquico"
    };

    private static final String[] NOMBRES_LIDERES = {
        "Brock", "Misty", "Erika", "Blaine", "Lt. Surge", "Sabrina",
        "Giovanni", "Koga", "Bruno", "Lorelei"
    };

    private static final String[] NOMBRES_ENTRENADORES = {
        "Joven Pedro", "Chica Ana", "Pescador Luis", "Cazabichos Juan",
        "Domador Carlos", "Mecánico Sofía", "Coleccionista Mara",
        "Deportista Hugo", "Psíquico Iván", "Marinero Diego",
        "Científico Elena", "Luchador Marco"
    };

    private static final String[] NOMBRES_MEDALLAS = {
        "Medalla Roca", "Medalla Cascada", "Medalla Trueno",
        "Medalla Arcoíris", "Medalla Alma", "Medalla Pantano",
        "Medalla Volcán", "Medalla Tierra"
    };

    private static final String[] ICONOS_MEDALLAS = {"♦", "★", "●", "▲", "■", "♥", "♣", "♠"};

    private final Random generadorAleatorio = new Random();

    public String[] obtenerGimnasiosUnicos(int cantidad) {
        return obtenerElementosUnicos(NOMBRES_GIMNASIOS, cantidad);
    }

    public String[] obtenerLideresUnicos(int cantidad) {
        return obtenerElementosUnicos(NOMBRES_LIDERES, cantidad);
    }

    public String[] obtenerEntrenadoresUnicos(int cantidad) {
        return obtenerElementosUnicos(NOMBRES_ENTRENADORES, cantidad);
    }

    public Medalla[] obtenerMedallasUnicas(int cantidad) {
        String[] nombresSeleccionados = obtenerElementosUnicos(NOMBRES_MEDALLAS, cantidad);
        String[] iconosSeleccionados = obtenerElementosUnicos(ICONOS_MEDALLAS, cantidad);
        Medalla[] medallas = new Medalla[cantidad];
        for (int indice = 0; indice < cantidad; indice++) {
            medallas[indice] = new Medalla(
                    nombresSeleccionados[indice], iconosSeleccionados[indice], "");
        }
        return medallas;
    }

    private String[] obtenerElementosUnicos(String[] fuente, int cantidad) {
        String[] elementosSeleccionados = new String[cantidad];
        boolean[] elementosUsados = new boolean[fuente.length];
        int contadorSeleccionados = 0;
        while (contadorSeleccionados < cantidad) {
            int indiceAleatorio = generadorAleatorio.nextInt(fuente.length);
            if (!elementosUsados[indiceAleatorio]) {
                elementosSeleccionados[contadorSeleccionados] = fuente[indiceAleatorio];
                elementosUsados[indiceAleatorio] = true;
                contadorSeleccionados = contadorSeleccionados + 1;
            }
        }
        return elementosSeleccionados;
    }
}