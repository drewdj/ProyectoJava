import java.util.ArrayList;

public class GestorPrueba {
    public static void main(String[] args) {

        int numPersonajes = 4;
    String[] personajesString = new String[numPersonajes];

    personajesString[0]="Pedro(cocina)";

     /*     PRUEBAS
            Localizacion comedor = new Localizacion();
            comedor.setNombre("Comedor");


            Localizacion jardin = new Localizacion();
            jardin.setNombre("Jardin");

        Localizacion cocina = new Localizacion();
        Localizacion dormitorio = new Localizacion();

            Localizacion[] prueba = {jardin,cocina,dormitorio};
            comedor.setConexiones(prueba);

            prueba[0].getNombre();

            Objeto cartera = new Objeto();
            cartera.setNombre("Cartera");

            Objeto pan = new Objeto();
            pan.setNombre("Pan");

            Personaje jorge = new Personaje();

            jorge.setNombre("Jorge");
            jorge.setObjetoObjetivo(cartera);
            jorge.setObjetoActual(pan);
            jorge.setLocalizacionObjetivo(jardin);
            jorge.setLocalizacionActual(comedor);


        System.out.println(cartera.getNombre());
        System.out.println(jorge.getObjetoObjetivo().getNombre());*/
    Personaje pedro = new Personaje();
    Personaje[] NPC = new Personaje[3];


            String[] prueba = {"Jorge","Esther","Maria"};

        for (int i = 0; i < 3; i++) {
            NPC[i] = new Personaje();
            NPC[i].setNombre(prueba[i]);
            System.out.println(NPC[i].getNombre());
        }

        ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();


    /* leer personajes contar numero de personajes
    bucle i=numero de personajes para crear la clase Personaje y asignar nombre y localizacion
     */

    /*
    mismo bucle para localizaciones y objetos
     */

     /*
        bucle para asignar objetivos ObjetoObjetivo y LocalizacionObjetivo
     */

    //definir turno

     /*
        Comprobar objetivos
        Comprobar entorno
        Realizar accion(coger objeto,pedir objeto, moverse)
        siguiente turno
     */

        /*if (jorge.getObjetoObjetivo().getNombre()==jorge.getObjetoActual().getNombre()){
            System.out.println("Jorge tiene su objeto");
        }else if (jorge.getObjetoObjetivo().getNombre()!=jorge.getObjetoActual().getNombre()){
            System.out.println("Jorge no tiene su objeto");
        }

        if (jorge.getLocalizacionActual().getNombre()==jorge.getLocalizacionObjetivo().getNombre()){
            System.out.println("Jorge esta en la posicion deseada");
        }else if (jorge.getLocalizacionActual().getNombre()!=jorge.getLocalizacionObjetivo().getNombre()){
            System.out.println("Jorge no esta en la posicion deseada");
        }*/



    }
}
