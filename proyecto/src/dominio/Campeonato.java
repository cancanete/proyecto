package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campeonato implements Serializable {
    private String nombre;
    private List<Competidor> competidores;

    public Campeonato(String nombre) {
        this.nombre = nombre;
        this.competidores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Competidor> getcompetidores() {
        return competidores;
    }

    public void agregarCompetidor(Competidor competidor) {
        competidores.add(competidor);
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "nombre='" + nombre + '\'' +
                ", competidores=" + competidores +
                '}';
    }
}
