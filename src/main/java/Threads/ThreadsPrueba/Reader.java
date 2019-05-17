package Threads.ThreadsPrueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader extends Thread {
	
	/*
	 Metodo run lee del archivo y copia al buffer
	 
	 El constructor registra:
	 
	 Archivo desde donde lee datos
	 buffer donde se registran los datos
	 */
	
	private File file;
	private List<String> buffer;
	private static final Logger LOG = LogManager.getLogger(Reader.class);
	//String [] listaBuffer;
	
	public Reader(File file, List<String> buffer) {
		this.file = file;
		this.buffer = buffer;
	}
	
	public void run(){
		
		/*abre el archivo de entrada
		  convierte las lineas en strings
		  añade al buffer
		  */

			try {
				BufferedReader leerLista = new BufferedReader(new FileReader(file));
				String buffered;
				while((buffered = leerLista.readLine())!= null) {
					buffer.add(buffered);	
				}
				leerLista.close();
				/*
				int linea = 0;				
				for(String lista: buffer) {
					LOG.info("linea: " + linea++ + lista);
				}
				*/
			}catch(ConcurrentModificationException e) {
				e.printStackTrace();
				LOG.error("error en el Reader ConcurrentModificationException: " + e.getMessage());
			}catch(Exception e) {
				e.printStackTrace();
				LOG.error("error en el Reader Exception: " + e.getMessage());
			}
			LOG.info("metodo run Reader");
	}
}
