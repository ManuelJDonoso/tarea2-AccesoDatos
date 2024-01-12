/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 */
public class Directorio {

    private String path;
    private ArrayList<String> SubDirectorios, Archivos;

    public Directorio(String path) {
        this.path = path;
        this.SubDirectorios = new ArrayList<>();
        this.Archivos = new ArrayList<>();
    }

    public Directorio(String path, ArrayList<String> SubDirectorios, ArrayList<String> Archivos) {
        this.path = path;
        this.SubDirectorios = SubDirectorios;
        this.Archivos = Archivos;
    }

    /**
     * Devuelve la ruta del directorio
     * @return 
     */
    public String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }

    /**
     * revuelve lista de subdirectorios
     *
     * @return
     */
    public ArrayList<String> getSubDirectorios() {
        return SubDirectorios;
    }

    /**
     * Devuelve lista con los archivos
     *
     * @return
     */
    public ArrayList<String> getArchivos() {
        return Archivos;
    }

    /**
     * añadir subdirectorio a la lista de de subdirectorio
     *
     * @param Subdirectorio
     */
    public void addSubDirectorio(String Subdirectorio) {
        if (!this.SubDirectorios.contains(Subdirectorio)) {
            this.SubDirectorios.add(Subdirectorio);
        }

    }

    /**
     * añadir archivo a la lista del directorio
     *
     * @param Archivo
     */
    public void addArchivo(String Archivo) {
        if (!this.Archivos.contains(Archivo)) {
            this.Archivos.add(Archivo);
        }
    }

    /**
     *
     * @param path Directorio donde se va a comprobar o crear carpeta
     * @param Carpeta nombre de la carpeta
     */
    public static void crearCarpeta(String path, String Carpeta) {

        File archivo = new File(path + "\\" + Carpeta);

        if (!archivo.exists()) {
            archivo.mkdir();
            System.out.println("Ha sido creado con exito el directorio " + Carpeta);
        } else {
            System.out.println("El directorio " + Carpeta + " ya existe ");
        }
    }

}
