import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class LeerFichero {

  String localizacionesString[];
  String personajesString[];
  String objetosString[];
  

  public LeerFichero() {

    //leer fichero de configuracion 
    String datas="";
    

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

    String[] partes = datas.split("<");

    int[] tamanios= new int[3];
    tamanios[0]=partes[1].length();
    tamanios[1]=partes[2].length();
    tamanios[2]=partes[3].length();

    String[][] datos = new String[3][5];

    int flag=0;
    int flag2=0;
    for(int i=0 ; i<3 ; i++){

      datos[i][0]="";

      for(int j=0,f=0; j<tamanios[i];j++){

        if(flag==0){
          switch(i){

            case 0: 
            j = 15;
            break;

            case 1:
            j = 11;
            break;

            case 2:
            j= 8;
            break;

          }
          flag=1;
        }

        if(partes[i+1].charAt(j)==')'){
          flag2++;
          
        }

        datos[i][f]=datos[i][f]+partes[i+1].charAt(j);

        if(flag2==1){
          flag2=0;
          f++;
          datos[i][f]="";
        }

      }
      
      flag=0;
    }
    
    localizacionesString = datos[0];
    personajesString = datos[1];
    objetosString = datos[2];
    
      
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