public class GestorPrueba {
    public static void main(String[] args) {
    
    //Dentro de la función de Leer fichero sacar atributo tamaño	
    
    LeerFichero f = new LeerFichero();
    String[] personajesString = f.getPersonajesString();
    String[] localizacionesString = f.getLocalizaString();
    String[] objetosString = f.getObjetosString();
    

    // leer personajes contar numero de personajes
    
    int numPersonajes = personajesString.length;
    int numLocalizaciones = localizacionesString.length;
    int numObjetos = objetosString.length;
    
    //bucle i=numero de personajes para crear la clase Personaje y asignar nombre y localizacion
  
    Personaje[] arrayPersonajes = new Personaje[numPersonajes];
    Localizacion[] arrayLocalizaciones = new Localizacion[numLocalizaciones];
    Objeto[] arrayObjetos = new Objeto[numObjetos];
    
    for(int i = 0; i < numPersonajes; i++) {
    	StringBuilder name = new StringBuilder("                    ");
    	StringBuilder localizacionObjetivo = new StringBuilder("                    ");
    	for(int c = 0; c < personajesString[i].length(); c++) {
    		if(personajesString[i].charAt(c) != '(') {
    			name.setCharAt(c, personajesString[i].charAt(c));	
    		}	
    		else {
    			break;
    		}
    	}
    	for(int c = 0; c < personajesString[i].length(); c++) {
    		if(personajesString[i].charAt(c) == '(') {
    			for(int j = c + 1; j < personajesString[i].length(); j++){
    				if(personajesString[i].charAt(j) != ')') {
    					localizacionObjetivo.setCharAt(j, personajesString[i].charAt(j));		
    				}
    				else {
    					break;
    				}
    			}
    			break;
    		}	
    	}
    	arrayPersonajes[i].setNombre(name.toString());
    	arrayPersonajes[i].setLocalizacionObjetivo(localizacionObjetivo.toString());
    }
    
    //mismo bucle para localizaciones

    for(int i = 0; i < numLocalizaciones; i++) {
    	StringBuilder name = new StringBuilder("                    ");
    	StringBuilder conexiones = new StringBuilder("                    ");
    	for(int c = 0; c < localizacionesString[i].length(); c++) {
    		if(localizacionesString[i].charAt(c) != '(') {
    			name.setCharAt(c, localizacionesString[i].charAt(c));
    		}	
    		else {
    			break;
    		}
    	}
    	for(int c = 0; c < localizacionesString[i].length(); c++) {
    		if(localizacionesString[i].charAt(c) == '(') {
    			for(int j = c + 1; j < localizacionesString[i].length(); j++){
    				if(localizacionesString[i].charAt(j) != ')') {
    					conexiones.setCharAt(j, localizacionesString[i].charAt(j));	
    				}
    				else {
    					break;
    				}
    			}
    			break;
    		}	
    	}
    	arrayLocalizaciones[i].setNombre(name.toString());
    	arrayLocalizaciones[i].setConexiones(conexiones.toString());
    }
    
    //y objetos
    
    for(int i = 0; i < numLocalizaciones; i++) {
    	StringBuilder name = new StringBuilder("                    ");
    	for(int c = 0; c < objetosString[i].length(); c++) {
    		if(objetosString[i].charAt(c) != '(') {
    			name.setCharAt(c, objetosString[i].charAt(c));	
    		}	
    		else {
    			break;
    		}
    	}
    	arrayObjetos[i].setNombre(name.toString());
    }
    
    //System.out.printf("%s", arrayPersonajes[1].getNombre());
    
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
