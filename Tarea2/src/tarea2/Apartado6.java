/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 *
 * 6. (1 punto) Escribe un fichero binario alumnos.dat de forma aleatoria en el
 * directorio prueba (creado en el apartado 2). Con la siguiente información.
 * Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
 * Edad 17, 20, 18, 17, 19, 21, 20 Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9
 */
public class Apartado6 {

    // Ruta del directorio y nombre del fichero
    String rutaDirectorio = "prueba";
    String nombreFichero = "alumnos.dat";
    // Ruta completa del fichero binario
    String rutaFichero = rutaDirectorio + File.separator + nombreFichero;
// Datos a escribir
    String[] apellidos = {"FERNANDEZ", "LOPEZ", "GOMEZ", "CHEN", "SERRANO", "CASILLAS", "ALONSO"};
    int[] edades = {17, 20, 18, 17, 19, 21, 20};
    double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

    public Apartado6() {
    }

    public void CrearDirectorio() {
        // Crear el directorio si no existe
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    public void Escribir() {
        // Escribir en el fichero binario aleatoriamente
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(rutaFichero, "rw")) {
            for (int i = 0; i < apellidos.length; i++) {
                // Escribir apellido
                
                StringBuffer sb =new StringBuffer(apellidos[i]);
                // establecemos el larga para que siempre tenga los mismo bytes
                sb.setLength(10);
                
                randomAccessFile.writeChars(sb.toString());
                
            
                // Escribir edad
                randomAccessFile.writeInt(edades[i]);
                // Escribir nota
                randomAccessFile.writeDouble(notas[i]);
              
            }
            System.out.println("Datos escritos en el fichero binario aleatoriamente.");
              //int,4 String 2 por char, double 8, boolean 1,char 2
                //Cada registro 10*2+4+8=32
                System.out.println("Cada registro son 32 bytes");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero binario: " + e.getMessage());
        }

    }
}
