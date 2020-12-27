
public class Personaje {
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private Localizacion localizacionObjetivo;
    private Localizacion localizacionActual;
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

    public void setLocalizacionObjetivo(Localizacion localizacionObjetivo) {
        this.localizacionObjetivo = localizacionObjetivo;
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

    public Localizacion getLocalizacionObjetivo() {
        return localizacionObjetivo;
    }

    public Objeto getObjetoObjetivo() {
        return objetoObjetivo;
    }

    public Localizacion getLocalizacionActual() {
        return localizacionActual;
    }
}
