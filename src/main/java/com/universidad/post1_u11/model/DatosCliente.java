package com.universidad.post1_u11.model;

public class DatosCliente {
    private final String nombre;
    private final String email;
    private final String telefono;
    private final Direccion direccion; // otro Value Object

    public DatosCliente(String nombre, String email, String telefono, Direccion direccion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email invalido");
        }
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // getters, equals, hashCode (inmutable por diseno)
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosCliente that = (DatosCliente) o;
        return nombre.equals(that.nombre) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() * 31 + email.hashCode();
    }
}