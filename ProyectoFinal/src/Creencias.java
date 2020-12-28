import java.util.ArrayList;

public class Creencias {
    private int numObjetosConocidos;
    private ArrayList<Objeto> objetosConocidos;
    private ArrayList<Localizacion> localizacionesConocidas;
    private ArrayList<Personaje>    personajesConocidos;

    public void setLocalizacionesConocidas(ArrayList<Localizacion> localizacionesConocidas) {
        this.localizacionesConocidas = localizacionesConocidas;
    }

    public void setObjetosConocidos(ArrayList<Objeto> objetosConocidos) {
        this.objetosConocidos = objetosConocidos;
    }

    public void setPersonajesConocidos(ArrayList<Personaje> personajesConocidos) {
        this.personajesConocidos = personajesConocidos;
    }

    public ArrayList<Localizacion> getLocalizacionesConocidas() {
        return localizacionesConocidas;
    }

    public ArrayList<Objeto> getObjetosConocidos() {
        return objetosConocidos;
    }

    public ArrayList<Personaje> getPersonajesConocidos() {
        return personajesConocidos;
    }
}
