package shubham.flights.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shubham.flights.model.FlightModel;

public class FlightDao {

	private String dburl = "jdbc:mysql://localhost:3306/flightdb";
	private String dbname = "root";
	private String dbpassword = "alexa123";
//	private String dbdriver = "com.mysql.cj.jdbc.Driver";

	private static final String INSERT_FLIGHTS_SQL = "INSERT INTO flightdb.flights"
			+ " (FlightName, DepTime, ArrTime, Legs, Price, IsOffer, DeptCity, ArrCity, OfferPrice) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	private static final String SELECT_FLIGHT_BY_ID = "SELECT FlightId, FlightName, DepTime, ArrTime, Legs, Price, IsOffer, DeptCity, ArrCity, OfferPrice"
			+ " FROM flights WHERE FlightId = ?";
	private static final String SELECT_ALL_FLIGHTS = "SELECT * FROM flightdb.flights";
	private static final String DELETE_FLIGHT_SQL = "DELETE FROM flights WHERE FlightId = ?;";
	private static final String UPDATE_FLIGHT_SQL = "UPDATE flights SET " + " FlightName = ?, DepTime = ?, ArrTime = ?, Legs = ?, Price = ?, IsOffer = ?, DeptCity = ?, ArrCity = ?, OfferPrice = ? WHERE FlightId = ?;";
	private static final String SEARCH_FLIGHT_BY_DAT = "SELECT * FROM flightdb.flights WHERE DeptCity = ? AND ArrCity = ? AND DepTime = ? ORDER BY OfferPrice;";
//	private static final String UPDATE_FLIGHT_SQL = "SET SQL_SAFE_UPDATES = 0;" + "UPDATE flightdb.flights SET "
//			+ "FlightName = ?, DepTime = ?, ArrTime = ?, Legs = ?, Price = ?, IsOffer = ? WHERE FlightId = ?;"
//			+ "SET SQL_SAFE_UPDATES = 1;";
	
	public FlightDao() {}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, dbname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertFlight(FlightModel flight) throws SQLException {
		System.out.println(INSERT_FLIGHTS_SQL);
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FLIGHTS_SQL);
			preparedStatement.setString(1, flight.getFlightName());
			preparedStatement.setString(2, flight.getDeptTime());
			preparedStatement.setString(3, flight.getArrivalTime());
			preparedStatement.setInt(4, flight.getTotalLegs());
			preparedStatement.setDouble(5, flight.getFlightPrice());
			preparedStatement.setInt(6, flight.getIsOffer());
			preparedStatement.setString(7, flight.getDeptCity());
			preparedStatement.setString(8, flight.getArrCity());
			preparedStatement.setDouble(9, flight.getOfferPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
    }
	
	public FlightModel selectFlight(int id) {
        FlightModel flight = null;
        // Step 1: Establishing a Connection
        Connection connection = getConnection();
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FLIGHT_BY_ID);
            System.out.println("hereselectFlight");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
//            System.out.println(rs);

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String FlightName = rs.getString("FlightName");
                String DepTime = rs.getString("DepTime");
                String ArrTime = rs.getString("ArrTime");
                int Legs = rs.getInt("Legs");
                int IsOffer = rs.getInt("IsOffer");
                Double Price = rs.getDouble("Price");
                String DeptCity = rs.getString("DeptCity");
                String ArrCity = rs.getString("ArrCity");
                Double OfferPrice = rs.getDouble("OfferPrice");
                flight = new FlightModel(id, FlightName, ArrTime, DepTime, Legs, IsOffer, Price, DeptCity, ArrCity, OfferPrice);
                System.out.println(flight);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return flight;
    }
	
	public List < FlightModel > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < FlightModel > allFlights = new ArrayList < > ();
        // Step 1: Establishing a Connection
        Connection connection = getConnection();
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FLIGHTS);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	System.out.println(rs);
            	int FlightId = rs.getInt("FlightId");
            	 String FlightName = rs.getString("FlightName");
                 String DepTime = rs.getString("DepTime");
                 String ArrTime = rs.getString("ArrTime");
                 int Legs = rs.getInt("Legs");
                 int IsOffer = rs.getInt("IsOffer");
                 Double Price = rs.getDouble("Price");
                 String DeptCity = rs.getString("DeptCity");
                 String ArrCity = rs.getString("ArrCity");
                 Double OfferPrice = rs.getDouble("OfferPrice");
                 System.out.println("sau "+OfferPrice);
                 allFlights.add(new FlightModel(FlightId, FlightName, ArrTime, DepTime, Legs, IsOffer, Price, DeptCity, ArrCity, OfferPrice));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return allFlights;
    }

    public boolean deleteFlight(int id) {
        boolean rowDeleted = false;
        Connection connection = getConnection();
        try {
        	PreparedStatement statement = connection.prepareStatement(DELETE_FLIGHT_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch(SQLException e) {
        	printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateFlight(FlightModel flight) {
        boolean rowUpdated = false;
        Connection connection = getConnection();
        try {
        	PreparedStatement statement = connection.prepareStatement(UPDATE_FLIGHT_SQL);
            statement.setString(1, flight.getFlightName());
            statement.setString(2, flight.getDeptTime());
            statement.setString(3, flight.getArrivalTime());
            statement.setInt(4, flight.getTotalLegs());
            statement.setDouble(5, flight.getFlightPrice());
            statement.setInt(6, flight.getIsOffer());
            statement.setString(7, flight.getDeptCity());
            statement.setString(8, flight.getArrCity());
            statement.setDouble(9, flight.getOfferPrice());
            statement.setInt(10, flight.getFlightId());
            System.out.println(statement.toString());
            rowUpdated = statement.executeUpdate() > 0;
        }catch(SQLException e) {
        	printSQLException(e);
        }
        return rowUpdated;
    }
    
    public List < FlightModel > selectAllFlights(String DeptCity, String ArrCity, String DepTime) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < FlightModel > allFlights = new ArrayList < > ();
        // Step 1: Establishing a Connection
        Connection connection = getConnection();
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_FLIGHT_BY_DAT);
            preparedStatement.setString(1, DeptCity);
            preparedStatement.setString(2, ArrCity);
            preparedStatement.setString(3, DepTime);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	System.out.println(rs);
            	int FlightId = rs.getInt("FlightId");
            	 String FlightName = rs.getString("FlightName");
                 String DepTim = rs.getString("DepTime");
                 String ArrTime = rs.getString("ArrTime");
                 int Legs = rs.getInt("Legs");
                 int IsOffer = rs.getInt("IsOffer");
                 Double Price = rs.getDouble("Price");
                 String DeptCit = rs.getString("DeptCity");
                 String ArrCit = rs.getString("ArrCity");
                 Double OfferPrice = rs.getDouble("OfferPrice");
                 allFlights.add(new FlightModel(FlightId, FlightName, ArrTime, DepTim, Legs, IsOffer, Price, DeptCit, ArrCit, OfferPrice));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return allFlights;
    }

	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	
	
}
