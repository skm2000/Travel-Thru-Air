package shubham.flights.dao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
/**
 * Application Lifecycle Listener implementation class myServletListener
 *
 */
public class ServletListener implements ServletContextListener {
 
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
 
    	ServletContext sc = event.getServletContext();
 
    	String url = sc.getInitParameter("url");
    	String user_name = sc.getInitParameter("user_name");
    	String password = sc.getInitParameter("password");
    	String database = sc.getInitParameter("database");
//    	Database db = new Database(url + database, user_name, password);
    	//System.out.println("in the listener!!");
//    	sc.setAttribute("db", db);
 
    }
 
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
 
}