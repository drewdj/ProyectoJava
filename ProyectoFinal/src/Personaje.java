import java.util.ArrayList;
import java.util.Random;

public class Personaje {
    private int accion; //Limita las acciones
    private String nombre;
    private Objeto objetoActual;
    private Objeto objetoObjetivo;
    private String localizacionObjetivo;
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

    public String getQuienPide() {
        return quienPide;
    }

    public void CogerObjeto(){  //Intercambia el objeto del suelo por el propio
        Objeto cambio;
        cambio=this.getObjetoActual();
        this.setObjetoActual(this.getLocalizacionActual().getObjetoPresente());
        this.getLocalizacionActual().setObjetoPresente(cambio);
    }

    public void darObjeto(Personaje personaje) { //Despues de que alguien pida un objeto se usa darObjeto para intercambiar ambos
        Objeto temp;

            if(personaje.getLocalizacionActual().getNombre().equals(this.localizacionActual.getNombre())) {
                if(personaje.getNombre().equals(this.quienPide)) {
                    System.out.println("Le voy a dar "+ this.getObjetoActual().getNombre() + " a " + personaje.getNombre());
                    temp = personaje.objetoActual;
                    personaje.setObjetoActual(this.getObjetoActual());
                    this.setObjetoActual(temp);
                    //this.setAccion(1);  //Si dar un objeto cuenta como una accion descomentar
                    this.setQuienPide(null);
                }
            }
    }

    public void pedirObjeto(Personaje personaje) {


        if (personaje.getLocalizacionActual().getNombre().equals(this.getLocalizacionActual().getNombre())) {
            personaje.quienPide = this.getNombre();
        }


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
                System.out.println(this.getObjetoObjetivo().getNombre() + this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre());
                if (this.getObjetoObjetivo().getNombre().equals(this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre())){
                    //coger objeto de personaje
                    System.out.println("Le he pedido " + this.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre() + " a " + this.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre());
                    this.pedirObjeto(this.getLocalizacionActual().getPersonajesPresentes().get(i));
                    this.accion++;
                    break;
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
    public String  moverseHaciaLocalizacion(Localizacion[] arrayLocalizaciones){
        for (int i = 0; i < localizacionActual.getNumConexiones(); i++) {
            if (localizacionObjetivo.equals(localizacionActual.getConexiones(i))){
                System.out.println("Me muevo a " + localizacionActual.getConexiones(i));
                return localizacionActual.getConexiones(i);
            }

        }
        for (int i = 0; i < localizacionActual.getNumConexiones(); i++) {
            for (int j = 0; j < arrayLocalizaciones.length; j++) {
                if (localizacionObjetivo.equals(arrayLocalizaciones[j].getNombre())){
                    System.out.println("Me muevo a " + localizacionActual.getConexiones(i));
                    return localizacionActual.getConexiones(i);
                }
            }
        }
        return null;
    }


    public String moverseHaciaObjeto(){
        int contador;
        int creenciasActuales = this.getCreencias().getLocalizacionesConocidas().size();

        for (int i = 0; i < this.localizacionActual.getNumConexiones(); i++) {
            contador = 0;
            for (int j = 0; j < creenciasActuales; j++) {
                //System.out.println("Es " + this.getCreencias().getLocalizacionesConocidas().get(j).getNombre() + " diferente de " + this.localizacionActual.getConexiones(i));
                if (!this.getCreencias().getLocalizacionesConocidas().get(j).getNombre().equals(this.localizacionActual.getConexiones(i))){
                    contador++;
                }
                if (contador == creenciasActuales){
                    System.out.println("Me quiero mover hacia " + this.localizacionActual.getConexiones(i));
                    return this.localizacionActual.getConexiones(i);
                }
            }
        }
        int random = new Random().nextInt(localizacionActual.getNumConexiones());
        System.out.println("Me quiero mover 2 hacia " + this.localizacionActual.getConexiones(random));

        return this.localizacionActual.getConexiones(random);
    }

    public void mover(Localizacion localizacionMover) {
    outer:
        for(int i = 0; i < localizacionActual.contarConexiones(); i++) {
            //System.out.println("if " + localizacionMover.getNombre() + " igual a " + localizacionActual.getConexiones(i));
            if(localizacionMover.getNombre().equals(localizacionActual.getConexiones(i))) {
                for(int c = 0; c < localizacionActual.getPersonajesPresentes().size(); c++) {
                    //System.out.println("if " + localizacionActual.getPersonajesPresentes().get(c).getNombre() + " igual a " + this.getNombre());
                    if(localizacionActual.getPersonajesPresentes().get(c).getNombre().equals(this.getNombre())) {
                        System.out.println("Vengo de " + localizacionActual.getNombre());
                        localizacionActual.removePersonajePresente(c);
                        this.localizacionActual = localizacionMover;
                        localizacionActual.addPersonajePresente(this);
                        actualizarLocalizacionesConocidas();
                        System.out.println("\n*\nSoy " + this.getNombre() + " y "+ "Estoy en " + localizacionActual.getNombre());
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
