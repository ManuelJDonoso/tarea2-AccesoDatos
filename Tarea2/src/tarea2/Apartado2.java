/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 *
 * @author Manuel Jesús Donoso Pérez 2. (1 punto) Utilizando la clase java.nio ,
 * para el manejo de ficheros, con la clase Files y objetos Path: Comprueba si
 * existe un directorio en el proyecto llamado direcnio. Si no existe el
 * directorio lo creas y dentro creas también un fichero llamado fichero.txt. Si
 * existe el directorio saca un mensaje de que existe, comprueba si existe un
 * fichero dentro de direcnio el fichero fichero.txt y a continuación borra el
 * directorio.
 */
public class Apartado2 {

    public Apartado2() {
    }

    // Ruta del directorio y fichero
    private Path directorioPath = Paths.get("directorio");
    private Path ficheroPath = directorioPath.resolve("fichero.txt");

    public void tarea2() {
        // Comprobar si el directorio existe
        if (Files.exists(this.directorioPath) && Files.isDirectory(this.directorioPath)) {
            System.out.println("El directorio ya existe.");

            // Comprobar si el fichero existe dentro del directorio
            if (Files.exists(this.ficheroPath) && Files.isRegularFile(this.ficheroPath)) {
                System.out.println("El fichero " + this.ficheroPath.getFileName() + " existe.");
            } else {
                System.out.println("El fichero " + this.ficheroPath.getFileName() + " no existe.");
            }

            // Borrar el directorio y su contenido
            try {
                Files.walk(this.directorioPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                System.out.println("Directorio y contenido borrados.");
            } catch (IOException e) {
                System.err.println("Error al borrar el directorio: " + e.getMessage());
            }
        } else {
            // Crear el directorio y el fichero
            try {
                Files.createDirectories(this.directorioPath);
                Files.createFile(this.ficheroPath);
                System.out.println("Directorio y fichero creados.");
            } catch (IOException e) {
                System.err.println("Error al crear el directorio o fichero: " + e.getMessage());
            }
        }
    }
}
