package webapp;

import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class MyServletContextListener implements ServletContextListener{
	
	public static Logger logger = Logger.getLogger("Demo");

	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Demo wird gestartet.");
		try {
			Context initialContext = new InitialContext();
			Context context = (Context)initialContext.lookup("java:comp/env");
			DataSource datasource = (DataSource) context.lookup("jdbc/DefaultDB");
			
			Connection connection = datasource.getConnection();
			logger.info("Datasource ist verfügbar");

			Statement statement = connection.createStatement();
			logger.info("Datasource erfolgreich getestet");
			statement.executeQuery("select * from product");
			logger.info("Datasource erfolgreich getestet");

			sce.getServletContext().setAttribute("datasource",datasource);	
		} catch (Exception e) {
			logger.severe("Problem beim Zugriff auf Datasource, start von Demo gescheitert:\n" + e);
			throw new RuntimeException(e);
		}
		sce.getServletContext().setAttribute("dateformat","dd.MM.yyyy");
		// Hier können Sie weiteren Programmcode einfügen, der beim Start der
		// Web-Application ausgeführt werden soll.
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("Demo wird gestoppt.");
		// Hier können Sie weiteren Programmcode einfügen, der beim Stoppen der
		// Web-Application ausgeführt werden soll.
	}
}
