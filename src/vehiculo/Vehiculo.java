/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase ControladorVistaMenu
 *
 */

package vehiculo;

/**
 * Interfaz Vehículo. Describe las operacions básicas sobre cualquier tipo de vehículo.
 * 
 * @author Rubén Rodríguez Fernández
 *
 */

public interface Vehiculo {
	
	String getID();
	String getTipoVehiculo();
	String toString();
	int getAnyoFabricacion();
	String getTipoMotor();
	
	
	

}
