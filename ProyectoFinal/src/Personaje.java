//import java.util.ArrayList;

public class Personaje {
    private int accion;
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

    public void setAccion(int accion) {
        this.accion = accion;
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
    		personaje.quienPide = this.getNombre();
    	}
    }

    public String getLocalizacionObjetivo() {
        return localizacionObjetivo;
    }

    public Objeto getObjetoObjetivo() {
        return objetoObjetivo;
    }

    public int getAccion() {
        return accion;
    }

    public Localizacion getLocalizacionActual() {
        return localizacionActual;
    }

    public Creencias getCreencias() {
        return creencias;
    }

    public void darObjeto(Personaje personaje) {
    	if(personaje.getLocalizacionActual().getNombre().equals(this.getObjetoActual().getNombre())) {
    		if(personaje.getNombre().equals(this.quienPide)) {
    			personaje.setObjetoActual(this.getObjetoActual());
    			this.setObjetoActual(null);
    		}
    	}
    }

    public void mover(Localizacion localizacionMover) {
    	for(int i = 0; i < localizacionActual.contarConexiones(); i++) {
    		if(localizacionMover.getNombre().equals(localizacionActual.getConexiones(i))) {
    			for(int c = 0; c < localizacionActual.getPersonajesPresentes().size(); c++) {
    				if(localizacionActual.getPersonajesPresentes().get(c).getNombre().equals(this.getNombre())) {
    					localizacionActual.removePersonajePresente(c);
    					this.localizacionActual = localizacionMover;
    					localizacionActual.addPersonajePresente(this);
    				}
    			}
    		}
    	}
    }
}
