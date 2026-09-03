package usac.cunoc.ipc1.poketerminal.mapas.edificios;

public class GimnasioPokemon extends Edificio {
    
    public GimnasioPokemon() {
        super(8, 29);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return edificio.getGIMNASIO();
    }
    
}
