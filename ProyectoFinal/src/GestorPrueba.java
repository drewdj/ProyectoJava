import java.util.ArrayList;

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
    String[] localizObjetivoString = f.getLocalizacionesObjetivoString();
    String[] objetosObjetivoString = f.getObjetosObjetivoString();

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
    	String localizActual = new String();
    	localizActual = "";
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
    			localizActual = localizActual + personajesString[i].charAt(c);
    		}
    	}
		personajeFill.setNombre(name);
		personajeFill.setLocalizacionObjetivo(localizActual);
		arrayPersonajes[i] = personajeFill;
		arrayPersonajes[i].getCreencias().setObjetosConocidos(new ArrayList<Objeto>());
		arrayPersonajes[i].getCreencias().setLocalizacionesConocidas(new ArrayList<Localizacion>());
		arrayPersonajes[i].getCreencias().setPersonajesConocidos(new ArrayList<Personaje>());
    }
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
    for(int i = 0; i < numPersonajes; i++) {
    	String name = new String();
    	name = "";
    	String localizObjetivo = new String();
    	localizObjetivo = "";
    	int flag = 0;
    	for(int c = 0; c < localizObjetivoString[i].length(); c++) {
    		if(localizObjetivoString[i].charAt(c) != '(' && flag == 0) {
    			name = name + localizObjetivoString[i].charAt(c);
    		}
    		else if(localizObjetivoString[i].charAt(c) == '(' && flag == 0) {
    			flag = 1;
    		}
    		else if(localizObjetivoString[i].charAt(c) == ')' && flag == 1) {
    			break;
    		}
    		else if(localizObjetivoString[i].charAt(c) != '(' && flag == 1){
    			localizObjetivo = localizObjetivo + localizObjetivoString[i].charAt(c);
    		}
    	}
    	for(int c = 0; c < numPersonajes; c++) {
    		if(name.equals(arrayPersonajes[c].getNombre())) {
    			arrayPersonajes[c].setLocalizacionObjetivo(localizObjetivo);
    			System.out.printf("%s - %s\n", arrayPersonajes[c].getNombre(), arrayPersonajes[c].getLocalizacionObjetivo());
    		}
    		else {
    			continue;
    		}
    	}
    }
    for(int i = 0; i < numPersonajes; i++) {
    	String name = new String();
    	name = "";
    	String objetoObjetivo = new String();
    	objetoObjetivo = "";
    	Objeto objetoFill = new Objeto();
    	int flag = 0;
    	for(int c = 0; c < objetosObjetivoString[i].length(); c++) {
    		if(objetosObjetivoString[i].charAt(c) != '(' && flag == 0) {
    			objetoObjetivo = objetoObjetivo + objetosObjetivoString[i].charAt(c);
    		}
    		else if(objetosObjetivoString[i].charAt(c) == '(' && flag == 0) {
    			flag = 1;
    		}
    		else if(objetosObjetivoString[i].charAt(c) == ')' && flag == 1) {
    			break;
    		}
    		else if(objetosObjetivoString[i].charAt(c) != '(' && flag == 1){
    			name = name + objetosObjetivoString[i].charAt(c);
    		}
    	}
    	objetoFill.setNombre(objetoObjetivo);
    	for(int c = 0; c < numPersonajes; c++) {
    		if(name.equals(arrayPersonajes[c].getNombre())) {
    			arrayPersonajes[c].setObjetoObjetivo(objetoFill);
    			System.out.printf("%s - %s\n", arrayPersonajes[c].getNombre(), arrayPersonajes[c].getObjetoObjetivo().getNombre());
    		}
    		else {
    			continue;
    		}
    	}
    }

		// FALTA GENERAR TURNO

		for (int i = 0; i < turno; i++) {
			//actualizacion de creencias(objetos)  MOVER A ENTRADA EN SALA
			int comprobador = 0;
			for (int j = 0; j < arrayPersonajes[turno].getCreencias().getObjetosConocidos().size(); j++) {
				if (arrayPersonajes[turno].getCreencias().getObjetosConocidos().get(j).getNombre() != arrayPersonajes[turno].getLocalizacionActual().getObjetoPresente().getNombre())
					comprobador++;
				if (comprobador == arrayPersonajes[turno].getCreencias().getObjetosConocidos().size()) {
					Objeto objetoConocido = new Objeto();
					arrayPersonajes[turno].getCreencias().getObjetosConocidos().add(objetoConocido);
				}
			}



			//buscar objeto
			// si esta cogerlo/ pedirlo
			if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()==arrayPersonajes[turno].getNombre()){
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
		System.out.printf(arrayPersonajes[0].getNombre());
		System.out.printf(arrayPersonajes[1].getNombre());
		System.out.printf(arrayPersonajes[2].getNombre());
    }


}
