import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 

/*Esta clase lee los ficheros configuracion.txt y objetivo.txt
  Para que esto funcione se debe ejecutar el main en el GestorPrueba */
public class LeerFichero {
	private String localizacionesString[];
	private String personajesString[];
	private String objetosString[];
	private String localizacionesObjetivoString[];
	private String objetosObjetivoString[];
	private int flag1=0,flag2=0;

  

  public void main(String[] args) {       
    //leer fichero de configuracion
    String datas="";
    try {
      File myObj = new File("configuracion.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        datas = datas + data;
      }
      myReader.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    String[] partes = datas.split(">");       //separa el contenido del fichero en diferentes string
    String[] cambios;                         //y lo vuelve a separar para quitar los titulos entre <>. Ej: <Localizaciones>
    for (int i = 1; i < 4; i++) {
      cambios=partes[i].split("<");
      partes[i]=cambios[0];
    }
    
    //calcular num de elementos de cada parte
    int[] numelementos = new int[3];
    for (int i = 0; i < 3; i++) {
      for(int j=0; j<partes[i+1].length(); j++){
        if(partes[i+1].charAt(j)=='(')
          numelementos[i]++;
        if(partes[i+1].charAt(j)==')'){
          if(numelementos[i]==0)
            flag1=1;
        }
      }
    }

    localizacionesString = new String [numelementos[0]];      //incializa la informacion de cada objeto 
    personajesString = new String [numelementos[1]];          //segun el largo de los strings que hemos separado
    objetosString = new String [numelementos[2]];
    String cambio = "";
    int count = 0 ;

    //Se rellena cada string con un for propio
    //Dentro de un try para deteccion de errores
    try {
      //for para Localizaciones
      for (int i=0; count<numelementos[0]; ++i){     
        if (partes[1].charAt(i)==')'){
          localizacionesString[count]="";
          cambio=cambio+partes[1].charAt(i);
          localizacionesString[count]=localizacionesString[count]+cambio;
          ++count;
          cambio="";
          continue;
        }
        if (partes[1].charAt(i)==','){                          //Control de errores en el txt  /*
          if(partes[1].charAt(i+1)!=' '){
            cambio=cambio+", ";
            continue;
          }
          if(partes[1].charAt(i+1)==' '&&partes[1].charAt(i+2)==' '){
            cambio=cambio+", ";
            ++i;
            for(;;i++){
              if(partes[1].charAt(i)!=' ')
                break;
            }
          }
        }
        cambio=cambio+partes[1].charAt(i);
        if(cambio.charAt(0)==' ')
          cambio="";                                   
      }
      for (int f,i = 0; i < numelementos[0]; i++) {
        f=0;
        for (int j = 0; j < localizacionesString[i].length(); j++) {
          if(localizacionesString[i].charAt(j)==')'||localizacionesString[i].charAt(j)=='('){
            ++f;
          }
        }
        if(f<2||f>2){
          flag1=1;
        }
      }                                                             // */
      
      count = 0;

      //for para Personajes
     for (int i=0; count<numelementos[1]; ++i){
       if (partes[2].charAt(i)==')'){
        personajesString[count]="";
        cambio=cambio+partes[2].charAt(i);
        personajesString[count]=personajesString[count]+cambio;
        ++count;
        cambio="";
        continue;
       }
       cambio=cambio+partes[2].charAt(i);
       if(cambio.charAt(0)==' ')
        cambio="";
      }
      for (int f,i = 0; i < numelementos[1]; i++) {                //Control de errores/*
        f=0;
        for (int j = 0; j < personajesString[i].length(); j++) {
          if(personajesString[i].charAt(j)==')'||personajesString[i].charAt(j)=='('){
            ++f;
          }
        }
        if(f<2||f>2){
          flag1=1;
        }
      }                                                             // */
   
      count=0;

      //for para Objetos
      for (int i=0; count<numelementos[2]; ++i){
       if (partes[3].charAt(i)==')'){
          objetosString[count]="";
          cambio=cambio+partes[3].charAt(i);
          objetosString[count]=objetosString[count]+cambio;
          ++count;
          cambio="";
          continue;
        }
       cambio=cambio+partes[3].charAt(i);
       if(cambio.charAt(0)==' ')
       cambio="";
      }
      for (int f,i = 0; i < numelementos[2]; i++) {                 //Control de errores/*
        f=0;
        for (int j = 0; j < objetosString[i].length(); j++) {
          if(objetosString[i].charAt(j)==')'||objetosString[i].charAt(j)=='('){
            ++f;
          }
        }
        if(f<2||f>2){
          flag1=1;
        }
      }                                                              // */

    
    } catch (Exception e) {
      System.out.println("ERROR EN LECTURA FICHERO");
      flag1 = 1;
    }
    
    





    //leer fichero de objetivos(funciona igual que el de configuracion.txt)

    datas="";
    try {
      File myObj = new File("objetivos.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        datas = datas + data;
      }
      myReader.close();
    }

    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    partes = datas.split(">");
    for (int i = 1; i < 3; i++) {
      cambios=partes[i].split("<");
      partes[i]=cambios[0];
    }
    
    numelementos = new int[2];
    for(int i=0 ; i<2 ; i++){
      for(int j=0; j<partes[i+1].length(); j++){
        if(partes[i+1].charAt(j)=='('){
          numelementos[i]++;
        if(partes[i+1].charAt(j)==')'){
            if(numelementos[i]==0)
              flag2=1;
          }
        }
      }
    }

    localizacionesObjetivoString = new String [numelementos[0]];
    objetosObjetivoString = new String [numelementos[1]];
    cambio="";

    count = 0;

    try {
       // for para las localizaciones objetivo
    for (int i=0; count<numelementos[0]; ++i){
      if (partes[1].charAt(i)==')'){
        localizacionesObjetivoString[count]="";
        cambio=cambio+partes[1].charAt(i);
        localizacionesObjetivoString[count]=localizacionesObjetivoString[count]+cambio;
        ++count;
        cambio="";
        continue;
      }
      cambio=cambio+partes[1].charAt(i);
      if(cambio.charAt(0)==' ')
        cambio="";
    }
    for (int f,i = 0; i < numelementos[0]; i++) {                 //Control de errores /*
      f=0;
      for (int j = 0; j < localizacionesObjetivoString[i].length(); j++) {
        if(localizacionesObjetivoString[i].charAt(j)==')'||localizacionesObjetivoString[i].charAt(j)=='('){
          ++f;
        }
      }
      if(f<2||f>2){
        flag2=1;
      }
    }                                                              // */

    count=0;

    // for para los objetos objetivo
    for (int i=0; count<numelementos[1]; ++i){
      if (partes[2].charAt(i)==')'){
        objetosObjetivoString[count]="";
        cambio=cambio+partes[2].charAt(i);
        objetosObjetivoString[count]=objetosObjetivoString[count]+cambio;
        ++count;
        cambio="";
        continue;
      }
      cambio=cambio+partes[2].charAt(i);
      if(cambio.charAt(0)==' ')
        cambio="";
    }
    for (int f,i = 0; i < numelementos[0]; i++) {                 //Control de errores /*
      f=0;
      for (int j = 0; j < objetosObjetivoString[i].length(); j++) {
        if(objetosObjetivoString[i].charAt(j)==')'||objetosObjetivoString[i].charAt(j)=='('){
          ++f;
        }
      }
      if(f<2||f>2){
        flag2=1;
      }
    }                                                              // */

    } catch (Exception e) {
      System.out.println("ERRROR EN LA LECTURA DE FICHERO");
      flag2=1;
    }
    
    System.out.println("");
  }
}
