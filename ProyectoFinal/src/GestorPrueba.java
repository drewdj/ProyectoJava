public class GestorPrueba {
    public static void main(String[] args) {
    
    //Dentro de la función de Leer fichero sacar atributo tamaño	
    
    LeerFichero f = new LeerFichero();
    String[] personajesString = f.getPersonajes();
    String[] localizacionesString = f.getLocalizaciones();
    String[] objetosString = f.getObjetos();
    

    // leer personajes contar numero de personajes
    
    int numPersonajes = personajesString.lenght;
    int numLocalizaciones = localizacionesString.lenght;
    int numObjetos = objetosString.lenght;
    
    //bucle i=numero de personajes para crear la clase Personaje y asignar nombre y localizacion
  
    Personaje[] arrayPersonajes = new Personaje[numPersonajes];
    Localizacion[] arrayLocalizaciones = new Localizacion[numLocalizaciones];
    Objeto[] arrayObjetos = new Objeto[numObjetos];
    
    for(int i = 0; i < numPersonajes; i++) {
    	String name = "";
    	String localizacionObjetivo = "";
    	for(int c = 0; c < personajesString[i].lenght; c++) {
    		if(personajesString[i][c] != '(') {
    			name = personajesString[i][c];	
    		}	
    		else {
    			break;
    		}
    	}
    	for(int c = 0; c < personajesString[i].lenght; c++) {
    		if(personajesString[i][c] == '(') {
    			for(int j = c + 1;; j < personajesString[i].lenght; j++){
    				if(personajesString[i][j] != ')') {
    					localizacionObjetivo = personajesString[i][j];		
    				}
    				else {
    					break;
    				}
    			}
    			break;
    		}	
    	}
    	arrayPersonajes[i].setNombre(name);
    	arrayPersonajes[i].setLocalizacionObjetivo(localizacionObjetivo);
    }
    
    //mismo bucle para localizaciones

    for(int i = 0; i < numLocalizaciones; i++) {
    	String name = "";
    	String conexiones = "";
    	for(int c = 0; c < localizacionesString[i].lenght; c++) {
    		if(localizacionesString[i][c] != '(') {
    			name = localizacionesString[i][c];	
    		}	
    		else {
    			break;
    		}
    	}
    	for(int c = 0; c < localizacionesString[i].lenght; c++) {
    		if(localizacionesString[i][c] == '(') {
    			for(int j = c + 1;; j < localizacionesString[i].lenght; j++){
    				if(localizacionesString[i][j] != ')') {
    					conexiones = localizacionesString[i][j];		
    				}
    				else {
    					break;
    				}
    			}
    			break;
    		}	
    	}
    	arrayLocalizaciones[i].setNombre(name);
    	arrayLocalizaciones[i].setConexiones(conexiones);
    }
    
    //y objetos
    
    for(int i = 0; i < numLocalizaciones; i++) {
    	String name = "";
    	for(int c = 0; c < objetosString[i].lenght; c++) {
    		if(objetosString[i][c] != '(') {
    			name = objetosString[i][c];	
    		}	
    		else {
    			break;
    		}
    	}
    	arrayObjetos[i].setNombre(name);
    }
    
    //Falta establecer la localizacion de los objetos
    
    
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


    }
}
