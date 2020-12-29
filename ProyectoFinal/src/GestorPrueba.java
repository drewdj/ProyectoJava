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
    
    //bucle i=numero de personajes para crear la clase Personaje y asignar nombre y localizacion
  
    Personaje[] arrayPersonajes = new Personaje[numPersonajes];
    Localizacion[] arrayLocalizaciones = new Localizacion[numLocalizaciones];
    Objeto[] arrayObjetos = new Objeto[numObjetos];
    
    //Rellenar los objetos Localizaciones
    
    for(int i = 0; i < numLocalizaciones; i++) {
    	String locationName = "";
    	String conexiones = "";
    	int flag = 0;
    	Localizacion fillLocation = new Localizacion();
    	for(int c = 0; c < localizacionesString[i].length(); c++) {
    		if(localizacionesString[i].charAt(c) != '(' && flag == 0) {
    			locationName = locationName + localizacionesString[i].charAt(c);
    		}
    		else if(localizacionesString[i].charAt(c) == '(' && flag == 0) {
    			flag = 1;
    		}
    		else if(localizacionesString[i].charAt(c) == ')' && flag == 1) {
    			break;
    		}
    		else if(localizacionesString[i].charAt(c) != '(' && flag == 1){
    			conexiones = conexiones + localizacionesString[i].charAt(c);
    		}
    	}
    	
    	
    	fillLocation.setNombre(locationName);
    	fillLocation.setConexiones(conexiones);
    	arrayLocalizaciones[i] = fillLocation;
    }
    
    //Rellenar los objetos presonajes
    
    for(int i = 0; i < numPersonajes; i++) {
    	String name = new String();
    	name = "";
    	String localizObjetivo = new String();
    	localizObjetivo = "";
    	Personaje personajeFill = new Personaje();
    	int flag = 0;
    	for(int c = 0; c < personajesString[i].length(); c++) {
    		if(personajesString[i].charAt(c) != '(' && flag == 0) {
    			name = name + personajesString[i].charAt(c);
    		}
    		else if(personajesString[i].charAt(c) == '(' && flag == 0) {
    			flag = 1;
    		}
    		else if(personajesString[i].charAt(c) == ')' && flag == 1) {
    			break;
    		}
    		else if(personajesString[i].charAt(c) != '(' && flag == 1){
    			localizObjetivo = localizObjetivo + personajesString[i].charAt(c);
    		}
    	}
		personajeFill.setNombre(name);
		personajeFill.setLocalizacionObjetivo(localizObjetivo);
		arrayPersonajes[i] = personajeFill;
    }
    
    /*FALTA RELLENAR LOS OBJETOS*/
    for(int i = 0; i < numObjetos; i++) {
    	String name = new String();
    	name = "";
    	String localizObjeto = new String();
    	localizObjeto = "";
    	Objeto objetoFill = new Objeto();
    	int flag = 0;
    	for(int c = 0; c < objetosString[i].length(); c++) {
    		if(objetosString[i].charAt(c) != '(' && flag == 0) {
    			name = name + objetosString[i].charAt(c);
    		}
    		else if(objetosString[i].charAt(c) == '(' && flag == 0) {
    			flag = 1;
    		}
    		else if(objetosString[i].charAt(c) == ')' && flag == 1) {
    			break;
    		}
    		else if(objetosString[i].charAt(c) != '(' && flag == 1){
    			localizObjeto = localizObjeto + objetosString[i].charAt(c);
    		}
    	}
    	objetoFill.setNombre(name);
    	arrayObjetos[i] = objetoFill;
    	System.out.printf("%s\n", arrayObjetos[i].getNombre());
    	for(int c = 0; c < numLocalizaciones; c++) {
    		if(localizObjeto.equals(arrayLocalizaciones[c].getNombre())) {
    			arrayLocalizaciones[c].setObjetoPresente(objetoFill);
    		}
    		else {
    			continue;
    		}
    	}
    	for(int c = 0; c < numPersonajes; c++) {
    		if(localizObjeto.equals(arrayPersonajes[c].getNombre())) {
    			arrayPersonajes[c].setObjetoActual(objetoFill);
    		}
    		else {
    			continue;
    		}
    	}
    }
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
