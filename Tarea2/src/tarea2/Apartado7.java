/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.*;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 *
 * 7. (1 punto) Visualiza el contenido del fichero alumnos.dat de forma
 * aleatoria.
 */
public class Apartado7 {

    public Apartado7() {
    }

    // Ruta del directorio y nombre del fichero
    private String rutaDirectorio = "prueba";
    private String nombreFichero = "alumnos.dat";

    // Ruta completa del fichero binario
    private String rutaFichero = rutaDirectorio + File.separator + nombreFichero;

    public void Leer() {

        // Leer el contenido del fichero binario aleatoriamente
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(rutaFichero, "r")) {
            //Calcular el numer de registros
            long longitudFichero = randomAccessFile.length();
            int numRegistros=(int)longitudFichero/32;
                    
            
            for (int i = 0; i < numRegistros; i++) {
                //posicion de cada registro
                randomAccessFile.seek(i*32);
                //leer apellidos
                String apellidos = "";
                for (int j = 0; j < 10; j++) {
                    apellidos += randomAccessFile.readChar();
                }
                //leer edad
                int edad = randomAccessFile.readInt();
                //leer nota
                double nota = randomAccessFile.readDouble();

                System.out.println("Apellido: " + apellidos + ", Edad: " + edad + ", Nota: " + nota);
            }
        
        } catch (IOException e) {
            System.err.println("Error al leer el fichero binario: " + e.getMessage());
        }

    }

}
