/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase Porpulsor
 *
 */

package motor;

import java.util.Calendar;

/**
 * 
 * Clase que implementa la interfaz MotorCohete. 
 * En este caso hablamos d epropulsores con sus características.
 * 
 * El método más importante es cambioPotencia que es el que decide si debe acelerar o desacelerar en función 
 * de la potencia objetivo que se le pasa y de la potencia immediata en la que se encuentra.
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public class Propulsor implements MotorCohete {

	private int potenciaMaxima;
	private int potenciaMedia;
	private int potenciaInstantanea = 0;
	private int anyoFabricacion;
	private String modeloPropulsor;
	private String id;
	
	
	/**
	 * Constructor
	 * 
	 * el propulsor no recibe ningún parámetro.
	 * crea un id aleatorio.
	 * potencia a 0.
	 * año de fabricación actual.
	 * modelo no especificado.
	 */
	public  Propulsor() {
		id = String.valueOf(((int)((Math.random()*100)*(Math.random()*100))));
		potenciaMaxima = 0;
		anyoFabricacion = Calendar.getInstance().get(Calendar.YEAR);
		modeloPropulsor = "No especificado";

	}
	
	/**
	 * Constructor
	 * 
	 * Igual que el anterior pero aquí sí recibe la potencia máxima del propulsor.
	 * 
	 * @param potenciaMaxima  potencia máxima del propulsor
	 */
	public Propulsor(int potenciaMaxima) {
		id = String.valueOf(((int)((Math.random()*100)*(Math.random()*100))));
		anyoFabricacion = Calendar.getInstance().get(Calendar.YEAR);
		modeloPropulsor = "No especificado";
		this.potenciaMaxima = potenciaMaxima;
	}
	
	/**
	 * Constructor
	 * 
	 * Recibe además el identificador
	 * 
	 * @param id   identificador del propulsor
	 * @param potenciaMaxima  Potencia Máxima del propulsor.
	 */
	public Propulsor(String id, int potenciaMaxima) {
		this.id = id;
		anyoFabricacion = Calendar.getInstance().get(Calendar.YEAR);
		modeloPropulsor = "No especificado";
		this.potenciaMaxima = potenciaMaxima;
	}
	
	/**
	 * Constructor
	 * Recibe todos los parámetros del propulsor.
	 * 
	 * @param id
	 * @param modelo
	 * @param anyoFabricacion
	 * @param potenciaMax
	 */
	public Propulsor(String id, String modelo, int anyoFabricacion, int potenciaMax) {
		this.id = id;
		this.modeloPropulsor = modelo;
		this.anyoFabricacion = anyoFabricacion;
		this.potenciaMaxima = potenciaMax;
	}
	
	/**
	 * Método que recibe un potencia objetivo para el propulsor.
	 * 
	 * En función de la velocidad objetivo y la velocidad actual (potenciaInstantanea) acelerará o desacelerará.
	 * O en caso de haber llegaro al límite de su potencia o alcanzar la velocidad deseada no hará nada.
	 */
	public boolean cambioPotencia(int velocidadObjetivo) {
		
		/*
		 * Velocidad objetivo mayor o igual a potencia máxima del propulsor este acelerará sí o sí salvo haber alcanzado ya
		 * su potencia máxima
		 */
		if (velocidadObjetivo >= potenciaMaxima)
			if(potenciaMaxima==potenciaInstantanea)
				return true;
			else
			acelera();
			
		
		/*
		 * Si la veocidad objetivo está por debajo de la potencia máxima tendremos que verificar si la velocidad
		 * actual (instantanea) está por debajo o por encima de la objetivo. Y así decidir si acelera o desacelera.
		 */
		else if (velocidadObjetivo < potenciaMaxima)
			if (velocidadObjetivo < potenciaInstantanea )
				desacelera();
			else if (velocidadObjetivo > potenciaInstantanea)
				acelera();
			else {
				return true;
				
			}
		else 
			return true;
		return false;
		
		
			
				
	}
	
	/**
	 * Setters y Getters
	 */

	@Override
	public int getPotenciaMaxima() {
		// TODO Auto-generated method stub
		return potenciaMaxima;
	}

	@Override
	public int getPotenciaMedia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setPotenciaMaxima(int potenciaMax) {
		this.potenciaMaxima = potenciaMax;
	}

	@Override
	public void setPotenciaMedia(int potenciaMedia) {
		this.potenciaMedia = potenciaMedia;
	}
	
	@Override
	public String getModelo() {
		return modeloPropulsor;
	}
	
	@Override
	public int anyoFabricacion() {
		return anyoFabricacion;
	}
	
	@Override
	public int getPotenciaInstantanea() {
		return potenciaInstantanea;
	}
	
	/**
	 * este método acelera la potencia del propulsor siempre y cuando su potencia máxima se lo permita.
	 * 
	 */
	@Override
	public void acelera() {
		if (potenciaInstantanea < potenciaMaxima)
		potenciaInstantanea ++;
	}
	
	/**
	 * este método desacelera la potencia del propulsor.
	 * 
	 */
	@Override
	public void desacelera() {
		if (potenciaInstantanea > 0)
			potenciaInstantanea --;
	}
	
	
	@Override
	public String toString() {
		return "Propulsor con identificador: "+id+" del modelo: "+modeloPropulsor+". Año de fabricación: "+anyoFabricacion+ ". Y Con una potencia máxima de "+potenciaMaxima;
	}

}
