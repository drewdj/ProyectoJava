import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 

/*Esta clase lee los ficheros configuracion.txt y objetivo.txt
  Para que esto funcione se debe ejecutar el main en el GestorPrueba (o GestorFinal(el gestor cambia mas rapido de nombre que un rapero))*/
public class LeerFichero {


  private String localizacionesString[];
  private String personajesString[];
  private String objetosString[];
  private String localizacionesObjetivoString[];
  private String objetosObjetivoString[];

  public void main(String[] args) {       

    //leer fichero de configuracion
    String datas="";

    try {

      File myObj = new File("./src/configuracion.txt");
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

    //calcular num de elementos de cada parte
    int[] numelementos = new int[3];

    for(int i=0 ; i<3 ; i++){
      for(int j=0; j<tamanios[i] ; j++){
        if(partes[i+1].charAt(j)=='(')
          numelementos[i]++;
      }
    }

    localizacionesString = new String [numelementos[0]];      //incializa la informacion de cada objeto segun el largo de los strings que hemos separado
    personajesString = new String [numelementos[1]];
    objetosString = new String [numelementos[2]];
    String cambio = "";
    int count = 0 ;

    //se rellena cada string con un for propio
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
  

    
    //leer fichero de objetivos(funciona igual que el de configuracion.txt)

    datas="";
    try {
      File myObj = new File("./src/objetivos.txt");
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
    cambios= partes[1].split("<");
    partes[1]=cambios[0];
    cambios= partes[2].split("<");
    partes[2]=cambios[0];

    tamanios= new int[2];
    tamanios[0]=partes[1].length();
    tamanios[1]=partes[2].length();

    numelementos = new int[2];

    for(int i=0 ; i<2 ; i++){
      for(int j=0; j<tamanios[i] ; j++){
        if(partes[i+1].charAt(j)=='(')
          numelementos[i]++;
      }
    }

    localizacionesObjetivoString = new String [numelementos[0]];
    objetosObjetivoString = new String [numelementos[1]];
    cambio="";

    count = 0;

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


    }

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
    }
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

  public String[] getLocalizacionesObjetivoString() {
    return localizacionesObjetivoString;
  }

  public String[] getObjetosObjetivoString() {
    return objetosObjetivoString;
  }






}
