/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 * 
 * 5. (1 punto) Mostrar la información del fichero binario empleados.dat de forma secuencial creado anteriormente.
 */
public class Apartado5 {
      // Ruta del fichero binario
        String rutaFichero = "empleados.dat";

    public Apartado5() {
    }
        
    public void Mostrar(){
     // Leer la información del fichero binario
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(rutaFichero))) {
            // Leer la cantidad de departamentos
            int numDepartamentos = dataInputStream.readInt();

            // Leer y mostrar la información de cada departamento
            for (int i = 0; i < numDepartamentos; i++) {
                String departamento = dataInputStream.readUTF();
                int numEmpleados = dataInputStream.readInt();

                System.out.println("Departamento: " + departamento + ", Número de empleados: " + numEmpleados);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero binario: " + e.getMessage());
        }
    }
    
}
