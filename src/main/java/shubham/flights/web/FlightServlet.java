package shubham.flights.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import shubham.flights.dao.FlightDao;
import shubham.flights.model.FlightModel;

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/")
public class FlightServlet extends HttpServlet {
	private FlightDao flightdao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	flightdao = new FlightDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
//		action += "/manager";
		try {
			switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				System.out.println("insert");
				insertFlight(request, response);
				break;
			case "/delete":
				deleteFlight(request, response);
				break;
			case "/edit":
				System.out.println("edit");
				showEditForm(request, response);
				break;
			case "/update":
				System.out.println("update-case");
				updateFlight(request, response);
				break;
			case "/search":
				System.out.println("search-case");
				showNewSearchForm(request, response);
				break;
			case "/searchFlight":
				System.out.println("search-flight-case");
				listFlightsByParameter(request, response);
				break;
			default:
				listFlights(request, response);
				break;
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	private void listFlights(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < FlightModel > listFlights = flightdao.selectAllUsers();
		        request.setAttribute("listFlights", listFlights);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-list.jsp");
		        dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		System.out.println("show new form function");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
		        dispatcher.forward(request, response);
	}
	
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
		 System.out.println("show-edit-form");
//		 System.out.println(request.getParameter("id"));
			        int id = Integer.parseInt(request.getParameter("id"));
			        System.out.println(id);
			        FlightModel existingFlight = flightdao.selectFlight(id);
			        System.out.println("fs --->"+existingFlight.toString());
//			        System.out.println(request.getRequestDispatcher("flight-form.jsp"));
			        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
			        System.out.println("dis + "+dispatcher);
			        request.setAttribute("flight", existingFlight);
			        System.out.println("after set"+existingFlight);
			        dispatcher.forward(request, response);

	 }
	 
	 private void insertFlight(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		 System.out.print("inseert Flight Function");
			        String FlightName = request.getParameter("FlightName");
//			        System.out.println(FlightName);
			        String DepTime = request.getParameter("DepTime");
			        String ArrTime = request.getParameter("ArrTime");
			        int legs = Integer.parseInt(request.getParameter("Legs"));
			        Double price = Double.parseDouble(request.getParameter("Price"));
			        int isOffer  = Integer.parseInt(request.getParameter("IsOffer"));
			        String DepCity = request.getParameter("DeptCity");
			        String ArrCity = request.getParameter("ArrCity");
			        Double OfferPrice = Double.parseDouble(request.getParameter("OfferPrice"));
			        FlightModel newFlight = new FlightModel(FlightName, ArrTime, DepTime, legs, isOffer, price, DepCity, ArrCity, OfferPrice);
			        flightdao.insertFlight(newFlight);
			        System.out.println("insEnd");
			        response.sendRedirect("list");
	 }
	 
	 private void updateFlight(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int FlightId = Integer.parseInt(request.getParameter("flightId"));
			        String FlightName = request.getParameter("FlightName");
			        String DepTime = request.getParameter("DepTime");
			        String ArrTime = request.getParameter("ArrTime");
			        int legs = Integer.parseInt(request.getParameter("Legs"));
			        Double price = Double.parseDouble(request.getParameter("Price"));
			        int isOffer  = Integer.parseInt(request.getParameter("IsOffer"));
			        String DepCity = request.getParameter("DeptCity");
			        String ArrCity = request.getParameter("ArrCity");
			        Double OfferPrice = Double.parseDouble(request.getParameter("OfferPrice"));
			        FlightModel updatedFlight = new FlightModel(FlightId, FlightName, ArrTime, DepTime, legs, isOffer, price, DepCity, ArrCity, OfferPrice);
			        System.out.println("updayed"+updatedFlight);
			        flightdao.updateFlight(updatedFlight);
			        response.sendRedirect("list");
	   }
	 
	 private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        flightdao.deleteFlight(id);
			        response.sendRedirect("list");

	 }
	 
	 private void showNewSearchForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			 System.out.println("search-flight-form");
	//		 System.out.println(request.getParameter("id"));
			 RequestDispatcher dispatcher = request.getRequestDispatcher("search-flight-form.jsp");
	         dispatcher.forward(request, response);

	 }
	 
	 private void listFlightsByParameter(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
					String DeptCity = request.getParameter("DeptCity");
					System.out.println(DeptCity);
					String ArrCity = request.getParameter("ArrCity");
					String DepTime = request.getParameter("DepTime");
			        List < FlightModel > listFlights = flightdao.selectAllFlights(DeptCity, ArrCity, DepTime);
			        request.setAttribute("listFlights", listFlights);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("user-search-flight-list.jsp");
			        dispatcher.forward(request, response);
		}

}
