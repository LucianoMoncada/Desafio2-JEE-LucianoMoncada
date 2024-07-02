package cl.praxis.model.habitacionbusiness;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.praxis.HabitacionBusiness.ReservaBusiness;
import cl.praxis.model.Reservas;

@WebServlet("/OperandoReserva")
public class OperandoReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HabitacionBusiness habitacionBusiness = new HabitacionBusiness();
	ReservaBusiness reservaBusiness = new ReservaBusiness();
    public OperandoReserva() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("habitacionBusiness",this.habitacionBusiness.allRooms());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = (String)request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		String email = (String)request.getParameter("email");
		int valorPagar = Integer.parseInt(request.getParameter("valorPagar"));
		String medioPago = (String)request.getParameter("metodoPago");
		String dias = (String)request.getParameter("dias");
		LocalDate fechaEntrada = LocalDate.parse(request.getParameter("fechaEntrada"));
		Reservas reserva = new Reservas(nombre, apellido, email, medioPago, dias, fechaEntrada, valorPagar);
		reservaBusiness.addReserva(reserva);
		System.out.println(reserva.getApellido());
		request.setAttribute("reservas",reserva);
		getServletContext().getRequestDispatcher("/proceso.jsp").forward(request, response);
	}

}