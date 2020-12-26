public class Localizacion {
    private String nombre;
    private Personaje personajePresente[];
    private Objeto objetoPresente;
    private String conexiones;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoPresente(Objeto objetoPresente) {
        this.objetoPresente = objetoPresente;
    }

    public void setPersonajePresente(Personaje[] personajePresente) {
        this.personajePresente = personajePresente;
    }

    public void setConexiones(String conexiones) {
        this.conexiones = conexiones;
    }

    public String getNombre() {
        return nombre;
    }

    public Personaje[] getPersonajePresente() {
        return personajePresente;
    }

    public Objeto getObjetoPresente() {
        return objetoPresente;
    }

    public String getConexiones() {
        return conexiones;
    }
}
