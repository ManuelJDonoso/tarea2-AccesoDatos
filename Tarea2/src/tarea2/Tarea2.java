/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 */
public class Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TransformerException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el apartado que desea ejecutar");
       //int i = sc.nextInt();
        int i=8;
        switch (i) {
            case 1:

                Apartado1 ejemplo1 = new Apartado1();

                ejemplo1.addDirectorioActual(".\\");

                ejemplo1.getArcDir();
                System.out.println("");
                System.out.println("");
                Directorio.crearCarpeta(".\\src", "Prueba");
                break;
            case 2:

                Apartado2 ejemplo2 = new Apartado2();
                ejemplo2.tarea2();
                break;

            case 3:
                Apartado3 ejemplo3 = new Apartado3();
                ejemplo3.crearDirectorio();
                ejemplo3.EscribirTextoFichero();
                ejemplo3.MostrarContenidoFicheroConsola();
                break;

            case 4:
                Apartado4 ejemplo4 = new Apartado4();
                ejemplo4.Escribir();
                break;

            case 5:
                Apartado5 ejemplo5 = new Apartado5();
                ejemplo5.Mostrar();
                break;
            case 6:
                Apartado6 ejemplo6 = new Apartado6();
                ejemplo6.CrearDirectorio();
                ejemplo6.Escribir();
                break;

            case 7:
                Apartado7 ejemplo7 = new Apartado7();
                ejemplo7.Leer();
                break;

            case 8:
                Apartado8 ejemplo8;
                try {
                    ejemplo8 = new Apartado8();
                    ejemplo8.generarDocument();
                    ejemplo8.generarXml();
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Tarea2.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 9:
                
                break;
        }
     
    }

}
