import java.util.ArrayList;
import java.util.Random;

public class GestorPrueba {
    public static void main(String[] args) {
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
		for (int j = 0; j < numLocalizaciones; j++) {//bucle de busqueda y asignacion de localizacion
			if (arrayLocalizaciones[j].getNombre().equals(localizActual)){
				personajeFill.setLocalizacionActual(arrayLocalizaciones[j]);
			}
		}
		arrayPersonajes[i] = personajeFill;
		arrayPersonajes[i].setCreencias(new Creencias());
		arrayPersonajes[i].inicializarCreencias(new ArrayList<Objeto>(),new ArrayList<Localizacion>(),new ArrayList<Personaje>());

    }
		//Rellenar los objetos objeto
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

    	//meter el objeto en su localizacion
		for (int j = 0; j < numLocalizaciones; j++) {
			if (arrayLocalizaciones[j].getNombre()==localizObjeto){//
				arrayLocalizaciones[j].setObjetoPresente(arrayObjetos[i]);
			}
		}

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

    		}
    		else {
    			continue;
    		}
    	}
    }
		//ORDENACION DE TURNOS
		int[] array = new int [numPersonajes];
		for (int i = 0; i < numPersonajes; i++) {
			array[i]= i;
		}

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}

		//System.out.println(array[0]);


		
		for (int i = 0; i < numPersonajes; i++) {
			arrayPersonajes[i].setTurno(array[i]);
		}

		//System.out.println(arrayPersonajes[0].getTurno());


		Personaje[] arrayPersonajesOrdenado = new Personaje[numPersonajes];

		for (int i = 0; i < numPersonajes; i++) {

			for (int j = 0; j < numPersonajes; j++) {

				if(arrayPersonajes[j].getTurno()==i){

					arrayPersonajesOrdenado[i]=arrayPersonajes[j];

				}

			}

		}

		for (int i = 0; i < numPersonajes; i++) {
			System.out.println(arrayPersonajesOrdenado[i].getTurno());
		}









 		for (; turno < numPersonajes; turno++) {
			//FALTA ACTIALIZAR LOCALIZACIONES

			//actualizacion de creencias(objetos)  MOVER A ENTRADA EN SALA
			arrayPersonajesOrdenado[turno].actualizarObjetosConocidos();
			//actualizador de creencias(personajes) en caso de tener la accion pedir
			//arrayPersonajesOrdenado[turno].actualizarPersonajesConocidos();
			//actualizadpr de creencias(localizaciones)
			arrayPersonajesOrdenado[turno].actualizarLocalizacionesConocidas();

			//comprobar si se tiene el objeto
				try {
					if (arrayPersonajesOrdenado[turno].getObjetoObjetivo().getNombre().equals(arrayPersonajesOrdenado[turno].getObjetoActual().getNombre())) {
						System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " tiene su objeto objetivo");//CUANDO TODOS TENGAN SU OBJETO FIN DE LA PARTIDA
					} else {
						System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " no tiene su objeto objetivo");

						arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
						}
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							arrayPersonajesOrdenado[turno].moverseHaciaObjeto();
						}
					}
				}catch (Exception e){
					System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " no tiene objeto");
					arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();
					if (arrayPersonajesOrdenado[turno].getAccion()==0){
						arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
					}
					if (arrayPersonajesOrdenado[turno].getAccion()==0){
						arrayPersonajesOrdenado[turno].moverseHaciaObjeto();
					}
				}



			if (turno == numPersonajes-1)
				turno=0;
		}
    }


}
