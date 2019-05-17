package Threads.ThreadsPrueba;

import java.io.*;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Writer extends Thread {

	/*
	 * Metodo run lee del buffer y escribe en archivo
	 * 
	 * tomar datos del buffer y escribirlos en el archivo
	 * 
	 * constructor registra el archivo donde se escriben datos y buffer
	 * 
	 */

	private File file;
	private List<String> buffer;
	private static final Logger LOG = LogManager.getLogger(Writer.class);

	public Writer(File file, List<String> buffer) {
		this.file = file;
		this.buffer = buffer;
	}

	public void run() {

		// Leer ArrayList de strings
		// Escribir en archivo
		/* abre archivo de salida y escribir los datos del buffer */

		try {
			BufferedWriter copia = new BufferedWriter(new FileWriter(file));
			for (String renglon : buffer) {
				copia.write(renglon);
				copia.newLine();
			}
			copia.close();

		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
			LOG.error("error en el Writer ConcurrentModificationException: " + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			LOG.error("error en el Writer: " + e.getMessage());
		}
		LOG.info("metodo run Writer");
	}
}
