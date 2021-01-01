import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private String localizacionObjetivo;
    private Localizacion localizacionActual;
    private Creencias creencias;
    private int flagPedir;
    private int turno;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoActual(Objeto objetoActual) {

        this.objetoActual = objetoActual;
    }

    public void setObjetoObjetivo(Objeto objetoObjetivo) {
        this.objetoObjetivo = objetoObjetivo;
    }

    public void setLocalizacionObjetivo(String localizacionObjetivo) {
        this.localizacionObjetivo = localizacionObjetivo;
    }

    public void setCreencias(Creencias creencias) {
        this.creencias = creencias;
    }

    public void setLocalizacionActual(Localizacion localizacionActual) {
        this.localizacionActual = localizacionActual;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTurno() {
        return turno;
    }
   
    public Objeto getObjetoActual() {
        return objetoActual;
    }
    
    public void pedirObjeto(Personaje personaje) {
    	if(personaje.getLocalizacionActual().getNombre().equals(this.getLocalizacionActual().getNombre())) {
    		personaje.flagPedir = 1;
    		//Cuando se coge el objeto se debe de restaurar a 0 (¿Es necesario que el flag se unico?, es decir, si hay 4 
    		//personas en la misma sala y se piden objetos los cuatro como saben con quien tienen que intercambiar si el
    		//flag de los cuatro es 1), en el caso de que se quiera cambiar, es crear una variable int donde se guarde 
    		//un numero aleatorio y asignarlo a los dos flags, pero habría que crear otro flag mas para indicar cual es
    		//el personaje que pide y cual es el que recibe la peticion.
    	}
    }

    public String getLocalizacionObjetivo() {
        return localizacionObjetivo;
    }

    public Objeto getObjetoObjetivo() {
        return objetoObjetivo;
    }

    public Localizacion getLocalizacionActual() {
        return localizacionActual;
    }

    public Creencias getCreencias() {
        return creencias;
    }
}
