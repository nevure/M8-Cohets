/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase Marchando cohetes
 *
 */

package lanzamientoAPP;

import vehiculo.volador.VehiculoVolador;

/**
 * La clase principal MAIN utiliza esta clase para crear hilos para cada cohete que lance. Solo tiene un método 
 * que llamará al método del cohete "aceleraVehiculoVolador" que lo que hará será por cada propulsor crear un hilo 
 * para que aceleren o desaceleren para llegar a la velocidad objetivo. 
 * 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */
public class MarchandoCohetes {
	
	public MarchandoCohetes() {	
	}
	
	public void ahiVaCohete(VehiculoVolador cohete, int[] velocidades, String tipo) {
		
		System.out.println("Marchando cohete : "+cohete.getNombre()+" Con "+cohete.toStringFase3()+"con Tread id: "+Thread.currentThread()+" y el objeto this es: "+this.toString() );
			cohete.aceleraVehiculoVolador(velocidades);		
	}
}
