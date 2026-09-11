package usac.cunoc.ipc1.poketerminal.mapas;

import java.util.Random;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.CentroPokemon;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.Edificio;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.GimnasioPokemon;
import usac.cunoc.ipc1.poketerminal.mapas.edificios.TiendaPokemon;

public class MapaCiudad extends Mapa{
    
    private String nombreCiudad;
    
    private Random random = new Random();
    
    public MapaCiudad(String nombreCiudad) {
        super(26, 100);
        this.nombreCiudad = nombreCiudad;
        colocarEdificiosAleatorios();
    }

    private void colocarEdificiosAleatorios() {
        
        Edificio[] listaEdificios = new Edificio[] {
            new CentroPokemon(),
            new GimnasioPokemon(),
            new TiendaPokemon()
        };
        
        for (int i = 0; i < listaEdificios.length; i++) {
            Edificio edificio = listaEdificios[i];
            boolean colocado = false;
            
            while (!colocado) {                
                int filaRandom = random.nextInt(filas);
                int columnaRandom = random.nextInt(columnas);
                
                if (puedeColocarEdificio(filaRandom, columnaRandom, edificio.getAlto(), edificio.getAncho())) {
                    edificio.estamparEdificioEnMapa(filaRandom, columnaRandom, cuadricula);
                    colocado = true;
                }
            }   
        }
    }
    
    private boolean puedeColocarEdificio(int f, int c, int alto, int ancho) {
        
        if (f - 1 < 1 || f + alto + 1 >= filas - 1 || c - 1 < 1 || c + ancho + 1 >= columnas - 1) {
            return false;
        }
        
        for (int i = (f - 1); i <= (f + alto); i++) {
            for (int j = (c - 1); j <= (c + ancho); j++) {
                if (!cuadricula[i][j].contains("·")) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }
    
}
