package reit;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyLogger {
	static private FileHandler fileHTML;
	static private Formatter formatterHTML;

	static public Logger getLogger(String myClass) {
    Logger logger = Logger.getLogger(myClass);
    formatterHTML = new MyHtmlFormatter();
		try {
			fileHTML = new FileHandler("Logging.html");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    fileHTML.setFormatter(formatterHTML);
    logger.addHandler(fileHTML);
		logger.setLevel(Level.INFO);
		return logger;
  }
}
