public class Objeto {
    private String nombre;
    private Localizacion localizacionActual;
    private Personaje personajeActual;

    public Objeto(){

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalizacionActual(Localizacion localizacionActual) {
        this.localizacionActual = localizacionActual;
    }

    public void setPersonajeActual(Personaje personajeActual) {
        this.personajeActual = personajeActual;
    }

    public String getNombre() {
        return nombre;
    }

    public Localizacion getLocalizacionActual() {
        return localizacionActual;
    }

    public Personaje getPersonajeActual() {
        return personajeActual;
    }

    public Objeto(Objeto another){
        this.nombre = another.nombre;
        this.localizacionActual = another.localizacionActual;
        this.personajeActual = another.personajeActual;
    }


}
