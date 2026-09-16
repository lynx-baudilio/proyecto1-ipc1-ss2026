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
        
        boolean[] zonaOcupada = new boolean[ZONAS_VALIDAS.length];
        
        for (int i = 0; i < listaEdificios.length; i++) {
            int indiceZona;
            
            do {                
                indiceZona = random.nextInt(ZONAS_VALIDAS.length);
            } while (zonaOcupada[indiceZona]);
            
            zonaOcupada[indiceZona] = true;
            
            int fila = ZONAS_VALIDAS[indiceZona][0];
            int columna = ZONAS_VALIDAS[indiceZona][1];
            
            listaEdificios[i].estamparEdificioEnMapa(fila, columna, cuadricula);
        }
    }
    
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    
}
