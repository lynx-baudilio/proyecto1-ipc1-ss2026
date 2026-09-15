package usac.cunoc.ipc1.poketerminal.utilidades;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;

public class GestorDeArchivos {
    
    public boolean guardarPartida(Partida partida) {
        String ruta = partida.getNombrePartida() + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(partida);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar partida: " + e.getMessage());
            return false;
        }
    }

    public Partida cargarPartida(String nombrePartida) {
        String ruta = nombrePartida + ".dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (Partida) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar partida: " + e.getMessage());
            return null;
        }
    }

    public void registrarHallDeLaFama(String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hall_de_la_fama.txt", true))) {
            bw.write(texto);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de texto: " + e.getMessage());
        }
    }
    
}
