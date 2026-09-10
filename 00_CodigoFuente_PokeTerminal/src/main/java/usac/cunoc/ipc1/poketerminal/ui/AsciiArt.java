package usac.cunoc.ipc1.poketerminal.ui;

public class AsciiArt {
    
    private final String BORDE_SUPERIOR = Ansi.NEGRITA + Ansi.BLANCO 
            + "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗" 
            + Ansi.RESET;
    private final String BORDE_INFERIOR = Ansi.NEGRITA + Ansi.BLANCO 
            + "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n"
            + Ansi.RESET;
    
    private final String TEXTO_TITULO = Ansi.NEGRITA + Ansi.BLANCO
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⠶⢶⣤⣤⣀⠀⠀⠀⠀⠀⠀⣀⣤⡶⢾⡇⠀⠀⠀⠀⠀⠀⠀⣠⣄⢀⣀⣀⣀⣀⣀⣤⣤⣤⣤⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⢶⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡶⠟⠋⠉⠀⠀⠀⠀⠈⠙⠿⣧⡀⠀⠀⠀⣾⣏⠁⠀⢸⣇⠀⠀⠀⠀⣀⣴⠟⠉⢻⣿⠉⠉⠉⠉⠉⠉⠀⠀⠀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⡀⠀⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⠋⠁⢸⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⡳⡀⠀⠀⠀⠀⣤⠶⡤⡀⠀⣿⡇⢀⣀⣀⣿⣿⠀⠀⠘⣿⠀⠀⠀⠸⣿⣧⣤⣴⣿⡿⣦⣤⣤⣆⠀⠀⢠⣶⣶⣿⣇⣀⣀⣀⣠⣤⣤⣤⣤⣤⣤⣀⣀⣀⣀⣀⣀⣀⣀⣠⣀⡈⢻⣿⣿⣿⣄⣤⣤⣤⣤⣄⡀⠀⠀⠀⣀⣀⣼⡿⡇⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢷⣽⣾⡆⠀⠀⢸⣧⡿⠁⣠⣿⠟⠛⢛⠙⠻⣿⡇⠀⢀⣿⣤⠾⠷⢶⣾⠟⠋⠉⠉⠛⢿⡏⣿⡟⠀⠀⢸⣇⣠⠟⠋⠉⠉⠻⣿⠀⠀⠀⢀⠀⠈⣻⡉⠁⠉⠉⠙⠋⠉⠈⠙⢿⣟⠁⠀⣿⡁⠈⠉⢀⠀⠈⢻⣦⡴⠟⠉⡛⠁⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⣿⡿⡀⠀⠀⠋⢀⣴⣻⠃⠀⣴⢫⣀⡄⠹⡇⠀⠈⠛⠁⠀⡠⢾⠃⠀⣾⠟⠀⣰⡟⠁⣿⣹⠀⠀⢸⢻⠏⢀⣴⡿⠁⡠⢻⠃⠀⢀⣾⣷⣶⣿⡇⠀⢀⣾⠀⠀⢸⣇⠀⠘⣿⠀⠀⣾⡇⠀⢀⡎⣇⠀⠘⣿⠁⠀⣞⣣⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣧⠀⠀⢰⣟⢻⣿⠀⠀⠙⠻⠋⠀⢰⣇⠀⠀⠀⠀⠺⣜⣸⠀⠈⠃⢠⡾⠛⠳⣄⣿⣿⠀⠀⢸⣼⠀⠘⠋⢀⡼⠓⢾⡆⠀⢸⣿⠉⢸⡿⡄⠀⢸⡟⡇⠀⢸⣿⠀⠀⢻⡄⠀⢸⡇⠀⢸⣿⣿⠀⠀⣿⠀⠀⠙⠛⠀⠀⣿⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣆⠀⠀⣿⣾⣿⣦⡀⠀⠀⢀⣠⣯⣿⠀⠀⣿⢢⡀⠈⠻⣧⣀⠀⠈⢀⣀⣴⡟⢹⡿⣄⠀⢘⣧⣷⣀⡀⠈⢀⣀⡼⣄⣀⣸⣿⠀⠈⣇⣇⣀⣨⡇⣇⣀⣸⢿⡀⢀⣸⡇⠀⢸⣇⣀⣸⣿⡿⣇⠀⡟⢢⣀⠀⠀⠀⠀⣿⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡜⡄⠀⣹⣷⠙⠿⣾⣿⣿⠿⠋⣿⢻⣀⣀⣿⡿⣿⣷⣤⣸⡼⠿⠿⠿⠛⠉⠀⠘⠷⠿⠿⡿⠛⠛⠿⠾⠿⠿⠛⠻⠾⠿⠛⠃⠀⠀⠻⠿⠟⠛⠻⠾⠿⠿⠾⠿⢿⣏⣧⣤⣾⠿⠟⠛⠙⠷⠿⠿⠟⠻⠿⢿⣿⣿⣿⣿⣀⣀⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣷⣼⡿⠟⠃⠀⠀⠀⠀⠀⠀⠀⠛⠛⠛⠛⠛⠀⠀⠙⠻⠿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + Ansi.NEGRITA + Ansi.BLANCO +"║"
            + Ansi.RESET;    
    
    private final String POKE_START = Ansi.AMARILLO
            + " ███████████     ███████    █████   ████ ██████████             █████████  ███████████   █████████   ███████████   ███████████\n"
            + "▒▒███▒▒▒▒▒███  ███▒▒▒▒▒███ ▒▒███   ███▒ ▒▒███▒▒▒▒▒█            ███▒▒▒▒▒███▒█▒▒▒███▒▒▒█  ███▒▒▒▒▒███ ▒▒███▒▒▒▒▒███ ▒█▒▒▒███▒▒▒█\n"
            + " ▒███    ▒███ ███     ▒▒███ ▒███  ███    ▒███  █ ▒            ▒███    ▒▒▒ ▒   ▒███  ▒  ▒███    ▒███  ▒███    ▒███ ▒   ▒███  ▒ \n"
            + " ▒██████████ ▒███      ▒███ ▒███████     ▒██████    ██████████ ▒█████████     ▒███     ▒███████████  ▒██████████      ▒███    \n"
            + " ▒███▒▒▒▒▒▒  ▒███      ▒███ ▒███▒▒███    ▒███▒▒█   ▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒███    ▒███     ▒███▒▒▒▒▒███  ▒███▒▒▒▒▒███     ▒███    \n"
            + " ▒███        ▒▒███     ███  ▒███ ▒▒███   ▒███ ▒   █            ███    ▒███    ▒███     ▒███    ▒███  ▒███    ▒███     ▒███    \n"
            + " █████        ▒▒▒███████▒   █████ ▒▒████ ██████████           ▒▒█████████     █████    █████   █████ █████   █████    █████   \n"
            + "▒▒▒▒▒           ▒▒▒▒▒▒▒    ▒▒▒▒▒   ▒▒▒▒ ▒▒▒▒▒▒▒▒▒▒             ▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒    ▒▒▒▒▒   ▒▒▒▒▒ ▒▒▒▒▒   ▒▒▒▒▒    ▒▒▒▒▒    \n\n\n\n"
            + Ansi.RESET;
    
    private final String NUEVA_PARTIDA_SELECCIONADO = Ansi.NEGRITA
            + "░█▀░░▀▄░░▀█░░░░█▀█░█░█░█▀▀░█░█░█▀█░░░█▀█░█▀█░█▀▄░▀█▀░▀█▀░█▀▄░█▀█\n"
            + "░█░░░░▄▀░░█░░░░█░█░█░█░█▀▀░▀▄▀░█▀█░░░█▀▀░█▀█░█▀▄░░█░░░█░░█░█░█▀█\n"
            + "░▀▀░░▀░░░▀▀░░░░▀░▀░▀▀▀░▀▀▀░░▀░░▀░▀░░░▀░░░▀░▀░▀░▀░░▀░░▀▀▀░▀▀░░▀░▀\n" 
            + Ansi.RESET;
    
    private final String NUEVA_PARTIDA = Ansi.NEGRITA
            + "░█▀░░░░░░▀█░░░░█▀█░█░█░█▀▀░█░█░█▀█░░░█▀█░█▀█░█▀▄░▀█▀░▀█▀░█▀▄░█▀█\n"
            + "░█░░░░░░░░█░░░░█░█░█░█░█▀▀░▀▄▀░█▀█░░░█▀▀░█▀█░█▀▄░░█░░░█░░█░█░█▀█\n"
            + "░▀▀░░░░░░▀▀░░░░▀░▀░▀▀▀░▀▀▀░░▀░░▀░▀░░░▀░░░▀░▀░▀░▀░░▀░░▀▀▀░▀▀░░▀░▀\n" 
            + Ansi.RESET;
    
    private final String CARGAR_PARTIDA_SELECCIONADO = Ansi.NEGRITA 
            + "░█▀░░▀▄░░▀█░░░░█▀▀░█▀█░█▀▄░█▀▀░█▀█░█▀▄░░░█▀█░█▀█░█▀▄░▀█▀░▀█▀░█▀▄░█▀█\n"
            + "░█░░░░▄▀░░█░░░░█░░░█▀█░█▀▄░█░█░█▀█░█▀▄░░░█▀▀░█▀█░█▀▄░░█░░░█░░█░█░█▀█\n"
            + "░▀▀░░▀░░░▀▀░░░░▀▀▀░▀░▀░▀░▀░▀▀▀░▀░▀░▀░▀░░░▀░░░▀░▀░▀░▀░░▀░░▀▀▀░▀▀░░▀░▀\n" 
            + Ansi.RESET;
    
    private final String CARGAR_PARTIDA = Ansi.NEGRITA 
            + "░█▀░░░░░░▀█░░░░█▀▀░█▀█░█▀▄░█▀▀░█▀█░█▀▄░░░█▀█░█▀█░█▀▄░▀█▀░▀█▀░█▀▄░█▀█\n"
            + "░█░░░░░░░░█░░░░█░░░█▀█░█▀▄░█░█░█▀█░█▀▄░░░█▀▀░█▀█░█▀▄░░█░░░█░░█░█░█▀█\n"
            + "░▀▀░░░░░░▀▀░░░░▀▀▀░▀░▀░▀░▀░▀▀▀░▀░▀░▀░▀░░░▀░░░▀░▀░▀░▀░░▀░░▀▀▀░▀▀░░▀░▀\n" 
            + Ansi.RESET;
    
    private final String SALIR_SELECCIONADO = Ansi.NEGRITA
            + "░█▀░░▀▄░░▀█░░░░█▀▀░█▀█░█░░░▀█▀░█▀▄\n"
            + "░█░░░░▄▀░░█░░░░▀▀█░█▀█░█░░░░█░░█▀▄\n"
            + "░▀▀░░▀░░░▀▀░░░░▀▀▀░▀░▀░▀▀▀░▀▀▀░▀░▀\n"
            + Ansi.RESET;
    
    private final String SALIR = Ansi.NEGRITA
            + "░█▀░░░░░░▀█░░░░█▀▀░█▀█░█░░░▀█▀░█▀▄\n"
            + "░█░░░░░░░░█░░░░▀▀█░█▀█░█░░░░█░░█▀▄\n"
            + "░▀▀░░░░░░▀▀░░░░▀▀▀░▀░▀░▀▀▀░▀▀▀░▀░▀\n"
            + Ansi.RESET;
    
    private final String INGRESAR_NOMBRE_PARTIDA = Ansi.NEGRITA + Ansi.AZUL 
            + "                     ╦╔╗╔╔═╗╦═╗╔═╗╔═╗╔═╗  ╔═╗╦    ╔╗╔╔═╗╔╦╗╔╗ ╦═╗╔═╗  ╔╦╗╔═╗  ╦  ╔═╗  ╔═╗╔═╗╦═╗╔╦╗╦╔╦╗╔═╗\n"
            + "                     ║║║║║ ╦╠╦╝║╣ ╚═╗║╣   ║╣ ║    ║║║║ ║║║║╠╩╗╠╦╝║╣    ║║║╣   ║  ╠═╣  ╠═╝╠═╣╠╦╝ ║ ║ ║║╠═╣\n"
            + "                     ╩╝╚╝╚═╝╩╚═╚═╝╚═╝╚═╝  ╚═╝╩═╝  ╝╚╝╚═╝╩ ╩╚═╝╩╚═╚═╝  ═╩╝╚═╝  ╩═╝╩ ╩  ╩  ╩ ╩╩╚═ ╩ ╩═╩╝╩ ╩" 
            + Ansi.RESET;

    public String getBORDE_SUPERIOR() {
        return BORDE_SUPERIOR;
    }

    public String getBORDE_INFERIOR() {
        return BORDE_INFERIOR;
    }

    public String getTEXTO_TITULO() {
        return TEXTO_TITULO;
    }
    
    public String getPOKE_START() {
        return POKE_START;
    }
    
    public String getNUEVA_PARTIDA(boolean seleccionado) {
        if (seleccionado) {
            return Ansi.AMARILLO + NUEVA_PARTIDA_SELECCIONADO + Ansi.RESET;
        }
        return Ansi.GRIS + NUEVA_PARTIDA + Ansi.RESET;
    }
    
    public String getCARGAR_PARTIDA(boolean seleccionado) {
        if (seleccionado) {
            return Ansi.AZUL + CARGAR_PARTIDA_SELECCIONADO + Ansi.RESET;
        }
        return Ansi.GRIS + CARGAR_PARTIDA + Ansi.RESET;
    }
    
    public String getSALIR(boolean seleccionado) {
        if (seleccionado) {
            return Ansi.ROJO + SALIR_SELECCIONADO + Ansi.RESET;
        }
        return Ansi.GRIS + SALIR + Ansi.RESET;
    }

    public String getINGRESAR_NOMBRE_PARTIDA() {
        return INGRESAR_NOMBRE_PARTIDA;
    }
}    
 