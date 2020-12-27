public class Localizacion {
    private String nombre;
    private Personaje[] personajePresente;
    private Objeto objetoPresente;
    private Localizacion[] conexiones;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoPresente(Objeto objetoPresente) {
        this.objetoPresente = objetoPresente;
    }

    public void setPersonajePresente(Personaje[] personajePresente) {
        this.personajePresente = personajePresente;
    }

    public void setConexiones(Localizacion[] conexiones) {
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

    public Localizacion[] getConexiones() {
        return conexiones;
    }


}
