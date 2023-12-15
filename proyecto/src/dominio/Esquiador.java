package dominio;

import java.io.Serializable;

public class Esquiador extends Competidor implements Serializable {
    private String tipoEsqui;

    public Esquiador(String nombre, String tipoEsqui) {
        super(nombre);
        this.tipoEsqui = tipoEsqui;
    }

    public String getTipoEsqui() {
        return tipoEsqui;
    }

    @Override
    public String toString() {
        return "Esquiador{" +
                "nombre='" + getNombre() + '\'' +
                ", tipoEsqui='" + tipoEsqui + '\'' +
                '}';
    }
}
