import java.util.ArrayList;

public class Localizacion {
    private String nombre;
    private ArrayList<Personaje> personajesPresentes;
    private Objeto objetoPresente;
    private String[] conexiones;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetoPresente(Objeto objetoPresente) {
        this.objetoPresente = objetoPresente;
    }


    public void setConexiones(String conexiones) {
        int numConexiones = 1;
    	
        //Contar numero de conexiones
        for(int i = 0; i < conexiones.length(); i++) {
        	if(conexiones.charAt(i) == ',') {
        		numConexiones++;
        	}
        }
        
        String[] conexionesString = new String[numConexiones];
        
        for(int i = 0; i < numConexiones; i++) {
        	conexionesString[i] = "";
        }
        int i = 0;
        for(int c = 0; c < conexiones.length(); c++) {
        	if(conexiones.charAt(c) == ',') {
        		i++;
        	}
        	else {
        		conexionesString[i] = conexionesString[i] + conexiones.charAt(c);
        	}
        }
    	
    	
    	this.conexiones = conexionesString;
    }

    public void setPersonajesPresentes(ArrayList<Personaje> personajesPresentes) {
        this.personajesPresentes = personajesPresentes;
    }

    public String getNombre() {
        return nombre;
    }

    public Objeto getObjetoPresente() {
        return objetoPresente;
    }

    public String getConexiones(int i) {
        return conexiones[i];
    }

    public ArrayList<Personaje> getPersonajesPresentes() {
        return personajesPresentes;
    }
    public int getNumConexiones(){
        return conexiones.length;
    }
}
