package domain;

import java.util.HashMap;

public class Conserje extends Usuario{
	Pasajero Pasajero;
	Habitacion habitacion= new Habitacion();
	HashMap<Integer, Habitacion>ListaHabitaciones;

	public void listar(String nomPelicula)
	{
	    Iterator it = MapaPelicula.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry me = (Map.Entry<Integer, PeliculaTO>) it.next();
	        PeliculaTO pelicula = (PeliculaTO) me.getValue();
	        if (pelicula.getTitulo() == nomPelicula)
	        {
	          MapaPelicula.remove( me.getKey());
	        }
	    }
}
