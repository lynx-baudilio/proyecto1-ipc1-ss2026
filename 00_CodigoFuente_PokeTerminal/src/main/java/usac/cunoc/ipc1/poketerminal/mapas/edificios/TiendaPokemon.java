package usac.cunoc.ipc1.poketerminal.mapas.edificios;

public class TiendaPokemon extends Edificio{

    public TiendaPokemon() {
        super(5, 19);
    }
    
    @Override
    protected String[][] construirPixelArt() {
        return dibujo.getTIENDA();
    }
    
}
