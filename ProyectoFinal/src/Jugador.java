public class Jugador extends Personaje{
    
    public void informacion(){
        System.out.println("Localizaciones  conocidas:");
        for (int i = 0; i < (this.getCreencias().getLocalizacionesConocidas().size()); i++) {
            System.out.println(this.getCreencias().getLocalizacionesConocidas().get(i).getNombre());
        }
        System.out.println("Objetos conocidos:");
        for (int i = 0; i < (this.getCreencias().getObjetosConocidos().size()); i++) {
            System.out.println(this.getCreencias().getObjetosConocidos().get(i).getNombre());
        }
        System.out.println("Personaje conocidos:");
        for (int i = 0; i < (this.getCreencias().getPersonajesConocidos().size()); i++) {
            System.out.println(this.getCreencias().getPersonajesConocidos().get(i).getNombre());
        }

    }
}
