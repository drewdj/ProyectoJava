import java.util.ArrayList;

public class GestorPrueba {
    public static void main(String[] args) {
	int	maxTurnos = 3;
	int turno = 0;
    
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
		arrayPersonajes[i].setCreencias(new Creencias());
		arrayPersonajes[i].inicializarCreencias(new ArrayList<Objeto>(),new ArrayList<Localizacion>(),new ArrayList<Personaje>());

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

 		for (; turno < maxTurnos; turno++) {
			//actualizacion de creencias(objetos)  MOVER A ENTRADA EN SALA
			int comprobador = 0;
			for (int j = 0; j < arrayPersonajes[turno].getCreencias().getObjetosConocidos().size(); j++) {
				if (arrayPersonajes[turno].getCreencias().getObjetosConocidos().get(j).getNombre() != arrayPersonajes[turno].getLocalizacionActual().getObjetoPresente().getNombre())
					comprobador++;
				if (comprobador == arrayPersonajes[turno].getCreencias().getObjetosConocidos().size()) {
					Objeto objetoConocido = new Objeto(arrayPersonajes[turno].getLocalizacionActual().getObjetoPresente());
					arrayPersonajes[turno].getCreencias().addObjeto(objetoConocido);
				}
			}



			//buscar objeto

			//si el objeto actual no es null entra en el if
			if (arrayPersonajes[turno].getObjetoActual()!=null){
				//si el objeto es el deseado entra en el if
				if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()==arrayPersonajes[turno].getObjetoActual().getNombre()){
					System.out.println(arrayPersonajes[turno].getNombre() + " tiene el objeto objetivo.");
				}
			}

			//si es null o no tiene el objeto deseado entra en el if
			if (arrayPersonajes[turno].getObjetoActual()==null||arrayPersonajes[turno].getObjetoObjetivo().getNombre()!=arrayPersonajes[turno].getObjetoActual().getNombre()){
				System.out.println(arrayPersonajes[turno].getNombre() + " no tiene el objeto objetivo.");
				if (arrayPersonajes[turno].getObjetoObjetivo().getNombre()==arrayPersonajes[turno].getLocalizacionActual().getObjetoPresente().getNombre()){
					System.out.println(arrayPersonajes[turno].getLocalizacionActual().getNombre() + " tiene el objeto que quiere " + arrayPersonajes[turno].getNombre());
				}else {
					System.out.println(arrayPersonajes[turno].getLocalizacionActual().getNombre() + " no tiene el objeto que quiere " + arrayPersonajes[turno].getNombre());

				}
			}

		}


    }


}
