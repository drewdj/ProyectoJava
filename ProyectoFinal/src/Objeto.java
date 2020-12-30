public class Objeto {
    private String nombre;

    public Objeto(){

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Objeto(Objeto another){
        this.nombre = another.nombre;
    }


}
