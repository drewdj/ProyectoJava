import java.util.ArrayList;
import java.util.Random;

public class Personaje {
    private int accion; //Limita las acciones
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private String localizacionObjetivo;
    private ArrayList<String> historial;
    protected Localizacion localizacionActual;
    private String quienPide;  //Se activa para saber quien te esta pidiendo un objeto
    private Creencias creencias;
    private int fin;
    private int turno; //Ordenacion aleatoria

    public void setFin(int fin) {
        this.fin = fin;
    }

    public void setQuienPide(String quienPide) {
        this.quienPide = quienPide;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHistorial(ArrayList<String> historial) {
        this.historial = historial;
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

    public int getFin() {
        return fin;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public String getQuienPide() {
        return quienPide;
    }

    public void CogerObjeto(){  //Intercambia el objeto del suelo por el propio
        Objeto cambio;
        cambio=this.getObjetoActual();
        this.setObjetoActual(this.getLocalizacionActual().getObjetoPresente());
        this.getLocalizacionActual().setObjetoPresente(cambio);
        this.historial.add("He cogido " + getObjetoActual().getNombre() + " de " + getLocalizacionActual().getNombre());
    }

    public void darObjeto(Personaje personaje) { //Despues de que alguien pida un objeto se usa darObjeto para intercambiar ambos, en caso de que el propietario no lo quiera
        Objeto temp;

            if(personaje.getLocalizacionActual().getNombre().equals(this.localizacionActual.getNombre())) {
                if(personaje.getNombre().equals(this.quienPide)) {
                    temp = personaje.objetoActual;
                    personaje.setObjetoActual(this.getObjetoActual());
                    this.setObjetoActual(temp);
                    //this.setAccion(1);  //Si dar un objeto cuenta como una accion descomentar
                    this.setQuienPide(null);
                    this.historial.add("Le he dado " + personaje.getObjetoActual().getNombre() + " a " + personaje.getNombre());
                }
            }
    }

    public void pedirObjeto(Personaje personaje) {//Activa un flag en el personaje objetivo para que te de su objeto en el turno siguiente


        if (personaje.getLocalizacionActual().getNombre().equals(this.getLocalizacionActual().getNombre())) {
            personaje.quienPide = this.getNombre();
            this.historial.add("Le he pedido " + personaje.getObjetoActual().getNombre() + " a " + personaje.getNombre());
        }


    }

    public void inicializarCreencias(ArrayList<Localizacion> localizacion){
        this.creencias.setLocalizacionesConocidas(localizacion);
    }
    public void buscarObjetoEnLocalizacion(){//Compara el objeto de la localizacion con el objetivo y lo coge
        try {
            if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getObjetoPresente().getNombre())){
                //coger objeto

                CogerObjeto();
                this.accion++;
            }
        }catch (Exception e){
            //no hay objeto en la localizacion
        }

    }
    public void buscarObjetoEnPersonajes(){//Compara el objeto de los personajes presentes con el objetivo y se lo pide
        try {
            for (int i = 0; i < this.getLocalizacionActual().getPersonajesPresentes().size(); i++) {
                if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre())){
                    //coger objeto de personaje
                    this.pedirObjeto(this.getLocalizacionActual().getPersonajesPresentes().get(i));
                    this.accion++;
                    break;
                }else {
                }
            }
        }catch (Exception e){
            //no hay objeto en el personaje
            //o no hay nadie mas en sala
        }
    }
    public String  moverseHaciaLocalizacion(Localizacion[] arrayLocalizaciones){//Busca en sus localizaciones conocidas para encontrar su posicion objetivo y en caso de no encontrarla se mueve al azar
        for (int i = 0; i < this.creencias.getLocalizacionesConocidas().size(); i++) {
            if (this.getLocalizacionActual().getNombre().equals(this.creencias.getLocalizacionesConocidas().get(i).getNombre())){
                for (int j = 0; j < this.creencias.getLocalizacionesConocidas().size(); j++) {
                    if (this.localizacionObjetivo.equals(this.creencias.getLocalizacionesConocidas().get(i).getConexiones(j)))
                        return this.creencias.getLocalizacionesConocidas().get(i).getConexiones(j);
                }
            }
        }
        for (int i = 0; i < this.creencias.getLocalizacionesConocidas().size(); i++) {
            for (int j = 0; j < this.getLocalizacionActual().getNumConexiones(); j++) {
                if (this.getLocalizacionActual().getConexiones(i).equals(this.creencias.getLocalizacionesConocidas().get(j).getNombre())){
                    for (int k = 0; k < this.creencias.getLocalizacionesConocidas().get(j).contarConexiones(); k++) {
                        if (this.creencias.getLocalizacionesConocidas().get(j).getConexiones(k).equals(this.localizacionObjetivo))
                            return this.creencias.getLocalizacionesConocidas().get(j).getConexiones(k);
                    }

                }
            }

        }

        int random = new Random().nextInt(localizacionActual.getNumConexiones());
        return this.localizacionActual.getConexiones(random);
    }


    public String moverseHaciaObjeto(){//Se mueve priorizando las salas en las que no ha estado para encontrar nuevos objetos
        int contador;
        int creenciasActuales = this.getCreencias().getLocalizacionesConocidas().size();

        for (int i = 0; i < this.localizacionActual.getNumConexiones(); i++) {
            contador = 0;
            for (int j = 0; j < creenciasActuales; j++) {
                if (!this.getCreencias().getLocalizacionesConocidas().get(j).getNombre().equals(this.localizacionActual.getConexiones(i))){
                    contador++;
                }
                if (contador == creenciasActuales){

                    return this.localizacionActual.getConexiones(i);
                }
            }
        }
        int random = new Random().nextInt(localizacionActual.getNumConexiones());
        return this.localizacionActual.getConexiones(random);
    }

    public void mover(Localizacion localizacionMover) {//Se borra a si mismo de la localizacion actual y se añade en la objetivo
    outer:
        for(int i = 0; i < localizacionActual.contarConexiones(); i++) {
            if(localizacionMover.getNombre().equals(localizacionActual.getConexiones(i))) {
                for(int c = 0; c < localizacionActual.getPersonajesPresentes().size(); c++) {
                    if(localizacionActual.getPersonajesPresentes().get(c).getNombre().equals(this.getNombre())) {
                        localizacionActual.removePersonajePresente(c);
                        this.localizacionActual = localizacionMover;
                        localizacionActual.addPersonajePresente(this);
                        actualizarLocalizacionesConocidas();
                        this.historial.add("Me he movido a " + localizacionActual.getNombre());
                        break outer;
                    }
                }
            }
        }
    }


    public void actualizarLocalizacionesConocidas(){//colocar en movimiento para que se actualice al cambiar de sala y resetear cuando se llegue al maximo
        int comprobador = 0;
        int creenciasActuales = this.getCreencias().getLocalizacionesConocidas().size();

        if (this.getCreencias().getLocalizacionesConocidas().isEmpty()){
            this.creencias.addLocalizacion(this.localizacionActual);//hacer copia de la localizacion
        }else {
            for (int i = 0; i < creenciasActuales; i++) {
                if (!this.getCreencias().getLocalizacionesConocidas().get(i).getNombre().equals(this.localizacionActual.getNombre())){
                    comprobador++;
                }
                if (comprobador == creenciasActuales){
                    this.creencias.addLocalizacion(this.localizacionActual);
                }
            }
        }

    }
}
