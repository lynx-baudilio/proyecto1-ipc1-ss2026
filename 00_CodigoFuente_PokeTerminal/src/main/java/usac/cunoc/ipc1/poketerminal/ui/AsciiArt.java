package usac.cunoc.ipc1.poketerminal.ui;

public class AsciiArt {
    
    private final String BORDE_SUPERIOR = Ansi.NEGRITA + Ansi.BLANCO 
            + "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗" 
            + Ansi.RESET;
    private final String BORDE_INFERIOR = Ansi.NEGRITA + Ansi.BLANCO 
            + "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n"
            + Ansi.RESET;
    
    private final String TEXTO_TITULO = Ansi.NEGRITA + Ansi.BLANCO
            + "║" + Ansi.ROJO + "                                         .-'''-.                                                                                                                                  " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                                        '········\\                                                                                                              .---.             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "             _________   _...._       /···/` '.···\\     .           __.....__                    __.....__              __  __   ___   .--.   _..._             |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "             \\········|.'······'-.   .···|     \\··'   .'|       .-''·········'.              .-''·········'.           |··|/··`.'···`. |__| .'·····'.           |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "              \\········.'```'.····'. |···'      |··'.'··|      /·····.-''\"'-.··`.      .|   /·····.-''\"'-.··`. .-,.--. |···.-.··.-.···'.--..···.-.···.          |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "               \\······|       \\·····\\\\····\\     /·/<····|     /·····/________\\···\\   .'·|_ /·····/________\\···\\|··.-.·||··|  |··|  |··||  ||··'   '··|    __    |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                |·····|        |····| `.···`·..'·/  |···| ____|··················| .'·····||··················||·|  |·||··|  |··|  |··||··||··|   |··| .:--.'.  |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                |······\\      /····.     '-...-'`   |···| \\ .'\\····.-------------''--.··.-'\\····.-------------'|·|  |·||··|  |··|  |··||··||··|   |··|/·|   \\·| |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                |·····|\\`'-.-'···.'                 |···|/··.  \\····'-.____...---.   |··|   \\····'-.____...---.|·|  '- |··|  |··|  |··||··||··|   |··|`\" __ |·| |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                |·····| '-....-'`                   |····/\\··\\  `.·············.'    |··|    `.·············.' |·|     |__|  |__|  |__||__||··|   |··| .'.''|·| |···|             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "               .'     '.                            |   |  \\  \\   `''-...... -'      |  '.'    `''-...... -'   | |                         |  |   |  |/ /   | |_'---'             " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "             '-----------'                          '    \\  \\  \\                     |   /                     |_|                         |  |   |  |\\ \\._,\\ '/                  " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                                                   '------'  '---'                   `'-'                                                  '--'   '--' `--'  `\"                   " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                                                                                                                                                                                  " + Ansi.BLANCO + "║\n"
            + "║" + Ansi.ROJO + "                                                                                                                                                                                  " + Ansi.BLANCO + "║"
            + Ansi.RESET;
    
    private final String PIKACHU_SORPENDIDO = Ansi.NEGRITA + Ansi.BLANCO
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⡐⢂⠲⡐⢢⢀⠂⡔⠠⠒⡄⢃⡒⠔⡂⠖⡐⢆⠒⡔⢂⠲⡐⢂⠖⡐⢢⠒⡰⢂⡈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠰⡉⢆⢡⠃⣄⠣⢀⠣⠄⢘⡡⠘⡄⢣⢘⠰⣈⠒⡌⡘⠤⡑⢊⠔⡉⢆⠱⢠⠃⡄⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣻⡽⣯⠟                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⢂⠱⡈⠆⣸⢆⠡⢂⠒⣈⠐⡄⢋⠔⡡⢊⠔⢢⠑⡄⢃⡒⢡⠊⡔⢡⠊⡔⢡⠊⡔⢙⣿⣿⣿⣿⣿⣿⣿⣿⣟⣯⢿⡽⢧⢋                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⡈⢆⡑⢲⢻⣌⡳⣌⢶⣠⢃⠘⠤⢊⠔⡡⢊⠤⢃⠜⡰⢈⠆⡱⢈⠆⡱⢈⠆⡱⢈⠜⣿⣿⣿⣿⣿⣿⣿⣿⢯⣟⣯⣟⡯⢆                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⡐⢂⠀⡀⠁⢚⠿⣽⣻⢾⣭⠎⡐⢣⠘⡄⢣⠘⡄⢎⠰⡁⢎⠰⡁⢎⠰⡁⢎⠰⡁⠆⢿⡿⣿⣿⣿⣿⡿⣯⣿⣻⢾⣽⣛⡆                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⡘⢄⣀⠀⠸⣿⣿⣶⣭⡛⢾⣓⠈⢆⠱⡈⢆⠱⡈⢆⠱⡈⢆⠱⡈⢆⠱⡈⢆⠱⣈⠱⡘⠿⡽⢻⡞⣷⢻⢯⠷⣟⠿⠾⠝⠂                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠌⣸⣿⢿⡄⢻⣿⣿⣿⣿⣷⣦⣉⠢⡑⢌⠢⡑⢌⠢⡑⢌⠢⡑⢌⠢⡑⢌⠢⡑⠤⢃⠄⠰⢀⠃⡐⠠⠂⣀⣢⣴⣶⣿⡇⠀                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⢲⣿⢯⣟⣷⡘⣿⣿⣿⣿⣿⣿⣿⣷⣮⡀⢇⡘⢄⠣⡘⢄⠣⡘⢄⠣⡘⢢⢑⡘⡰⢉⠜⠀⡌⣤⣴⣶⣿⣿⣿⣿⣿⣿⠇⠀                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣿⢯⣟⡿⣞⠳⡘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡘⠄⢣⣜⣀⣃⣘⣂⣡⣑⣂⣈⢐⣁⣎⣶⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⡐                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣿⢯⡿⣽⢏⢣⠐⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⣀⠔⡠                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠌⢋⡙⠤⠋⢄⠃⠤⠁⠙⢿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣡⣾⢯⣟⡔                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠀⠂⠀⠄⢁⠂⠌⠤⢁⠂⠀⢡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡻⢋⣥⣾⡿⣯⣟⡾⡐                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠀⠀⠀⠀⠀⡈⠰⢈⠆⡘⢠⣿⣿⣿⣿⡿⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⢿⣿⣿⣿⣿⣿⣷⡜⢯⣷⣻⢷⡻⣜⠡                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠀⠀⠀⠀⠀⢀⠡⢊⠔⣉⣾⣿⣿⣿⣿⠘⠛⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⠟⠀⣿⣿⣿⣿⣿⣿⣿⡨⢓⡹⢎⡱⢌⠡                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠀⠀⠀⠀⠀⠀⠂⠥⡚⣼⣿⣿⣿⣿⣿⣶⣤⣾⣿⣿⣿⡿⠿⣿⣿⣿⣿⣿⣿⣷⣤⣶⣿⣿⣿⣿⣿⣿⣿⣇⠡⠒⢄⠒⡨⠐                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠀⠀⠀⠀⠀⠠⡉⢦⢡⡿⢟⡻⠟⠿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⢟⢻⡛⢻⣿⣿⣿⡄⢡⠊⠤⡑⠌                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⢀⡄⣄⢢⣌⡵⣜⣮⢹⣡⠚⣔⢋⢎⣹⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⠔⣊⠦⣍⢣⢾⣿⣿⡧⢮⣝⣲⢡⢊                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣾⣼⣞⡷⣾⣽⣻⢾⣸⣷⣼⣬⣷⣴⣿⣿⣿⣿⣿⣿⡏⣾⣿⣿⣿⣷⢹⣿⣿⣿⣿⣿⣲⣩⣶⣬⣶⣾⣿⣿⣿⠾⣽⣳⣏⠆                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣿⢾⣽⣻⢷⣯⣟⣯⣧⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣙⣿⠿⡿⣏⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣳⢿⡌                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣿⢯⣷⢿⣻⡾⣽⣳⣯⢧⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣾⣽⡻⡔                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⣟⡿⣞⣯⢷⣻⣽⣳⢯⡟⣇⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠓⣯⠳⠌                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║\n"
            + "║" + Ansi.RESET + Ansi.AMARILLO + "                                                                  ⠸⢹⠙⡎⢏⠳⢍⠫⡙⡜⢄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠣⡙⡐                                                                  " + Ansi.NEGRITA + Ansi.BLANCO +"║" 
            + Ansi.RESET;
    
    private final String POKE_START = Ansi.AMARILLO
            + "                            ███████████     ███████    █████   ████ ██████████             █████████  ███████████   █████████   ███████████   ███████████\n"
            + "                           ▒▒███▒▒▒▒▒███  ███▒▒▒▒▒███ ▒▒███   ███▒ ▒▒███▒▒▒▒▒█            ███▒▒▒▒▒███▒█▒▒▒███▒▒▒█  ███▒▒▒▒▒███ ▒▒███▒▒▒▒▒███ ▒█▒▒▒███▒▒▒█\n"
            + "                            ▒███    ▒███ ███     ▒▒███ ▒███  ███    ▒███  █ ▒            ▒███    ▒▒▒ ▒   ▒███  ▒  ▒███    ▒███  ▒███    ▒███ ▒   ▒███  ▒ \n"
            + "                            ▒██████████ ▒███      ▒███ ▒███████     ▒██████    ██████████ ▒█████████     ▒███     ▒███████████  ▒██████████      ▒███    \n"
            + "                            ▒███▒▒▒▒▒▒  ▒███      ▒███ ▒███▒▒███    ▒███▒▒█   ▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒███    ▒███     ▒███▒▒▒▒▒███  ▒███▒▒▒▒▒███     ▒███    \n"
            + "                            ▒███        ▒▒███     ███  ▒███ ▒▒███   ▒███ ▒   █            ███    ▒███    ▒███     ▒███    ▒███  ▒███    ▒███     ▒███    \n"
            + "                            █████        ▒▒▒███████▒   █████ ▒▒████ ██████████           ▒▒█████████     █████    █████   █████ █████   █████    █████   \n"
            + "                           ▒▒▒▒▒           ▒▒▒▒▒▒▒    ▒▒▒▒▒   ▒▒▒▒ ▒▒▒▒▒▒▒▒▒▒             ▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒    ▒▒▒▒▒   ▒▒▒▒▒ ▒▒▒▒▒   ▒▒▒▒▒    ▒▒▒▒▒    \n"
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

    public String getBORDE_SUPERIOR() {
        return BORDE_SUPERIOR;
    }

    public String getBORDE_INFERIOR() {
        return BORDE_INFERIOR;
    }

    public String getTEXTO_TITULO() {
        return TEXTO_TITULO;
    }

    public String getPIKACHU_SORPENDIDO() {
        return PIKACHU_SORPENDIDO;
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
}    
 