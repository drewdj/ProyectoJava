import java.util.ArrayList;

public class Creencias {

    private ArrayList<Localizacion> localizacionesConocidas;


    public void setLocalizacionesConocidas(ArrayList<Localizacion> localizacionesConocidas) {
        this.localizacionesConocidas = localizacionesConocidas;
    }

    public ArrayList<Localizacion> getLocalizacionesConocidas() {
        return localizacionesConocidas;
    }

    public void addLocalizacion(Localizacion localizacion){
        this.localizacionesConocidas.add(localizacion);
    }

}
