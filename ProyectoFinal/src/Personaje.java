import java.util.ArrayList;

public class Personaje {
    private int accion;
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private String localizacionObjetivo;
    private Localizacion localizacionActual;
    private Creencias creencias;
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

    public void CogerObjeto(){
        Objeto cambio;
        cambio=this.getObjetoActual();
        this.setObjetoActual(this.getLocalizacionActual().getObjetoPresente());
        this.getLocalizacionActual().setObjetoPresente(cambio);
    }
    public void setNombreLocalizacionInicial(String nombreLocalizacion){
        this.localizacionActual.setNombre(nombreLocalizacion);
    }
    public void inicializarCreencias(ArrayList<Objeto> objeto, ArrayList<Localizacion> localizacion, ArrayList<Personaje> personaje){
        this.creencias.setObjetosConocidos(objeto);
        this.creencias.setPersonajesConocidos(personaje);
        this.creencias.setLocalizacionesConocidas(localizacion);
    }
    public void buscarObjetoEnLocalizacion(){
        try {
            if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getObjetoPresente().getNombre())){
                //coger objeto

                System.out.println("cogiendo el objeto de " + this.getLocalizacionActual().getNombre());
                this.accion++;
            }else {
                System.out.println("No hay ningun objeto interesante en " + this.getLocalizacionActual().getNombre());
            }
        }catch (Exception e){
            //no hay objeto en la localizacion
            System.out.println("No hay ningun objeto interesante en " + this.getLocalizacionActual().getNombre());
        }

    }
    public void buscarObjetoEnPersonajes(){
        try {
            for (int i = 0; i < this.getLocalizacionActual().getPersonajesPresentes().size(); i++) {
                if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre())){
                    //coger objeto de personaje
                    System.out.println("cogiendo el objeto de " + this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre());
                    this.accion++;
                }else {
                    System.out.println(this.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre() + " no tiene ningun objeto interesante");
                }
            }
        }catch (Exception e){
            System.out.println("Nada interesante en los personajes de " + this.getLocalizacionActual().getNombre());
            //no hay objeto en el personaje
            //o no hay nadie mas en sala
        }
    }
    public void moverseHaciaObjeto(){
        System.out.println("voy a moverme");
    }

    public void actualizarObjetosConocidos(){
        int comprobador = 0;
        int creenciasActuales = this.getCreencias().getObjetosConocidos().size();
        for (int j = 0; j <= creenciasActuales; j++) {
            if (this.getCreencias().getObjetosConocidos().isEmpty()){//si creencias esta vacio se asigna automaticamente el objeto en sala a no ser que la sala no tenga objeto

                try{
                    if (this.getLocalizacionActual().getObjetoPresente().equals(null)){

                    }else {
                        this.getCreencias().addObjeto(this.getLocalizacionActual().getObjetoPresente());//falta cambiar a una copia del objeto
                    }
                }catch (Exception e){

                }
            }else {
                try{
                    if (!this.getCreencias().getObjetosConocidos().get(j).getNombre().equals(this.getLocalizacionActual().getObjetoPresente().getNombre()))
                        comprobador++;
                }catch (Exception e){
                    comprobador++;
                }
                if (comprobador == this.getCreencias().getObjetosConocidos().size()){
                    this.getCreencias().addObjeto(this.getLocalizacionActual().getObjetoPresente());//falta cambiar a una copia del objeto
                }
            }
        }
    }

    public void actualizarPersonajesConocidos(){
        int creenciasActuales = this.getCreencias().getPersonajesConocidos().size();
        int comprobador = 0;






    }
    public void actualizarLocalizacionesConocidas(){

    }
}
