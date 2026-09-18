package usac.cunoc.ipc1.poketerminal.mapas;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.CentroPokemon;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.Edificio;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.GimnasioPokemon;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.TiendaPokemon;
import usac.cunoc.ipc1.poketerminal.modelos.Gimnasio;
import usac.cunoc.ipc1.poketerminal.modelos.Posicion;
import usac.cunoc.ipc1.poketerminal.ui.Ansi;

public class MapaCiudad extends Mapa {

    private static final int[][] ZONAS_DISPONIBLES = {
        {3, 4}, {3, 45}, {12, 4}, {12, 45}
    };

    private String nombreCiudad;
    private Gimnasio gimnasio;
    private CentroPokemon centroPokemon;
    private TiendaPokemon tiendaPokemon;
    private GimnasioPokemon gimnasioPokemon;
    private final Random generadorAleatorio = new Random();

    public MapaCiudad(String nombreCiudad, Gimnasio gimnasio) {
        super(22, 70);
        this.nombreCiudad = nombreCiudad;
        this.gimnasio = gimnasio;
        colocarEdificiosAleatorios();
        generarZonasDeHierbaAlta();
        colocarDecoracionesAleatorias();
    }

    private void colocarEdificiosAleatorios() {
        Edificio[] edificiosAColocar = {
            new CentroPokemon(),
            new GimnasioPokemon(),
            new TiendaPokemon()
        };

        boolean[] zonasOcupadas = new boolean[ZONAS_DISPONIBLES.length];

        for (Edificio edificio : edificiosAColocar) {
            boolean edificioColocado = false;
            int intentosRealizados = 0;

            while (!edificioColocado && intentosRealizados < 200) {
                intentosRealizados = intentosRealizados + 1;
                int indiceZona = generadorAleatorio.nextInt(ZONAS_DISPONIBLES.length);

                if (!zonasOcupadas[indiceZona]) {
                    int filaInicial = ZONAS_DISPONIBLES[indiceZona][0];
                    int columnaInicial = ZONAS_DISPONIBLES[indiceZona][1];

                    if (puedeColocarEdificio(filaInicial, columnaInicial,
                            edificio.getAlto(), edificio.getAncho())) {
                        edificio.estamparEdificioEnMapa(filaInicial, columnaInicial, cuadricula);
                        zonasOcupadas[indiceZona] = true;
                        edificioColocado = true;

                        if (edificio instanceof CentroPokemon) {
                            this.centroPokemon = (CentroPokemon) edificio;
                        } else if (edificio instanceof TiendaPokemon) {
                            this.tiendaPokemon = (TiendaPokemon) edificio;
                        } else if (edificio instanceof GimnasioPokemon) {
                            this.gimnasioPokemon = (GimnasioPokemon) edificio;
                        }
                    }
                }
            }
        }
    }

    private boolean puedeColocarEdificio(int filaInicial, int columnaInicial, int alto, int ancho) {
        if (filaInicial - 1 < 1 || filaInicial + alto >= filas - 1) {
            return false;
        }
        if (columnaInicial - 1 < 1 || columnaInicial + ancho >= columnas - 1) {
            return false;
        }
        for (int fila = filaInicial - 1; fila <= filaInicial + alto; fila++) {
            for (int columna = columnaInicial - 1; columna <= columnaInicial + ancho; columna++) {
                if (!cuadricula[fila][columna].contains("·")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void generarZonasDeHierbaAlta() {
        int bloquesHierbaColocados = 0;
        int intentosRealizados = 0;

        while (bloquesHierbaColocados < 2 && intentosRealizados < 500) {
            intentosRealizados = intentosRealizados + 1;
            int filaInicial = generadorAleatorio.nextInt(filas - 6) + 1;
            int columnaInicial = generadorAleatorio.nextInt(columnas - 9) + 1;

            if (esAreaLimpia(filaInicial, columnaInicial, 3, 6)) {
                for (int fila = filaInicial; fila < filaInicial + 3; fila++) {
                    for (int columna = columnaInicial; columna < columnaInicial + 6; columna++) {
                        cuadricula[fila][columna] = Ansi.VERDE + "¥" + Ansi.RESET;
                    }
                }
                bloquesHierbaColocados = bloquesHierbaColocados + 1;
            }
        }
    }

    private boolean esAreaLimpia(int filaInicial, int columnaInicial, int alto, int ancho) {
        for (int fila = filaInicial - 2; fila < filaInicial + alto + 2; fila++) {
            for (int columna = columnaInicial - 2; columna < columnaInicial + ancho + 2; columna++) {
                if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas
                        || !cuadricula[fila][columna].contains("·")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void colocarDecoracionesAleatorias() {
        colocarSimboloDecorativo(Ansi.VERDE + "♣" + Ansi.RESET, 24);
        colocarSimboloDecorativo(Ansi.GRIS + "●" + Ansi.RESET, 12);
        colocarSimboloDecorativo(Ansi.CYAN + "≈" + Ansi.RESET, 16);
    }

    private void colocarSimboloDecorativo(String simbolo, int cantidadDeseada) {
        int simbolosColocados = 0;
        int intentosRealizados = 0;

        while (simbolosColocados < cantidadDeseada && intentosRealizados < 500) {
            intentosRealizados = intentosRealizados + 1;
            int fila = generadorAleatorio.nextInt(filas - 4) + 2;
            int columna = generadorAleatorio.nextInt(columnas - 4) + 2;

            if (esCasillaSeguraParaDecoracion(fila, columna)) {
                cuadricula[fila][columna] = simbolo;
                simbolosColocados = simbolosColocados + 1;
            }
        }
    }

    private boolean esCasillaSeguraParaDecoracion(int fila, int columna) {
        for (int filaActual = fila - 2; filaActual <= fila + 2; filaActual++) {
            for (int columnaActual = columna - 2; columnaActual <= columna + 2; columnaActual++) {
                if (filaActual >= 0 && filaActual < filas
                        && columnaActual >= 0 && columnaActual < columnas
                        && !cuadricula[filaActual][columnaActual].contains("·")) {
                    return false;
                }
            }
        }
        return true;
    }

    public Posicion generarPosicionJugadorValida() {
        while (true) {
            int fila = generadorAleatorio.nextInt(filas - 2) + 1;
            int columna = generadorAleatorio.nextInt(columnas - 2) + 1;
            if (cuadricula[fila][columna].contains("·")) {
                return new Posicion(fila, columna);
            }
        }
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public CentroPokemon getCentroPokemon() {
        return centroPokemon;
    }

    public TiendaPokemon getTiendaPokemon() {
        return tiendaPokemon;
    }

    public GimnasioPokemon getGimnasioPokemon() {
        return gimnasioPokemon;
    }
}