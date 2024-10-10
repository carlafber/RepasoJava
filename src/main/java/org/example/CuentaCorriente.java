package org.example;

import java.util.*;

public abstract class CuentaCorriente extends CuentaBancaria {
    ArrayList<String> listaEntidades;

    public CuentaCorriente(Persona titular, double saldo, String iban, ArrayList<String> listaEntidades) {
        super(titular, saldo, iban);
        this.listaEntidades = new ArrayList<>();
    }

    public CuentaCorriente(Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
    }

    //Metodo para agregar una entidad autorizada
    public void agregarEntidad(String entidad) {
        listaEntidades.add(entidad);
    }

    //Metodo para eliminar una entidad autorizada
    public boolean eliminarEntidad(String entidad) {
        return listaEntidades.remove(entidad);
    }

    //Metodo para obtener la lista de entidades autorizadas
    public ArrayList<String> getEntidades() {
        return listaEntidades;
    }

    //Metodo para devolver la lista de entidades como un String
    public String listaEntidadestoString() {
        return String.join(", ", listaEntidades);
    }

    @Override
    public abstract String devolverInfoString();
}
