/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase Tripulación
 *
 */

 
package vehiculo.Users;


/**
 * 
 * Esta clase no se utiliza para la resolución del ejercico.
 * @author Rubén Rodríguez Fernández
 *
 */
public abstract class Tripulacion implements Persona {
	
	private String id;
	private String nombre;
	private String tipoViajero;
	private int perfilProfesional;
	private float sueldo;
	
	public Tripulacion(String id, String nombre, String tipoViajero, int perfilProfesional ) {
		
		this.id = id;
		this.nombre = nombre;
		this.tipoViajero = tipoViajero;
		this.perfilProfesional = perfilProfesional;
	
		
	}
	
	public Tripulacion(String id, String nombre, String tipoViajero, int perfilProfesional, float sueldo ) {
		
		this.id = id;
		this.nombre = nombre;
		this.tipoViajero = tipoViajero;
		this.perfilProfesional = perfilProfesional;
		this.sueldo = sueldo;
	
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getTipoViajero() {
		return tipoViajero;
	}

	@Override
	public int getPerfilProfesional() {
		return perfilProfesional;
	}
		
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	};
	
	public float getSueldo() {
		return sueldo;
	}
	public void setPerfilProfesional(int perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	};
	public abstract float tipoAumentoSueldo(float tipo); 

}
