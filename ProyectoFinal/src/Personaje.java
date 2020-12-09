
public class Personaje {
    String nombre;
    String objetoActual;
    String objetoObjetivo;
    String localizacionActual;
    String localizacionObjetivo;

    String[] localizacionesAlcanzables;
    String[] objetosPresentes;
    String[] personajesObjetos;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoActual(String objetoActual) {
        this.objetoActual = objetoActual;
    }

    public void setObjetoObjetivo(String objetoObjetivo) {
        this.objetoObjetivo = objetoObjetivo;
    }

    public void setLocalizacionActual(String localizacionActual) {
        this.localizacionActual = localizacionActual;
    }

    public void setLocalizacionObjetivo(String localizacionObjetivo) {
        this.localizacionObjetivo = localizacionObjetivo;
    }

    public void setLocalizacionesAlcanzables(String[] localizacionesAlcanzables) {
        this.localizacionesAlcanzables = localizacionesAlcanzables;
    }

    public void setObjetosPresentes(String[] objetosPresentes) {
        this.objetosPresentes = objetosPresentes;
    }

    public void setPersonajesObjetos(String[] personajesObjetos) {
        this.personajesObjetos = personajesObjetos;
    }

    public void actualizacion(String[] localizacionesAlcanzables,String[] objetosPresentes,String[] personajesObjetos){
    //recibir localizaciones alcanzables, objetos presentes, perrsonajes presentes, objetos de los personajes
        this.localizacionesAlcanzables= localizacionesAlcanzables;
        this.objetosPresentes=objetosPresentes;
        this.personajesObjetos=personajesObjetos;

    }
    static void decision(){
    //En funcion de la informacion recibida tomar una accion correspondiente
    }


}
