public class GestorPrueba {
    public static void main(String[] args) {
        Personaje personaje1 = new Personaje();

        personaje1.setNombre("Jorge");
        personaje1.setLocalizacionActual("Comedor");
        personaje1.setLocalizacionObjetivo("Jardin");
        personaje1.setObjetoActual("Pan");
        personaje1.setObjetoObjetivo("Cartera");

        personaje1.actualizacion(new String[]{"Salon","Jardin"},new String[]{"Cuchillo","Tenedor"},new String[]{"Patata"});

    }
}
