/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase Rocket... ControlVuelo
 *
 */
package vehiculo.volador;

import motor.MotorCohete;

/**
 * Clase que hereda de Thread. 
 * Se ejecuta el run por cada propulsor de cada cohete. Cada propulsor de cada cohete lanza un solo hilo. 
 * Puede haber varios cohetes en lanzamiento. Cada cohete tiene varios propulsores y cada propulsor tiene un hilo
 * que ejecuta el siguiente run.
 * 
 * Básicamente llamamos al método cambioPotencia del propulsor para aumentar o disminuir la velocidad en función
 * del método potenciaObjetivo que recibe esta clase por constructor.
 * 
 * Ciertamente esta clase podría estar dentro del paquete de motor. Pero bueno, para no retrasar más el envío lo dejo aquí.
 * 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public class ControlVuelo extends Thread {
	
	private MotorCohete propulsor;
	private int potenciaObjetivo;
	private String nomCohete;
	
	/**
	 * Constructor 
	 * @param motor Motor del cohete para el que creamos el hilo
	 * @param potenciaObjetivo  Potencia objetivo del motor.
	 * @param nomCohete  Nombre del cohete al que pertenece el motor. para imprimir por consola.
	 */
	public ControlVuelo(MotorCohete motor, int potenciaObjetivo, String nomCohete){
		super();
		
		this.potenciaObjetivo = potenciaObjetivo;
		this.propulsor = motor;
		this.nomCohete = nomCohete;
	}
	
	@Override
	public void run() {
		
		/* Mientras el propulsor no alcance su velocidad máxima u objetivo acelera o desacelera (lo decide el propulsor)
		 * Imprimimos por pantalla cada uno de los avances del propulsor (acelere o desacelere)
		 */
		while(!propulsor.cambioPotencia(potenciaObjetivo)) {
			System.out.println("Thread - "+getName()+" ->Cohete: "+nomCohete+". Propulsor: "+propulsor.getID()+" con potencia máxima: "
					+propulsor.getPotenciaMaxima()+" Velocidad objetivo: "+potenciaObjetivo+"  actualmente su vel. instantanea se cambia a: "+propulsor.getPotenciaInstantanea());		
		}
		
		/*
		 * Aquí solo lanzamos un mensaje para saber si el propulsor se ha parado por que ha llegado a la velocidad límite
		 * o bien porque ha alcanzado la velocidad objetivo.
		 * 
		 */
		if (propulsor.getPotenciaMaxima() == propulsor.getPotenciaInstantanea())
			System.out.println("Thread - "+getName()+" ->Cohete: "+nomCohete+". Propulsor: "+propulsor.getID()+" con potencia máxima: "
				+propulsor.getPotenciaMaxima()+". El propulsor ha alcanzado su límite. \n");
		else 
			System.out.println("Thread - "+getName()+" ->Cohete: "+nomCohete+". Propulsor: "+propulsor.getID()+" con potencia máxima: "
					+propulsor.getPotenciaMaxima()+". El propulsor ha alcanzado la velocidad deseada. \n");
			
		
		
		
	/*
	* Ignorar los siguiente métodos. los Mantengo por una cuestión académica personal. ya que me dieron mucho dolor de cabeza y
	* quizá lo retome para obtener el resultado que quería por otra vía. 
	*/
	
	}
	private void acelera(int potencia) {
		
		for (int i=0; i>potencia;i++) {
			propulsor.acelera();
			System.out.println("Thread: "+getName()+" -->Propulsor con identificador: " + propulsor.getID() 
				+ "\n      ->  Velocidad Instantanea: "+propulsor.getPotenciaInstantanea()); 
			try {  
	               Thread.sleep(40);
			}  
	        catch(InterruptedException e){
	            
	        }					
		}
		
	}
	
	private void desacelera(int potencia) {
		
		for (int i=0; i>potencia;i++) {
			propulsor.desacelera();
			System.out.println("Thread: "+getName()+" -->Propulsor con identificador: " + propulsor.getID() 
			+ "\n      ->  Velocidad Instantanea: "+propulsor.getPotenciaInstantanea()); 
			
			try {  
	              Thread.sleep(40);
			}  
	        catch(InterruptedException e){
	            
	        }
	
		}
	}
}


