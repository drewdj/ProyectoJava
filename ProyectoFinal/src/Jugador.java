public class Jugador extends Personaje{
	 public void moverJugador(Localizacion localizacionMover) {
		    outer:
		        for(int i = 0; i < localizacionActual.contarConexiones(); i++) {
		            if(localizacionMover.getNombre().equals(localizacionActual.getConexiones(i))) {
		                for(int c = 0; c < localizacionActual.getPersonajesPresentes().size(); c++) {
		                    if(localizacionActual.getPersonajesPresentes().get(c).getNombre().equals(this.getNombre())) {
		                        localizacionActual.removePersonajePresente(c);
		                        this.localizacionActual = localizacionMover;
		                        localizacionActual.addPersonajePresente(this);
								this.getHistorial().add("Me he movido a " + localizacionActual.getNombre());
		                        break outer;
		                    }
		                }
		            }
		        }
		    }
}
