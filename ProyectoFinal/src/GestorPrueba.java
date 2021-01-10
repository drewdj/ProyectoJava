import java.util.ArrayList;
import java.util.Random;


abstract class GestorPrueba{
    public static void main(String[] args) {
	int turno = 0;
	int k = 0;
	Jugador jugador = new Jugador();

    //Dentro de la función de Leer fichero sacar atributo tamaño
    LeerFichero f = new LeerFichero();
    f.main(args);													//Se ejecuta el main de leerfichero para que se asignen los valores a los strings
    String[] personajesString = f.getPersonajesString();          	//y despues se pasan a esta clase      	    
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
    	Localizacion fillLocation = new Localizacion();						//Caracter a caracter divide el string de leer fichero 
    	for(int c = 0; c < localizacionesString[i].length(); c++) {			//en varios objetos diferentes ( en este caso localizaciones)
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


    	fillLocation.setNombre(locationName);			//Una vez tenga un nuevo objeto creado se lo pasa al array de objetos
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
    	if (name.equals("Jugador")){								//Aqui asigna los datos al jugador 
			jugador.setNombre(name);
			jugador.setHistorial(new ArrayList<String>());
			for (int j = 0; j < numLocalizaciones; j++) {
				if (arrayLocalizaciones[j].getNombre().equals(localizActual)){
					jugador.setLocalizacionActual(arrayLocalizaciones[j]);
				}
			}

		}else {
			personajeFill.setNombre(name);
			for (int j = 0; j < numLocalizaciones; j++) {   		//Bucle de busqueda y asignacion de localizacion
				if (arrayLocalizaciones[j].getNombre().equals(localizActual)){
					personajeFill.setLocalizacionActual(arrayLocalizaciones[j]);
				}
			}
			arrayPersonajes[k] = personajeFill;
			arrayPersonajes[k].setCreencias(new Creencias());
			arrayPersonajes[k].setFin(0);
			arrayPersonajes[k].setHistorial(new ArrayList<String>());
			arrayPersonajes[k].inicializarCreencias(new ArrayList<Localizacion>());
			k++;
		}

    }
		for (int i = 0; i < numLocalizaciones; i++) {				//Introduce a los personajes en sus localizaciones
			arrayLocalizaciones[i].setPersonajesPresentes(arrayPersonajes);
		}
		for (int i = 0; i < numLocalizaciones; i++) {				//Añade al jugador al arraylist de personajes presentes en la localizacion
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

    	//Meter el objeto en su localizacion(la localizacion inicial puede ser un personaje o el jugador)
	   	for(int c = 0; c < numLocalizaciones; c++) {
    		if(localizObjeto.equals(arrayLocalizaciones[c].getNombre())) {
    			arrayLocalizaciones[c].setObjetoPresente(objetoFill);
    		}
    		else {
    			continue;
    		}
    	}
    	for(int c = 0; c < numPersonajes; c++) {		//Para los objetos con posicion inicial en un personaje
    		if(localizObjeto.equals(arrayPersonajes[c].getNombre())) {
    			arrayPersonajes[c].setObjetoActual(objetoFill);
    		}
    		else {
    			continue;
    		}
    	}
		for (int j = 0; j < numObjetos; j++) {					  //Para los objetos con posicion inicial en el jugador
			if(localizObjeto.equals(jugador.getNombre())) {
				jugador.setObjetoActual(objetoFill);
			}
		}

	}
    for(int i = 0; i <= numPersonajes; i++) {					//Asignar las localizaciones objetivo a los personajes y al jugador
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
		if(name.equals(jugador.getNombre())){						//Primero comprueba si es la localizacion objetivo de jugador
			jugador.setLocalizacionObjetivo(localizObjetivo);       
		}else {														//y si no se lo pasa al personaje correspondiente
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
    for(int i = 0; i <= numPersonajes; i++) {     			//Asignar los objetos objetivo a los personajes y al jugador
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
		if(name.equals(jugador.getNombre())){                //Comprueba primero si el objeto objetivo es de jugador
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

		for (int i = 0; i < array.length; i++) {				//Esto genera un array de numeros aleatorios(del 0 al numpersonajes) de tamaño=numpersonajes
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}

		for (int i = 0; i < numPersonajes; i++) {				//Se otorga cada uno de los valores de ese array a cada uno de los personajes
			arrayPersonajes[i].setTurno(array[i]);
		}

		Personaje[] arrayPersonajesOrdenado = new Personaje[numPersonajes]; //Se crea un nuevo array de personajes que va a estar ordenado segun los turnos

		for (int i = 0; i < numPersonajes; i++) {

			for (int j = 0; j < numPersonajes; j++) {

				if(arrayPersonajes[j].getTurno()==i){

					arrayPersonajesOrdenado[i]=arrayPersonajes[j];

				}

			}

		}
		//BUCLE PRINCIPAL DE GESTION DE TURNO
 		for (; turno < numPersonajes; turno++) {//Reseteo de accion y actualizar creencias
			arrayPersonajesOrdenado[turno].setAccion(0);
			arrayPersonajesOrdenado[turno].actualizarLocalizacionesConocidas();

				try {//El catch salta en caso de que el personaje no tenga objeto
					if (arrayPersonajesOrdenado[turno].getQuienPide()!=null){//Comprueba si alguien te ha pedido un objeto y se lo da(dentro de dar se decide si se quiere dar o no)
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
						if (arrayPersonajesOrdenado[turno].getObjetoObjetivo().getNombre().equals(arrayPersonajesOrdenado[turno].getObjetoActual().getNombre())) {//Primero se comprueba si se tiene el objeto deseado
							//En caso de tenerlo si se esta en la posicion deseada
							if (!arrayPersonajesOrdenado[turno].getLocalizacionObjetivo().equals(arrayPersonajesOrdenado[turno].getLocalizacionActual().getNombre())){//Si no esta, se mueve
								for (int i = 0; i < numLocalizaciones; i++) {//
									if (arrayPersonajesOrdenado[turno].moverseHaciaLocalizacion(arrayLocalizaciones).equals(arrayLocalizaciones[i].getNombre())){
										arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
										break;
									}
								}
							}else if(arrayPersonajesOrdenado[turno].getLocalizacionObjetivo().equals(arrayPersonajesOrdenado[turno].getLocalizacionActual().getNombre())){//Si esta se queda en la posiciona y activa el estado de finalizado
								arrayPersonajesOrdenado[turno].setFin(1);
							}
						} else {//Si no se tiene el objeto
							arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();//Primero lo busca en la localizacion
							if (arrayPersonajesOrdenado[turno].getAccion()==0){//Despues en los personajes
								arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
							}
							if (arrayPersonajesOrdenado[turno].getAccion()==0){//Y por ultimo si no ha encontrado nada se mueve priorizando aquellos sitios donde no ha estado
								for (int i = 0; i < numLocalizaciones; i++) {
									if (arrayPersonajesOrdenado[turno].moverseHaciaObjeto().equals(arrayLocalizaciones[i].getNombre())){
										arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
										break;
									}
								}
							}
						}
					}
				}catch (Exception e){//Si el personaje no tiene objeto se utiliza el mismo protocolo de busqueda anterior
					if (arrayPersonajesOrdenado[turno].getAccion()==0){
						arrayPersonajesOrdenado[turno].buscarObjetoEnLocalizacion();
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							arrayPersonajesOrdenado[turno].buscarObjetoEnPersonajes();
						}
						if (arrayPersonajesOrdenado[turno].getAccion()==0){
							for (int i = 0; i < numLocalizaciones; i++) {
								if (arrayPersonajesOrdenado[turno].moverseHaciaObjeto().equals(arrayLocalizaciones[i].getNombre())) {
									arrayPersonajesOrdenado[turno].mover(arrayLocalizaciones[i]);
									break;
								}
							}
						}
					}

				}
			int contadorFinal=0;//Contar el numero de personajes en estado de fin para pasar a la pantalla final
			for (int i = 0; i < numPersonajes; i++) {
				if (arrayPersonajes[i].getFin()==1){
					contadorFinal++;
				}
			}

			if (contadorFinal!=numPersonajes+1){
				if (turno == numPersonajes-1){      //Empieza el turno del jugador
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

		GUI interfaz = new GUI(arrayPersonajes);//Pantalla final
		do {}while(interfaz.getFlag() == 0);
		return;
    }

}
