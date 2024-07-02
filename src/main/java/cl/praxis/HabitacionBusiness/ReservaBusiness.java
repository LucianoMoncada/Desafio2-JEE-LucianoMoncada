package cl.praxis.HabitacionBusiness;

import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.Reservas;

public class ReservaBusiness {
	List<Reservas> lista = new ArrayList<>();

	public ReservaBusiness() {
		super();
		
	}
	public void addReserva(Reservas reservas) {
		lista.add(reservas);
	}
	public List<Reservas> allReservas(){
		return lista;
	}
}