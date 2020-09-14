/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase Rocket... cohete
 *
 */

package vehiculo.volador;

import java.util.List;

import motor.*;
import vehiculo.Users.Tripulacion;

/**
 * 
 * Clase Cohete. Métodos principales de cohete.
 * aceleraVehiculoVolador y desaceleraVehiculoVolador son las clases más importantes.
 * 
 *  Variables importantes:
 *   - motores : lista de objetos motor.
 *   - nomcohete: su nombre.
 *  El resto no se utilizan en la resolución del ejercicio.
 * 
 * @author Rubén Rodríguez Fernández
 *
 */

public class Rocket extends VehiculoVolador {
	
	
	List <MotorCohete> motores;
	private String destino;
	private List<Tripulacion> tripulacion;
	private String nomCohete;
	
	/**
	 * Constructor
	 * 
	 * @param id identificador del cohete
	 * @param tipoVehiculo tipo de vehiculo volador
	 * @param tipoMotor tipo d emotor que utiliza.
	 * @param anyoFabricacion datos tipo int del año de fabricación 
	 * @param propulsores lista de objetos de clase motor.
	 * 
	 * 
	 */
	public Rocket(String id, String tipoVehiculo, String tipoMotor, int anyoFabricacion, List<MotorCohete> propulsores) {
		super(id,tipoVehiculo,tipoMotor,anyoFabricacion);
		this.motores = propulsores;
	}
	
	/**
	 * Constructor 
	 * 
	 * @param id identificador del cohete
	 * @param tipoVehiculo tipo de vehiculo volador
	 * @param tipoMotor tipo d emotor que utiliza.
	 * @param anyoFabricacion datos tipo int del año de fabricación 
	 * @param propulsores lista de objetos de clase motor.
	 * @param nomCohete   cadena con el nombre del cohete.
	 */
	public Rocket(String id, String tipoVehiculo, String tipoMotor, int anyoFabricacion, List<MotorCohete> propulsores, String nomCohete) {
		super(id,tipoVehiculo,tipoMotor,anyoFabricacion);
		this.motores = propulsores;
		this.nomCohete = nomCohete;
	}
	
	/**
	 * Devuelve la lista de motores del cohete.
	 * @return the motores
	 */
	public List<MotorCohete> getMotores() {
		return motores;
	}


	/**
	 * Agrega un motor a la lista de motores del cohete. No se utiliza en la resolución del ejercicio ya qu elos pasamos por constructor.
	 * @param motores the motores to set
	 */
	
	public void setMotor (MotorCohete motorCohete ) {
		motores.add(motorCohete);
	}
	/**
	 * Sobreescribe, si existiera, la lista de motores por los recibios por parámetro.
	 * @param motores
	 */
	
	public void setMotores(List<MotorCohete> motores) {
		this.motores = motores;
	}


	/**
	 * Devuelve destino objetivo del cohete.
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * implementa método abstracto que devuelve el nombre del cohete.
	 */
	@Override
	public String getNombre() {
		return nomCohete;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	/**
	 * implementa método abstracto que devuelve el id del cohete.
	 */
	@Override
    public String getID() {
    	return super.getID();
    }
	/**
	 * Devuelve una lista d ela tripulación.
	 * @return the tripulacion
	 */
	public List<Tripulacion> getTripulacion() {
		return tripulacion;
	}

	/**
	 * Sobreescribe la tripulación existente, si existe.
	 * @param tripulacion 
	 */
	public void setTripulacion(List<Tripulacion> tripulacion) {
		this.tripulacion = tripulacion;
	}

	/**
	 * El método lanza un hilo por cada propulsor y ejecuta el método run de la clase ControlVuelo.
	 * Dicho hilo recibe el motor asignador a ese hilo, la velocidad que debe alcanzar y el nombre del cohete que posee 
	 * dicho motor (para imprimirlo luego por consola).
	 *  
	 *  Es un método sincronizado. Es necesario ya que el cohete puede cambiar de velociad en sus propulsores. La orden
	 *  de cambio puede darse antes de finalizar la anterior. Nosotros configuramos la APP para que cualquier cambio
	 *  en la velocidad de los propulsores espere que finalize la anterior.
	 *  
	 *  
	 * @param velocidadesMotoresObjetivo  Array donde tenemos las velocidades objetivo para los propulsores.
	 */
	@Override
	public synchronized void aceleraVehiculoVolador(int[] velocidadesMotoresObjetivo) {
		int i=0;
		//Un hilo por cada motor.
		Thread[] volando = new Thread[velocidadesMotoresObjetivo.length]; 
		
		//por cada hilo un objeto ControlVuelo.
		for (MotorCohete motor: motores) {
			volando[i] = new ControlVuelo(motor, velocidadesMotoresObjetivo[i], nomCohete);
			volando[i].start();
			i++;

		}
		
		/**
		 * Esperamos a que finalicen los hilos para continuar con el siguiente cambio en el control de velocidad.
		 * Si se ha lanzado un nuevo array de velocideades para los propulsores se debe esperar a que el cambio actual 
		 * finalice.
		 */
		for (Thread hilo: volando) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Esta clase es similar a la anterior. No la explicamos. Al final es indiferente ya que la clase solo recoge los
	 * nuevos valores de los propulsores. Será el propio propulsor quien decirá si acelera o desacelera.
	 */
	@Override
	public synchronized void desaceleraVehiculoVolador(int[] velocidadesMotoresObjetivo) {
		int i=0;
		//Un hilo por cada motor.
		Thread[] volando = new Thread[velocidadesMotoresObjetivo.length]; 
		
		//por cada hilo un objeto ControlVuelo.
		for (MotorCohete motor: motores) {
			volando[i] = new ControlVuelo(motor, velocidadesMotoresObjetivo[i], nomCohete);
			volando[i].start();
			i++;

		}
		
		/**
		 * Esperamos a que finalicen los hilos para continuar con el siguiente cambio en el control de velocidad.
		 * Si se ha lanzado un nuevo array de velocideades para los propulsores se debe esperar a que el cambio actual 
		 * finalice.
		 */
		for (Thread hilo: volando) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @return Array de enteros. Devuelve un arreglo de la potencia de los motores del cohete.
	 */
	@Override
	public int[] potenciaMotores( ) {
		int [] potencias = new int[motores.size()];
		int i=0;
		
		for (MotorCohete motor: motores) {
			potencias[i] = motor.getPotenciaMaxima();
			i++;
		}
		return potencias;
	}
	
	/**
	 * Métodos de impresión en pantalla
	 */
	
	@Override
	public String toString() {
		return "Cohete con identificador: "+this.id+". Año de Fabricación: "+this.anyoFabricacion+". Dispone de "+motores.size()+" propulsores. \n\n Los motores del cohete son:"+motoresToString();
	};
	
	@Override
	public String toStringFase3() {
		return "Cohete con identificador: "+this.id+". Año de Fabricación: "+this.anyoFabricacion+". Dispone de "+motores.size()+" propulsores. \n\n ";
	};
	
	/**
	 * 
	 * @return Cadena de información de los motores del vehículo. Para ello llamamos al método toString de la clase motor.
	 */
	
	public String motoresToString() {
		String descripcion ="";
		for (MotorCohete motor: motores) {
			descripcion+= "\n"+motor.toString();
		}
		return descripcion;
	}
}
