package Threads.ThreadsPrueba;

import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
	C:\Users\Sonia Gama\Documents\CopyThread\Original.txt
	C:\Users\Sonia Gama\Documents\CopyThread\Copia.txt
	File archivo = new File(“rutaDelArchivo\nombreDelArchivo.extensión”);
	Solo debe pasar los archivos


 */
public class Copy {
    public static void main( String[] args ){
    	//File original = new File("C:\\Users\\Sonia Gama\\Documents\\CopyThread\\Original.txt"); //6 kb
    	//File original = new File("C:\\Users\\Sonia Gama\\Documents\\CopyThread\\Original1.txt"); //46 kb
    	File original = new File("C:\\Users\\Sonia Gama\\Documents\\CopyThread\\Original0.txt"); //4292 kb
    	//File original = new File("C:\\Users\\Sonia Gama\\Documents\\CopyThread\\Original2.txt"); //840244 kb
    	
    	File copia = new File("C:\\Users\\Sonia Gama\\Documents\\CopyThread\\Copia.txt");
    
    	Logger LOG = LogManager.getLogger(Copy.class);
    	try {
    		Monitor monitor = Monitor.getMonitor();
        	monitor.get(original);
        	monitor.put(copia); 	    	
        	LOG.info("final del main");
    	}catch(Exception e) {
    		e.printStackTrace();
    		LOG.error("ERROR en el main Copy: " + e.getMessage());
    	}
    	
    }
}
