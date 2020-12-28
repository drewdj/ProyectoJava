import java.util.ArrayList;

public class Localizacion {
    private String nombre;
    private ArrayList<Personaje> personajesPresentes;
    private int numPersonajePresente;
    private Objeto objetoPresente;
    private String conexiones;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoPresente(Objeto objetoPresente) {
        this.objetoPresente = objetoPresente;
    }


    public void setConexiones(String conexiones) {
        this.conexiones = conexiones;
    }

    public void setNumPersonajePresente(int numPersonajePresente) {
        this.numPersonajePresente = numPersonajePresente;
    }

    public void setPersonajesPresentes(ArrayList<Personaje> personajesPresentes) {
        this.personajesPresentes = personajesPresentes;
    }

    public String getNombre() {
        return nombre;
    }

    public Objeto getObjetoPresente() {
        return objetoPresente;
    }

    public String getConexiones() {
        return conexiones;
    }

    public ArrayList<Personaje> getPersonajesPresentes() {
        return personajesPresentes;
    }

    public int getNumPersonajePresente() {
        return numPersonajePresente;
    }
}
