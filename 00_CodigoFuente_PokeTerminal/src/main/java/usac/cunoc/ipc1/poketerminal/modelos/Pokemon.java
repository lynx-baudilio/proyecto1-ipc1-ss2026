package usac.cunoc.ipc1.poketerminal.modelos;

import java.io.Serializable;
import java.util.Random;
import usac.cunoc.ipc1.poketerminal.logica.Formulas;

public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    private int identificadorEjemplar;
    private int numeroEspecie;
    private String especie;
    private String apodo;
    private int nivel;
    private int experiencia;
    private int vidaActual;
    private int vidaMaxima;
    private int puntosAtaque;
    private int puntosDefensa;
    private int puntosVelocidad;
    private int baseSalud;
    private int baseAtaque;
    private int baseDefensa;
    private int baseVelocidad;
    private Movimiento[] movimientos;
    private int enemigosDebilitados;
    private boolean envenenado;
    private int turnosParalizado;
    private int turnosConfuso;
    private int turnosDormido;
    private boolean cansado;

    public Pokemon(int identificadorEjemplar, int numeroEspecie, String especie, String apodo,
            int nivel, int experiencia, int vidaActual, int vidaMaxima,
            int puntosAtaque, int puntosDefensa, int puntosVelocidad,
            int baseSalud, int baseAtaque, int baseDefensa, int baseVelocidad,
            Movimiento[] movimientos) {
        this.identificadorEjemplar = identificadorEjemplar;
        this.numeroEspecie = numeroEspecie;
        this.especie = especie;
        this.apodo = (apodo == null || apodo.trim().isEmpty()) ? especie : apodo;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.vidaActual = vidaActual;
        this.vidaMaxima = vidaMaxima;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.puntosVelocidad = puntosVelocidad;
        this.baseSalud = baseSalud;
        this.baseAtaque = baseAtaque;
        this.baseDefensa = baseDefensa;
        this.baseVelocidad = baseVelocidad;
        this.movimientos = movimientos;
    }

    public boolean estaDebilitado() {
        return vidaActual <= 0;
    }

    public int recibirDanio(int cantidadDanio) {
        int danioAplicado = cantidadDanio < 0 ? 0 : cantidadDanio;
        vidaActual = vidaActual - danioAplicado;
        if (vidaActual < 0) {
            vidaActual = 0;
        }
        return danioAplicado;
    }

    public void curar(int puntosCuracion) {
        if (puntosCuracion < 0) {
            return;
        }
        vidaActual = vidaActual + puntosCuracion;
        if (vidaActual > vidaMaxima) {
            vidaActual = vidaMaxima;
        }
    }

    public void restaurarCompleto() {
        vidaActual = vidaMaxima;
        envenenado = false;
        turnosParalizado = 0;
        turnosConfuso = 0;
        turnosDormido = 0;
        cansado = false;
    }

    public String ganarExperiencia(int experienciaGanada, Random generadorAleatorio) {
        StringBuilder bitacora = new StringBuilder();
        experiencia = experiencia + experienciaGanada;
        bitacora.append(apodo).append(" ganó ").append(experienciaGanada).append(" puntos de EXP.");

        while (experiencia >= Formulas.experienciaRequerida(nivel + 1)) {
            experiencia = experiencia - Formulas.experienciaRequerida(nivel + 1);
            subirNivel(generadorAleatorio);
            bitacora.append("\n¡").append(apodo)
                    .append(" subió al nivel ").append(nivel).append("!");
        }
        return bitacora.toString();
    }

    private void subirNivel(Random generadorAleatorio) {
        nivel = nivel + 1;
        int incrementoVida = Formulas.incrementoSalud(baseSalud, generadorAleatorio.nextInt(32), nivel);
        int incrementoAtaque = Formulas.incrementoEstadistica(baseAtaque, generadorAleatorio.nextInt(32), nivel);
        int incrementoDefensa = Formulas.incrementoEstadistica(baseDefensa, generadorAleatorio.nextInt(32), nivel);
        int incrementoVelocidad = Formulas.incrementoEstadistica(baseVelocidad, generadorAleatorio.nextInt(32), nivel);

        vidaMaxima = vidaMaxima + incrementoVida;
        puntosAtaque = puntosAtaque + incrementoAtaque;
        puntosDefensa = puntosDefensa + incrementoDefensa;
        puntosVelocidad = puntosVelocidad + incrementoVelocidad;
        vidaActual = vidaMaxima;
    }

    public void registrarDebilitamiento() {
        enemigosDebilitados = enemigosDebilitados + 1;
    }

    public void reducirContadoresEstado() {
        if (turnosParalizado > 0) {
            turnosParalizado = turnosParalizado - 1;
        }
        if (turnosConfuso > 0) {
            turnosConfuso = turnosConfuso - 1;
        }
        if (turnosDormido > 0) {
            turnosDormido = turnosDormido - 1;
        }
    }

    public String lineaEquipo() {
        return "#" + identificadorEjemplar + " " + apodo + " (" + especie + ") Nv." + nivel
                + " HP " + vidaActual + "/" + vidaMaxima;
    }

    public int getIdentificadorEjemplar() {
        return identificadorEjemplar;
    }

    public int getNumeroEspecie() {
        return numeroEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = (apodo == null || apodo.trim().isEmpty()) ? especie : apodo.trim();
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        int vidaAjustada = Math.max(0, vidaActual);
        this.vidaActual = Math.min(vidaAjustada, vidaMaxima);
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public int getPuntosVelocidad() {
        return puntosVelocidad;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public int getEnemigosDebilitados() {
        return enemigosDebilitados;
    }

    public boolean estaEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public int getTurnosParalizado() {
        return turnosParalizado;
    }

    public void setTurnosParalizado(int turnosParalizado) {
        this.turnosParalizado = turnosParalizado;
    }

    public int getTurnosConfuso() {
        return turnosConfuso;
    }

    public void setTurnosConfuso(int turnosConfuso) {
        this.turnosConfuso = turnosConfuso;
    }

    public int getTurnosDormido() {
        return turnosDormido;
    }

    public void setTurnosDormido(int turnosDormido) {
        this.turnosDormido = turnosDormido;
    }

    public boolean estaCansado() {
        return cansado;
    }

    public void setCansado(boolean cansado) {
        this.cansado = cansado;
    }
}