package org.example;

public class Persona implements Imprimible{
    //atributos de la clase
    String nombre;
    String apellidos;
    String dni;

    //constructor para inicializar los atributos
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y devuelve la información completa de la persona en formato de cadena
    @Override
    public String devolverInfoString() {
        return nombre + " " + apellidos + " (DNI: " + dni + ")";
    }
}

