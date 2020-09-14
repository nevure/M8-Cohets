/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase TripulaciónEspacial
 * 
 *
 */


package vehiculo.Users;

/**
 * 
 * Esta clase no se utiliza para la resolución del ejercico. 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public class TripulacionEspacial extends Tripulacion {
	
	
	
	public  TripulacionEspacial(String id, String nombre, String tipoViajero, int perfilProfesional ) {
		
		super(id, nombre, tipoViajero, perfilProfesional);	
	}
		
	public  TripulacionEspacial(String id, String nombre, String tipoViajero, int perfilProfesional, float sueldo ) {
		
		super(id, nombre, tipoViajero, perfilProfesional, sueldo);
	
	}
	
	@Override
	public float tipoAumentoSueldo(float tipo) {
		
		float sueldoTotal;
		if(getPerfilProfesional() == 1)
			sueldoTotal = (float)(getSueldo()*((1+tipo/100)-0.01));
		else if (getPerfilProfesional() == 2) 
			sueldoTotal = (float)(getSueldo()*((1+tipo/100)-0.02));
		else 
			sueldoTotal = (float)(getSueldo()*((1+tipo/100)-0.05));	
		setSueldo(sueldoTotal);
		return sueldoTotal;
	}

}
