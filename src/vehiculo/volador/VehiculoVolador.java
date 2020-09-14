/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase VehiculoVolador
 *
 */

package vehiculo.volador;
import java.util.Calendar;

import vehiculo.*;

/**
 * Clase abstracta que implementa la interfact vehículo. 
 * Esta clase implementa algunos métodos comunes a todo vehículo volador y declara varios métodos abstractos que 
 * deberán implementar las subclases.
 * 
 * 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public abstract class VehiculoVolador implements Vehiculo {
	
	protected String id;
	protected String tipoVehiculo;
	protected int anyoFabricacion;
	protected String tipoMotor;
	protected int[] bandaAltitud;
	protected String nombreVehiculo;
	
	
	/**
	 * Constructor.
	 * No recibe parámetro alguno. Se crea el vehículo asignándole el año de fabricación com año actual.
	 */
	public VehiculoVolador() {
	
		anyoFabricacion = Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * constructor. 
	 * @param id id del vehículo
	 * @param tipoVehiculo El tipo de vehículo volador (Rocket, globo aerostático....) 
	 * @param tipoMotor El tipo de motor. En esta app sera "Propulsor".
	 * @param anyofabricacion El año de finalización de la construcción del vehículo volador.
	 */
	
	public VehiculoVolador(String id, String tipoVehiculo, String tipoMotor, int anyoFabricacion) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoMotor = tipoMotor;
		this.anyoFabricacion = anyoFabricacion;
		
	}
	
	/**
	 * constructor. 
	 * @param id id del vehículo
	 * @param tipoVehiculo El tipo de vehículo volador (Rocket, globo aerostático....) 
	 * @param tipoMotor El tipo de motor. En esta app sera "Propulsor".
	 * @param bandaAltitud Banda de altitud con permisos para volar.
	 * @param anyofabricacion El año de finalización de la construcción del vehículo volador.
	 */
	
	public VehiculoVolador(String id, String tipoVehiculo, String tipoMotor, int[] bandaAltitud, int anyoFabricacion) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoMotor = tipoMotor;
		this.bandaAltitud = bandaAltitud;
		this.anyoFabricacion = anyoFabricacion;

		
	}

	/**
	 * Método abstractos.
	 * toStringFase3 - Un caso particular para dicha fase.
	 * potenciaMotores. Debe devolver un array con la potencia de cada otor.
	 * aceleraVehiculoVolador. implementa los mecanismos del vehículo para acelerar
	 * desaceleraVehiculoVolador. implementa los mecanismos del vehículo para desacelerar.
	 */
	public abstract String toString();
	public abstract String toStringFase3();
	public abstract int[] potenciaMotores();

	public abstract void aceleraVehiculoVolador(int[] velocidades);
	public abstract void desaceleraVehiculoVolador(int[] velocidades);
	
	/**
	 * Setters y getters
	 */
	
	@Override
	public String getID() {
	 return id;	
	}
	
	@Override
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	@Override
	public int getAnyoFabricacion() {
		return anyoFabricacion;
	}
	
	@Override
	public String getTipoMotor() {
		return tipoMotor;
	}
	
	public int[] getBandaAltitud () {
		return bandaAltitud;
	}
	
	public void setBandaAltitud(int[] bandaAltitud) {
		this.bandaAltitud = bandaAltitud;
	}
	
	public String getNombre() {
		return nombreVehiculo;
	}
	
}
