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
    public void inicializarCreencias(ArrayList<Objeto> objeto, ArrayList<String> string, ArrayList<Personaje> personaje){
        this.creencias.setObjetosConocidos(objeto);
        this.creencias.setPersonajesConocidos(personaje);
        this.creencias.setLocalizacionesConocidas(string);
    }
    public void buscarObjetoEnLocalizacion(){
        try {
            if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getObjetoPresente().getNombre())){
                //coger objeto

                System.out.println("cogiendo el objeto de " + this.getLocalizacionActual().getNombre());
                CogerObjeto();
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
        int creenciasActuales = this.getCreencias().getLocalizacionesConocidas().size();
        outer:
        for (int i = 0; i < this.localizacionActual.getNumConexiones(); i++) {
            for (int j = 0; j < creenciasActuales; j++) {
                if (!this.getCreencias().getLocalizacionesConocidas().get(j).equals(this.localizacionActual.getConexiones(i))){
                    //moverse a esa localizacion
                    System.out.println("me quiero mover a " + this.localizacionActual.getConexiones(i));
                    break outer;
                }
            }
        }
    }

    public void actualizarObjetosConocidos(){
        int comprobador1;
        int comprobador2 = 0;
        int comprobador3 = 0;
        int creenciasActuales = this.getCreencias().getObjetosConocidos().size();
        if (this.creencias.getObjetosConocidos().isEmpty()){
            if (this.objetoActual!=null){//comprueba el objeto actual
                this.creencias.addObjeto(this.objetoActual);
            }else if (this.localizacionActual.getObjetoPresente()!=null){//comprueba el objeto presente
                this.creencias.addObjeto(this.localizacionActual.getObjetoPresente());
            }else if (!this.localizacionActual.getPersonajesPresentes().isEmpty()){//comprueba los objetos de los jugadores presentes
                for (int i = 0; i < this.localizacionActual.getPersonajesPresentes().size(); i++) {
                    comprobador1=0;
                    for (int j = 0; j < creenciasActuales; j++) {
                        if (!this.creencias.getObjetosConocidos().get(j).getNombre().equals(this.localizacionActual.getPersonajesPresentes().get(i).getObjetoActual().getNombre())){
                            comprobador1++;
                        }
                    }
                    if (comprobador1 == creenciasActuales){
                        this.creencias.addObjeto(this.localizacionActual.getPersonajesPresentes().get(i).getObjetoActual());
                    }
                }

            }
        }else {
            for (int i = 0; i < creenciasActuales; i++) {
                if (this.objetoActual!=null){
                    if (this.creencias.getObjetosConocidos().get(i).equals(this.objetoActual)){
                        comprobador2++;
                    }
                    if (comprobador2 == creenciasActuales){
                        this.creencias.addObjeto(this.objetoActual);
                    }
                }

                if (this.localizacionActual.getObjetoPresente()!=null){
                    if ((this.creencias.getObjetosConocidos().get(i).equals(this.localizacionActual.getObjetoPresente()))){
                        comprobador3++;
                    }
                    if (comprobador3 == creenciasActuales){
                        this.creencias.addObjeto(this.localizacionActual.getObjetoPresente());
                    }
                }

                if (!this.localizacionActual.getPersonajesPresentes().isEmpty()){//comprueba los objetos de los jugadores presentes
                    for (int p = 0; p < this.localizacionActual.getPersonajesPresentes().size(); p++) {
                        comprobador1=0;
                        for (int j = 0; j < creenciasActuales; j++) {
                            if (!this.creencias.getObjetosConocidos().get(j).getNombre().equals(this.localizacionActual.getPersonajesPresentes().get(p).getObjetoActual().getNombre())){
                                comprobador1++;
                            }
                        }
                        if (comprobador1 == creenciasActuales){
                            this.creencias.addObjeto(this.localizacionActual.getPersonajesPresentes().get(p).getObjetoActual());
                        }
                    }

                }

            }
        }
    }

    public void actualizarLocalizacionesConocidas(){//colocar en movimiento para que se actualice al cambiar de sala
        int comprobador = 0;
        int creenciasActuales = this.getCreencias().getLocalizacionesConocidas().size();
        if (this.getCreencias().getLocalizacionesConocidas().isEmpty()){
            this.creencias.addLocalizacion(this.localizacionActual.getNombre());
        }else {
            for (int i = 0; i < creenciasActuales; i++) {
                if (!this.getCreencias().getLocalizacionesConocidas().get(i).equals(this.localizacionActual.getNombre())){
                    comprobador++;
                }
                if (comprobador == creenciasActuales){
                    this.creencias.addLocalizacion(this.localizacionActual.getNombre());
                }
            }
        }

    }
}
