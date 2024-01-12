/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.IOException;
import java.io.*;
/**
 *
 * @author Manuel Jesús Donoso Pérez
 * 
 * 4. (1 punto) Escribe un fichero binario, en el proyecto, llamado empleados.dat, de manera secuencial. Con la siguiente información:
Departamento "Contabilidad","Informática","Dirección","Análisis","Finanzas","Hardware"
Nº Empleados 3,10,2,5,4,8
 */
public class Apartado4 {
    
       // Ruta del fichero binario
       private  String rutaFichero = "empleados.dat";

        // Datos a escribir
       private String[] departamentos = {"Contabilidad", "Informática", "Dirección", "Análisis", "Finanzas", "Hardware"};
       private int[] numEmpleados = {3, 10, 2, 5, 4, 8};

    public Apartado4() {
    }
        
     public void Escribir(){
     
      // Escribir en el fichero binario
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(rutaFichero))) {
            // Escribir la cantidad de departamentos
            dataOutputStream.writeInt(departamentos.length);

            // Escribir los datos de cada departamento
            for (int i = 0; i < departamentos.length; i++) {
                dataOutputStream.writeUTF(departamentos[i]);
                dataOutputStream.writeInt(numEmpleados[i]);
            }

            System.out.println("Datos escritos en el fichero binario.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero binario: " + e.getMessage());
        }
     
     }
    
}
