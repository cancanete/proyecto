package dominio;

import java.io.Serializable;

public class Competidor implements Serializable {
    private String nombre;

    public Competidor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
