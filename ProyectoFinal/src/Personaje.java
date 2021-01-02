import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private String localizacionObjetivo;
    private Localizacion localizacionActual;
    private Creencias creencias;
    private String quienPide;
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
    		quienPide = personaje.getNombre();
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
