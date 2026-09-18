package usac.cunoc.ipc1.poketerminal.catalogos;

import java.util.Random;

public class CatalogoCiudades {
    
    private static final String[] NOMBRES = {
        "PUEBLO PALETA", "CIUDAD VERDE", "CIUDAD PLATEADA",
        "CIUDAD CERÚLEA", "CIUDAD CARMÍN", "CIUDAD AZULONA"
    };
    
    public String[] obtenerNombresAleatorios() {
        String[] seleccionados = new String[3];
        boolean[] usados = new boolean[NOMBRES.length];
        Random random = new Random();
        
        int indiceAleatorio;
        int contador = 0;
        
        while (contador < 3) {            
            indiceAleatorio = random.nextInt(NOMBRES.length);
            if (!usados[indiceAleatorio]) {
                seleccionados[contador] = NOMBRES[indiceAleatorio];
                usados[indiceAleatorio] = true;
                contador = contador + 1;
            }
        }
        return seleccionados;
    }    
    
    public static String[] getNOMBRES() {
        return NOMBRES;
    }
}