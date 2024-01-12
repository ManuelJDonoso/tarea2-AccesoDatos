/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 *
 * 1. (1 punto) Muestra por consola todos los ficheros y subdirectorios que
 * tiene el directorio donde está el proyecto. También debes comprobar si existe
 * un directorio llamado Prueba, donde está el proyecto (src). Si existe el
 * directorio muestra un mensaje "El directorio prueba ya existe ". Y si no
 * existe créalo y muestra el mensaje de que ha sido creado. Con la clase io.
 *
 */
public class Apartado1 {

 
    private ArrayList<Directorio> Directorios = new ArrayList();
    public Apartado1() {
    }

    /**
     * crear 2 listas una para directorios y otras para archivos
     * @param path 
     */
    public void addDirectorioActual(String path) {
        File Path = new File(path);
        Directorio dir = new Directorio(path);

        String[] listaFicherosDirectorios = Path.list();

        for (String item : listaFicherosDirectorios) {
            String FilDir = path + item;

            if (new File(FilDir).isDirectory()) {
                dir.addSubDirectorio(item);
            } else {

                dir.addArchivo(item);
            }

        }

        Directorios.add(dir);
    }

    /**
     * Muestra los archivos y los subdirectorios guardados 
     */
    public void getArcDir() {

        ArrayList<String> DirectorioAux, Archivos;

        for (Directorio item : Directorios) {
            DirectorioAux = item.getSubDirectorios();
            Archivos = item.getArchivos();
            System.out.println("Los Subdirectorios de " + item.getPath() + " son:");
            for (String subdirec : DirectorioAux) {
                System.out.println(subdirec);
            }
            System.out.println("Los Archivos de " + item.getPath() + " son:");

            for (String archivo : Archivos) {
                System.out.println(archivo);
            }

        }
    }



    

   

   

}
