public class GestorPrueba {
    public static void main(String[] args) {
    	
	int end = 0;
	int turno = 3;
    
    //Dentro de la función de Leer fichero sacar atributo tamaño
    LeerFichero f = new LeerFichero();
    f.main(args);
    String[] personajesString = f.getPersonajesString();
    String[] localizacionesString = f.getLocalizaString();
    String[] objetosString = f.getObjetosString();





    // leer personajes contar numero de personajes
    
    int numPersonajes = personajesString.length;
    int numLocalizaciones = localizacionesString.length;
    int numObjetos = objetosString.length;
    
    for(int p = 0; p < numObjetos; p++) {
    	System.out.printf("%d, %s\n", numObjetos, objetosString[p]);
    	System.out.printf("%d, %s\n", numLocalizaciones, localizacionesString[p]);
    	System.out.printf("%d, %s\n", numPersonajes, personajesString[p]);
    	}
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
    	System.out.printf("%s", arrayPersonajes[1].getNombre());
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
    
    for(int i = 0; i < numObjetos; i++) {
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
		// generar turnos


		for (int i = 0; i < turno; i++) {
			//actualizacion de creencias

			//buscar objeto
			// si esta cogerlo/ pedirlo
			if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()==arrayPersonajes[turno].getObjetoActual().getNombre()){
				System.out.println(arrayPersonajes[turno].getNombre() + " tiene su objeto");
			}else if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()!=arrayPersonajes[turno].getObjetoActual().getNombre()){
				System.out.println(arrayPersonajes[turno].getNombre() + " no tiene su objeto");

				if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()==arrayPersonajes[turno].getLocalizacionActual().getObjetoPresente().getNombre()){
					//coger objeto
				}
				for (int j = 0; j < arrayPersonajes[turno].getLocalizacionActual().getNumPersonajePresente(); j++) {
					if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()== arrayPersonajes[turno].getLocalizacionActual().getPersonajesPresentes().get(j).getObjetoActual().getNombre()){
						//pedir objeto
					}
				}
				//si se se sabe donde esta pero no se puede alcanzar moverse a la posicion deseada (por hacer)

				//terminada la busqueda moverse


			}



			//movimiento cuando se tenga el objeto
			if (arrayPersonajes[turno].getLocalizacionActual().getNombre()==arrayPersonajes[turno].getLocalizacionObjetivo()){
				System.out.println(arrayPersonajes[turno].getNombre() + " esta en la posicion deseada");
			}else if (arrayPersonajes[turno].getLocalizacionActual().getNombre()!=arrayPersonajes[turno].getLocalizacionObjetivo()){
				System.out.println(arrayPersonajes[turno].getNombre() + " no esta en la posicion deseada");
				//Moverse a la posicion deseada(si se conoce)
			}




			if (end == 1)
				break;
		}


    }


}
