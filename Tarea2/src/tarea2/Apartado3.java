/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 *
 * 3. (1 punto) Crea un fichero de texto en el directorio Prueba, llamado
 * FichTexto.txt, de forma secuencial, en el que vaya el siguiente texto:
 * "Ejemplo de escritura en un fichero de texto o txt" o pide el texto por
 * consola. A continuación debe mostrar su contenido.
 */
public class Apartado3 {
    // Ruta del directorio y nombre del fichero

    private Path directorioPath = Paths.get("Prueba");
    private Path ficheroPath = directorioPath.resolve("FichTexto.txt");

    private static String obtenerTextoPorConsola() {
        // Puedes descomentar este bloque si quieres pedir el texto por consola

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el texto para escribir en el fichero:");
        return scanner.nextLine();
         */
        // Por ahora, retornamos un texto fijo para el ejemplo
        return "Ejemplo de escritura en un fichero de texto o txt";
    }

    public void crearDirectorio() {
        // Crear el directorio si no existe
        try {
            Files.createDirectories(directorioPath);
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: " + e.getMessage());
            return;
        }

    }

    public void EscribirTextoFichero() {
        // Texto a escribir en el fichero
        String texto = obtenerTextoPorConsola();

        // Escribir el texto en el fichero
        try {
            Files.write(ficheroPath, texto.getBytes());
            System.out.println("Texto escrito en el fichero.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }

    }
    
    public void MostrarContenidoFicheroConsola(){
    
    // Mostrar el contenido del fichero
        try {
            String contenido = Files.readString(ficheroPath);
            System.out.println("Contenido del fichero:");
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al leer el contenido del fichero: " + e.getMessage());
        }
    
    }
}
