package usac.cunoc.ipc1.poketerminal.mapas.edificios;

public class CentroPokemon extends Edificio {
    
    public CentroPokemon() {
        super(6, 23);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return dibujo.getCENTRO();
    }
}
