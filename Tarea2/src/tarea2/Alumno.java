/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

/**
 *
 * @author Manuel Jesús Donoso Pérez
 */
public class Alumno {

    private String apellido;
    private int edad;
    private double nota;

    public Alumno(String apellido, int edad, double nota) {
        this.apellido = apellido;
        this.edad = edad;
        this.nota = nota;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getNota() {
        return nota;
    }
}
