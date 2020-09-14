/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase MotorCohete
 *
 */

 
package motor;

/**
 * Interfaz que declara los principales métodos que deben tener motores de cohetes. 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public interface MotorCohete {

	int getPotenciaMaxima();
	int getPotenciaMedia();
	int getPotenciaInstantanea();
	void acelera();
	void desacelera();
	String getID();	
	void setPotenciaMaxima(int potenciaMax);
	void setPotenciaMedia(int potenciaMedia);
	String getModelo();
	int anyoFabricacion();
	String toString();
	boolean cambioPotencia(int velocidadObjetivo);

	
	
}
