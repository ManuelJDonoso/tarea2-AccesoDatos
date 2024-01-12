/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 *
 * 8. (1,5 puntos) Continua en el proyecto y crea un fichero o clase llamado
 * CrearAlumnoXMLconDOM .java para realizar este apartado. Debes hacer lo
 * siguiente: Convierte el fichero binario alumnos.dat, que has creado en el
 * apartado anterior en el directorio prueba, a un fichero XML llamado
 * alumnos.xml usando DOM. Mira el apartado del tema 6.4.3.
 */
public class Apartado8 {

    // Ruta del directorio y nombre de los ficheros
    private String rutaDirectorio = "prueba";
    private String nombreFicheroBinario = "alumnos.dat";
    private String nombreFicheroXML = "alumnos.xml";

    // Objetos Donde se van a cargar los datos
    private ArrayList<Alumno> ddBBAlumnos;

    // Ruta completa de los ficheros
    private String rutaFicheroBinario = rutaDirectorio + File.separator + nombreFicheroBinario;
    private String rutaFicheroXML = rutaDirectorio + File.separator + nombreFicheroXML;

    //objeto que va a contener el document xml
    private Document document;

    public Apartado8() throws ParserConfigurationException {
        //Instanciar objeto document para poder crear el xml
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder buider = factoria.newDocumentBuilder();
        document = buider.newDocument();
        ddBBAlumnos = new ArrayList<>();
        Generar_baseDatos();
    }

    public void generarDocument() {
        //Crear elemento raiz
        //hijo directo de document
        Element Alumnos = document.createElement("Alumnos");
        // Agregar elemento al documento
        //element es del tipo node
        document.appendChild(Alumnos);

        for (Alumno al : ddBBAlumnos) {
            String ap = al.getApellido();
            String ed = al.getEdad() + " ";
            String no = al.getNota() + " ";
            System.out.print(ap);
            System.out.print(ed);
            System.out.println(no);

            Element Estudiante = document.createElement("Estudiante");
            Alumnos.appendChild(Estudiante);

            crearElemento("Apellido", ap, Estudiante, document);
            crearElemento("Edad", "edad", Estudiante, document);
            crearElemento("Nota", "nota", Estudiante, document);

        }

    }

    public void generarXml() throws TransformerConfigurationException, IOException, TransformerException {
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();

        Source source = new DOMSource(document);

        File file = new File(rutaFicheroXML);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result result = new StreamResult(pw);

        //source origen de los datos, result destino de los datos
        transformer.transform(source, result);
    }

    private void Generar_baseDatos() {
        // Leer el contenido del fichero binario aleatoriamente
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(rutaFicheroBinario, "r")) {
            //Calcular el numer de registros
            long longitudFichero = randomAccessFile.length();
            int numRegistros = (int) longitudFichero / 32;

            for (int i = 0; i < numRegistros; i++) {
                //posicion de cada registro
                randomAccessFile.seek(i * 32);
                //leer apellidos
                String apellidos = "";
                for (int j = 0; j < 10; j++) {
                    apellidos += randomAccessFile.readChar();
                }
                //leer edad
                int edad = randomAccessFile.readInt();
                //leer nota
                double nota = randomAccessFile.readDouble();

                ddBBAlumnos.add(new Alumno(apellidos, edad, nota));
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero binario: " + e.getMessage());
        }

    }

    static void crearElemento(String datoAlumno, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoAlumno); //creamos hijo
        Text text = document.createTextNode(valor); // damos valor al campo
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}
