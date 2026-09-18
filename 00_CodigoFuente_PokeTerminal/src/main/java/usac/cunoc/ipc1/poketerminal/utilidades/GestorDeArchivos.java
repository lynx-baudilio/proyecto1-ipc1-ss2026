package usac.cunoc.ipc1.poketerminal.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import usac.cunoc.ipc1.poketerminal.modelos.Partida;

public class GestorDeArchivos {

    public boolean guardarPartida(Partida partida) {
        String rutaArchivo = partida.getNombrePartida() + ".dat";
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            flujoSalida.writeObject(partida);
            return true;
        } catch (IOException excepcion) {
            System.out.println("Error al guardar la partida: " + excepcion.getMessage());
            return false;
        }
    }

    public Partida cargarPartida(String nombrePartida) {
        String rutaArchivo = nombrePartida + ".dat";
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (Partida) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException excepcion) {
            System.out.println("Error al cargar la partida: " + excepcion.getMessage());
            return null;
        }
    }

    public void registrarHall(String textoRegistro) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("hall_de_la_fama.txt", true))) {
            escritor.write(textoRegistro);
            escritor.newLine();
        } catch (IOException excepcion) {
            System.out.println("Error al escribir el archivo del Hall: " + excepcion.getMessage());
        }
    }

    public void mostrarHall() {
        File archivoHall = new File("hall_de_la_fama.txt");
        if (!archivoHall.exists()) {
            System.out.println("Aún no hay entrenadores registrados en el Hall de la Fama.");
            return;
        }
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoHall))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException excepcion) {
            System.out.println("Error al leer el archivo del Hall: " + excepcion.getMessage());
        }
    }
}