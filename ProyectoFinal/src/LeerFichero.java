import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class LeerFichero {

  public static void main(String[] args) {
	String Localizaciones="",Personajes="",Objetos="";
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
    Localizaciones = partes[1];
    Personajes = partes[2];
    Objetos = partes[3];

    System.out.println(Localizaciones);
    System.out.println(Personajes);
    System.out.println(Objetos);
  }


}
