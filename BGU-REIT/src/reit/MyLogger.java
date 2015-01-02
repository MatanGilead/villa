package reit;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyLogger {
	static private FileHandler fileHTML;
	static private Formatter formatterHTML = new MyHtmlFormatter();
	static public Logger getLogger(String myClass) {
		if (fileHTML == null) {
			try {
				fileHTML = new FileHandler("Logging.html");
				fileHTML.setFormatter(formatterHTML);
				Logger.getLogger("").setLevel(Level.INFO);
				Logger.getLogger("").addHandler(fileHTML);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ee");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("ee");
				e.printStackTrace();
			}
		}
		Logger logger = Logger.getLogger(myClass);
		logger.setUseParentHandlers(true);
		return logger;
  }
}
