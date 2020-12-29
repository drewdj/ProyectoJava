import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;


public class LeerFichero {

  
  String localizacionesString[]; 
  String personajesString[]; 
  String objetosString[]; 
  

  public void main(String[] args) {

    //leer fichero de configuracion 
    String datas="";
    String[] Localizaciones,Personajes,Objetos;
    

    try {
      
      File myObj = new File(".\\src\\configuracion.txt");
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

    String[] partes = datas.split(">");
    String[] cambios;
    cambios= partes[1].split("<");
    partes[1]=cambios[0];
    cambios= partes[2].split("<");
    partes[2]=cambios[0];
    cambios= partes[3].split("<");
    partes[3]=cambios[0];

    int[] tamanios= new int[3];
    tamanios[0]=partes[1].length();
    tamanios[1]=partes[2].length();
    tamanios[2]=partes[3].length();

    //calcular num de elementos de cada cosa
    int[] numelementos = new int[3];

    for(int i=0 ; i<3 ; i++){
     
      for(int j=0; j<tamanios[i] ; j++){

        if(partes[i+1].charAt(j)=='('){
          numelementos[i]++;
        }

      }
    }

    localizacionesString = new String [numelementos[0]]; 
    personajesString = new String [numelementos[1]]; 
    objetosString = new String [numelementos[2]]; 
    String cambio = "";
    int count = 0 ;

    //for para Localizaciones
    for (int i=1; count<numelementos[0]; ++i){

      if (partes[1].charAt(i)==')'){
        localizacionesString[count]="";
        cambio=cambio+partes[1].charAt(i);
        localizacionesString[count]=localizacionesString[count]+cambio;
        ++count;
        
        cambio="";
        continue;
      }

      cambio=cambio+partes[1].charAt(i);
     

    }
    //System.out.println(localizacionesString[0]);

    count=0;
    
    //for para Personajes
    for (int i=1; count<numelementos[1]; ++i){

      if (partes[2].charAt(i)==')'){
        personajesString[count]="";
        cambio=cambio+partes[2].charAt(i);
        personajesString[count]=personajesString[count]+cambio;
        ++count;
        
        cambio="";
        continue;
      }

      cambio=cambio+partes[2].charAt(i);
     

    }
    //System.out.println(personajesString[0]);

    count=0;
    
    //for para Objetos
    for (int i=1; count<numelementos[2]; ++i){

      if (partes[3].charAt(i)==')'){
        objetosString[count]="";
        cambio=cambio+partes[3].charAt(i);
        objetosString[count]=objetosString[count]+cambio;
        ++count;
        
        cambio="";
        continue;
      }

      cambio=cambio+partes[3].charAt(i);
     

    }
    //System.out.println(objetosString[0]);
  
    

   
    
    
    //localizacionesString = datos[0];
    //personajesString = datos[1];
    //objetosString = datos[2];
    
      
    //leer fichero de objetivos
    /*
    datas="";
    try {

      File myObj = new File("ProyectoFinal\\src\\objetivos.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        datas = datas + data;
      }
      System.out.println(datas);
      myReader.close();

    } 
    
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    */
  }



 


 
  public String[] getLocalizaString() {
    return localizacionesString;
  }

  public String[] getObjetosString() {
    return objetosString;
  }

  public String[] getPersonajesString() {
    return personajesString;
  }
 
  




}