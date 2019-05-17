package Threads.ThreadsPrueba;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Monitor {
	/*
	 Metodos 
	 
	 ejecutan los hilos
	 crearn un reader y un writer
	 
	 get() entrada de datos
	 put() salida de datos
	 
	 Crear el buffer el ArrayList
	 
	 solo recibe el archivo
	 
	 patron Singleton
	 start a los hilos
	 metodos sincronizados
	 
	 
	 Array
	 Declarar: Tipo [] nombreArray;
	 Instanciar: nombreArray = new Numeros[10]; (Array de 10 elementos).
	 Inicializar: nombreArray[indice] = valor;

	
	 Extraer: variableReceptora = nombreArreglo[indice];

	 */
	
	private static final Logger LOG = LogManager.getLogger(Monitor.class);
	private static Monitor monitor;
	private List<String> buffer = new ArrayList<String>();
	String [] listaBuffer;
	
	
	private Monitor(){}
	
	public static Monitor getMonitor() {
		if(monitor == null) {
			monitor = new Monitor();
			LOG.info("Se creo monitor");
		}else {
			LOG.info("monitor antes creado");
		}
		return monitor;
	}
	
	
	public synchronized void get(File file) {
		try {
			Reader reader = new Reader(file, buffer);
			reader.start();
			reader.join();
			LOG.info("metodo get Reader");
		}catch(Exception e) {
			e.printStackTrace();
			LOG.error("error en el metodo get: " + e.getMessage());
		}
		
	}
	
	public synchronized void put(File file) {
		try {
			Writer writer = new Writer(file, buffer);
			writer.start();
			LOG.info("metodo put Writer");
		}catch(Exception e) {
			e.printStackTrace();
			LOG.error("error en el metodo put: " + + e.getMessage());
		}
		
	}

}


/*Ejemplo singleton
 
 * public class ClaseSingleton {
    private static ClaseSingleton instanciaUnica;
 
    private ClaseSingleton() {}

    private synchronized static void createInstance() {
        if (instanciaUnica == null) { 
            instanciaUnica = new ClaseSingleton();
        }
    }
 
    public static ClaseSingleton getInstance() {
        createInstance();
        return instanciaUnica;
    }
} 
 */
