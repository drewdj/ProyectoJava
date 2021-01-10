import java.util.ArrayList;
import java.util.Random;


abstract class GestorPrueba{
    public static void main(String[] args) {
	int turno = 0;
	int k = 0;
	Jugador jugador = new Jugador();

    //Dentro de la función de Leer fichero sacar atributo tamaño
    LeerFichero f = new LeerFichero();
    f.main(args);
    String[] personajesString = f.getPersonajesString();
    String[] localizacionesString = f.getLocalizacionesString();
    String[] objetosString = f.getObjetosString();
    String[] localizObjetivoString = f.getLocalizacionesObjetivoString();
    String[] objetosObjetivoString = f.getObjetosObjetivoString();


    // leer personajes contar numero de personajes

    int numPersonajes = personajesString.length-1;
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
    	arrayLocalizaciones[i].setPersonajesPresentes(new ArrayList<Personaje>());
    }

    //Rellenar los objetos presonajes

    for(int i = 0; i <= numPersonajes; i++) {
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
    	if (name.equals("Jugador")){
			jugador.setNombre(name);
			jugador.setHistorial(new ArrayList<String>());
			for (int j = 0; j < numLocalizaciones; j++) {
				if (arrayLocalizaciones[j].getNombre().equals(localizActual)){
					jugador.setLocalizacionActual(arrayLocalizaciones[j]);
				}
			}

		}else {
			personajeFill.setNombre(name);
			for (int j = 0; j < numLocalizaciones; j++) {//bucle de busqueda y asignacion de localizacion
				if (arrayLocalizaciones[j].getNombre().equals(localizActual)){
					personajeFill.setLocalizacionActual(arrayLocalizaciones[j]);
				}
			}
			arrayPersonajes[k] = personajeFill;
			arrayPersonajes[k].setCreencias(new Creencias());
			arrayPersonajes[k].setFin(0);
			arrayPersonajes[k].setHistorial(new ArrayList<String>());
			arrayPersonajes[k].inicializarCreencias(new ArrayList<Objeto>(),new ArrayList<Localizacion>(),new ArrayList<Personaje>());
			k++;
		}

    }
		for (int i = 0; i < numLocalizaciones; i++) {//Introduce a los jugadores en sus localizaciones
			arrayLocalizaciones[i].setPersonajesPresentes(arrayPersonajes);
		}
		for (int i = 0; i < numLocalizaciones; i++) {
			if (jugador.getLocalizacionActual().getNombre().equals(arrayLocalizaciones[i].getNombre())){
				arrayLocalizaciones[i].addPersonajePresente(jugador);
			}
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
		for (int j = 0; j < numObjetos; j++) {
			if(localizObjeto.equals(jugador.getNombre())) {
				jugador.setObjetoActual(objetoFill);
			}
		}

    }
    for(int i = 0; i <= numPersonajes; i++) {
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
		if(name.equals(jugador.getNombre())){
			jugador.setLocalizacionObjetivo(localizObjetivo);                     //primero comprueba si es la localizacion objetivo de jugador
		}else {
			for(int c = 0; c < numPersonajes; c++) {
				if(name.equals(arrayPersonajes[c].getNombre())) {
					arrayPersonajes[c].setLocalizacionObjetivo(localizObjetivo);
				}
				else {
					continue;
				}
			}
		}

    }
    for(int i = 0; i <= numPersonajes; i++) {
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
		if(name.equals(jugador.getNombre())){                //igual para objeto objetivo
			jugador.setObjetoObjetivo(objetoFill);
		}else {
			for(int c = 0; c < numPersonajes; c++) {
				if(name.equals(arrayPersonajes[c].getNombre())) {
					arrayPersonajes[c].setObjetoObjetivo(objetoFill);

				}
				else {
					continue;
				}
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










 		for (; turno < numPersonajes; turno++) {
			System.out.println("Turno de " + arrayPersonajesOrdenado[turno].getNombre());
			arrayPersonajesOrdenado[turno].setAccion(0);
 			//FALTA ACTIALIZAR LOCALIZACIONES

			//actualizacion de creencias(objetos)  MOVER A ENTRADA EN SALA
			//arrayPersonajesOrdenado[turno].actualizarObjetosConocidos();
			//actualizador de creencias(personajes) en caso de tener la accion pedir
			//arrayPersonajesOrdenado[turno].actualizarPersonajesConocidos();
			//actualizadpr de creencias(localizaciones)
			arrayPersonajesOrdenado[turno].actualizarLocalizacionesConocidas();
			//comprobar si se tiene el objeto
				try {
					if (arrayPersonajesOrdenado[turno].getQuienPide()!=null){
						for (int i = 0; i < numPersonajes; i++) {
							if (arrayPersonajesOrdenado[turno].getQuienPide().equals(arrayPersonajes[i].getNombre())){
								arrayPersonajesOrdenado[turno].darObjeto(arrayPersonajes[i]);
							}
							if (arrayPersonajesOrdenado[turno].getQuienPide().equals(jugador.getNombre())){
                                arrayPersonajesOrdenado[turno].darObjeto(jugador);
                            }
						}

					}
					if (arrayPersonajesOrdenado[turno].getAccion()==0){
						if (arrayPersonajesOrdenado[turno].getObjetoObjetivo().getNombre().equals(arrayPersonajesOrdenado[turno].getObjetoActual().getNombre())) {
							System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " tiene su objeto objetivo");//CUANDO TODOS TENGAN SU OBJETO FIN DE LA PARTIDA
							if (!arrayPersonajesOrdenado[turno].getLocalizacionObjetivo().equals(arrayPersonajesOrdenado[turno].getLocalizacionActual().getNombre())){
								System.out.println("No estoy en la posicion objetivo");
								for (int i = 0; i < numLocalizaciones; i++) {
									if (arrayPersonajesOrdenado[turno].moverseHaciaLocalizacion(arrayLocalizaciones).equals(arrayLocalizaciones[i].getNombre())){
										arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
										break;
									}
								}
							}else if(arrayPersonajesOrdenado[turno].getLocalizacionObjetivo().equals(arrayPersonajesOrdenado[turno].getLocalizacionActual().getNombre())){
								System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " esta en la posicion objetivo");
								arrayPersonajesOrdenado[turno].setFin(1);
							}
						} else {
							System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " no tiene su objeto objetivo");

							arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();
							if (arrayPersonajesOrdenado[turno].getAccion()==0){
								arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
							}
							if (arrayPersonajesOrdenado[turno].getAccion()==0){
								System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " se quiere mover");
								for (int i = 0; i < numLocalizaciones; i++) {
									System.out.println("quiero ir a " + arrayLocalizaciones[i].getNombre() + "?");
									if (arrayPersonajesOrdenado[turno].moverseHaciaObjeto().equals(arrayLocalizaciones[i].getNombre())){
										arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
										break;
									}
								}
							}
						}
					}
				}catch (Exception e){
					if (arrayPersonajesOrdenado[turno].getAccion()==0){
						System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " no tiene objeto");
						arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
						}
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							System.out.println(arrayPersonajesOrdenado[turno].getNombre() + " se quiere mover");

							for (int i = 0; i < numLocalizaciones; i++) {
								System.out.println("quiero ir a " + arrayLocalizaciones[i].getNombre() + "?");
								if (arrayPersonajesOrdenado[turno].moverseHaciaObjeto().equals(arrayLocalizaciones[i].getNombre())) {
									arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
									break;
								}
							}
						}
					}

				}
			int contadorFinal=0;
			for (int i = 0; i < numPersonajes; i++) {
				if (arrayPersonajes[i].getFin()==1){
					contadorFinal++;
				}
			}

			if (contadorFinal!=numPersonajes+1){
				if (turno == numPersonajes-1){      //empieza el turno del jugador
					System.out.printf("%s", jugador.getLocalizacionActual().getNombre());
					GUI interfaz = new GUI(jugador, arrayLocalizaciones);
					do {}while(interfaz.getFlag() == 0);
					if (jugador.getObjetoObjetivo().getNombre().equals(jugador.getObjetoActual().getNombre())&&jugador.getLocalizacionActual().getNombre().equals(jugador.getLocalizacionObjetivo()))
						jugador.setFin(1);
					if (jugador.getFin()==1)
						contadorFinal++;

					if (contadorFinal==numPersonajes+1){
						break;
					}
				}
			}



			if (turno == numPersonajes-1)
				turno=-1;
		}

		GUI interfaz = new GUI(arrayPersonajes);
		do {}while(interfaz.getFlag() == 0);
		return;
    }

}
