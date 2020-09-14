/**
 * M8- Rockets
 * IT Academy
 * Barcelona Activa
 * Clase principal MAIN
 *
 */

package lanzamientoAPP;


import motor.MotorCohete;
import motor.Propulsor;
import vehiculo.volador.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Clase principal MAIN de la APP
 * Es algo larga debido a las fases a ejecutar. 
 * 
 * @author Rubén Rodríguez Fernández
 *
 */

 public class lanzamientoApp {

 
	 public static void main(String[] args) {
	
		 /**
		  * Declaramos varios cohetes para varias fases.
		  */
		 String id;
		 
		 VehiculoVolador fase1cohete1;
		 VehiculoVolador fase1cohete2;
		 VehiculoVolador fase2cohete1;
		 VehiculoVolador fase2cohete2;
		 VehiculoVolador fase3cohete1;
		 VehiculoVolador fase3cohete2;
		 VehiculoVolador fase3cohete3;
		 VehiculoVolador fase4cohete;
		 
		 id = String.valueOf(((int)((Math.random()*100)*(Math.random()*100))));
		 // Variables Fase 4
		 int velocidadTotal, velocidadActual, calculoTotal, potenciaTotalMotores=0, bkVelocidadActual;
		 

		 /*
		  * construimos los cohetes de las fases 1,2,3 y 4
		  */
		 fase1cohete1 = new Rocket(id, "Cohete Espacial", "Propulso", 2017, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor(),new Propulsor(), new Propulsor()}))  );
		 fase1cohete2 = new Rocket("LDSFJA32", "Cohete Espacial", "Propulsor", 2017, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor(),new Propulsor(), new Propulsor(),new Propulsor(),new Propulsor(), new Propulsor()}))  );
		 
		 fase2cohete1 = new Rocket("32WESSDS", "Cohete Espacial", "Propulsor", 2018, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor(10),new Propulsor(30), new Propulsor(80)}))  );
		 fase2cohete2 = new Rocket("LDSFJA32", "Cohete Espacial", "Propulsor", 2017, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor(30),new Propulsor(40), new Propulsor(50),new Propulsor(50),new Propulsor(30), new Propulsor(10)}))  );
		 
		 fase3cohete1 = new Rocket("32WESSDS", "Cohete Espacial", "Propulsor", 2018, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor("1",10),new Propulsor("2",30), new Propulsor("3",80)})),"Gea"  );
		 fase3cohete2 = new Rocket("LDSFJA32", "Cohete Espacial", "Propulsor", 2017, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor("1",30),new Propulsor("2",40), new Propulsor("3",50),new Propulsor("4",50),new Propulsor("5",30), new Propulsor("6",10)})),"Ares"  );
		 fase3cohete3 = new Rocket("35WESSDT", "Cohete Espacial", "Propulsor", 2018, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor("1",10),new Propulsor("2",30), new Propulsor("3",80)})),"Apolo"  );
		 fase4cohete  = new Rocket("32HERSDS", "Cohete Espacial", "Propulsor", 2018, new ArrayList<MotorCohete>(Arrays.asList(new Propulsor[]{new Propulsor("1",10),new Propulsor("2",30), new Propulsor("3",80)})),"Hermes");

		 /*
		  * Este objeto lo vamos a utilizar para crear varios hilos por cada cohete. Los cohetes se lanzarán e hilos diferentes
		  * y acelerarán y desacelerarán al mismo tiempo por lo que veremos que se cruzan los hilos de los propulsores 
		  * de cohetes diferentes.
		  */
		 
		 MarchandoCohetes marchandoCohetes = new  MarchandoCohetes();	
		 
		 //FASE 1
		 System.out.println("Fase1:******************************************************  \n"+fase1cohete1.toString());
		 System.out.println("\n"+fase1cohete2.toString());
		 System.out.println("Fin FASE 1:*************************************************");
		 try {
			Thread.sleep(5000);
		 } catch (InterruptedException e) {
			e.printStackTrace();
		 }
		 //FASE 2
		 System.out.println("\n\n\n");
		 System.out.println("Fase2:******************************************************  \n"+fase2cohete1.toString());
		 System.out.println("\n"+fase2cohete2.toString());
		 System.out.println("Fin FASE 2:*************************************************");
		 

		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 //FASE 3

		 System.out.println("\n\n\n");
		 System.out.println("Fase3:******************************************************  \n");
		 
		/* 
		 * Lanzamos 3 cohetes diferentes. El arreglo de enteros que se pasa son las potencias objetivo para
		 * cada propulsor. 
		 * 
		 * Creamos un nuevo hilo para el método ahiVacohete. El método imprime por consola que el cohete está en marcha
		 * y llama a un método de la clase Rockett que será quien cree un hilo para cada propulsor.
		 * 
		 *  Si bien los cohetes aceleran y desaceleran a su "ritmo", los propulsores, si hay un cambio en las potencias,
		 *  se esperan a finalizar la tarea que estaban desarrollando, por eso el método en la clase d epropulsor está 
		 *  sincronizado.
		 * 
		 * 
		 */
	     new Thread(() -> marchandoCohetes.ahiVaCohete(fase3cohete1, new int[] {30,20,50}, "acelera")).start();
	     new Thread(() -> marchandoCohetes.ahiVaCohete(fase3cohete1, new int[] {5,10,23}, "acelera")).start();
	     new Thread(() -> marchandoCohetes.ahiVaCohete(fase3cohete3, new int[] {15,7,33}, "acelera")).start();
	     new Thread(() -> marchandoCohetes.ahiVaCohete(fase3cohete2, new int[] {15,7,33,20,15,23}, "acelera")).start();
	     new Thread(() -> marchandoCohetes.ahiVaCohete(fase3cohete3, new int[] {55,37,13}, "acelera")).start();

		 
		 //FASE 4
	     try {
			Thread.sleep(4000);
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	     
	     System.out.println("-----------FASE4----------------------------------------------");
	     
	     /*
	      * Podríamos hacer una iteración y preguntar al usuario, pero para ver la funcionalidad no es necesario.
	      * vamos a lanzar el cohete y cambiar varias veces de velocidad objetivo.
	      */
	     
	     velocidadTotal = 1000; // Velocidad Objetivo del cohete
	     velocidadActual = 0; //velocidad "inicial"
	     
	     /*
	      * Cálculo para saber la potencia a repartir entre propulsores para alcanzar la velocidad deseada partiendo de la
	      * actual.
	      */
	     calculoTotal = ((velocidadTotal-velocidadActual)/100);  
	     calculoTotal = (int)Math.pow(calculoTotal, 2);
	     
	     
	     // Neceistamos saber que potencia total suman nuestro propulsores-
	     for (int potencia: fase4cohete.potenciaMotores()) {
	       	potenciaTotalMotores+=potencia;
	     }
	    
	     /*
	      * Si la potencia total que suman nuestros propulsores no soportan la potencia total necesaria salta un mensaje
	      * por consola.
	      * 
	      */
	     if (calculoTotal > potenciaTotalMotores)
	    	 System.out.println("El cohete no puede alcanzar esa velociad.");
	     
	     /*
	      * En caso contrario extraemos la potencia de cada propulsor y la almacenamos en un arreglo.
	      * Luego imprimos por pantalla las potencias a alcanzar por ellos. Las sabemos al llamar al método
	      * potenciaMotores de esta misma clase. 
	      * Luego creamos un hilo con el método ahiVaCohete que ya hemos visto antes.
	      * 
	      */
	     else {
	    	 velocidadActual = velocidadTotal;
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		 
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar en el despegue son : "+e);

	    	 //velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();
			
		}
	     
	     /*
	      * Vamos a ir cambiando la velocidad al cohete. al ser el mismo cohete es evidente que este esperará a finalizar
	      * la tarea pendiente (alcanzar la velocidad objetivo anterior) antes de iniciar la nueva.
	      * 
	      * No comentamos las siguiente lineas al ser una copia de las anteriores.
	      */
	     
	     
 	     velocidadTotal = 873;

 	     calculoTotal = ((velocidadTotal-velocidadActual)/100);
 	     calculoTotal = (int)Math.pow(calculoTotal, 2);
 	    
	     if (calculoTotal > potenciaTotalMotores) {
	    	 System.out.println("El cohete no puede alcanzar la velocidad de 873.");
	     }
	     else {
	    	 
		     velocidadActual = velocidadTotal;

	  
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar por propulsores en el primer cambio a 873 son: "+e);

		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();		
		}
	     
	     
	     
 	     velocidadTotal = 1650;

 	     calculoTotal = ((velocidadTotal-velocidadActual)/100);
 	     calculoTotal = (int)Math.pow(calculoTotal, 2);
 	    
	     if (calculoTotal > potenciaTotalMotores) {
	    	 System.out.println("El cohete no puede alcanzar la velocidad de 1650.");
	     }
	     else {
	    	 
		     velocidadActual = velocidadTotal;

	  
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar por propulsores en el primer cambio a 1650 son: "+e);

		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();		
		}
	     
	     /*
	     
 	     velocidadTotal = 2050;

 	     calculoTotal = ((velocidadTotal-velocidadActual)/100);
 	     calculoTotal = (int)Math.pow(calculoTotal, 2);
 	    
	     if (calculoTotal > potenciaTotalMotores) {
	    	 System.out.println("El cohete no puede alcanzar la velocidad de 2050.");
	     }
	     else {
	    	 
		     velocidadActual = velocidadTotal;

	  
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar por propulsores en el primer cambio a 2050 son: "+e);

		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();		
		}
	     
	     
	     
 	     velocidadTotal = 3050;

 	     calculoTotal = ((velocidadTotal-velocidadActual)/100);
 	     calculoTotal = (int)Math.pow(calculoTotal, 2);
 	    
	     if (calculoTotal > potenciaTotalMotores) {
	    	 System.out.println("El cohete no puede alcanzar la velocidad de 3050.");
	     }
	     else {
	    	 
		     velocidadActual = velocidadTotal;

	  
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar por propulsores en el primer cambio a 3050 son: "+e);

		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();		
		}
	     
	     
	     
 	     velocidadTotal = 1250;

 	     calculoTotal = ((velocidadTotal-velocidadActual)/100);
 	     calculoTotal = (int)Math.pow(calculoTotal, 2);
 	    
	     if (calculoTotal > potenciaTotalMotores) {
	    	 System.out.println("El cohete no puede alcanzar la velocidad de 1250.");
	     }
	     else {
	    	 
		     velocidadActual = velocidadTotal;

	  
		     int[] velocidades = potenciaMotores(fase4cohete.potenciaMotores(),calculoTotal);
		     for (int e: velocidades) System.out.println(" velocidades a alcanzar por propulsores en el primer cambio a 1250 son: "+e);

		     new Thread(() -> marchandoCohetes.ahiVaCohete(fase4cohete, velocidades, "acelera")).start();		
		}*/
	     

	 }
	 
	 
	 
	 /**
	  * Este método reparte la potencia a alcanzar entre los propulsores.
	  * lo hace recorriendo uno a uno los propulsores y asignándole el total de su potencia 
	  * hasta alcanzar el total necesitado.
	  * Esto quiere decir que podemos tener dos propulsores a potencia máxima y un tercero a mínima. O un propulsor 
	  * funcionando a potencia alta sin llegar al máximo y el resto a 0.
	  * 
	  * @param potenciaMax Arreglo con las potencias máximas de los propulsores
	  * @param potenciaTotalARepartir  Potencia a repartir
	  * @return Arreglo con las pñotencias que deben alcanzar los propulsores para lograr la potencia objetivo.
	  */
	 static int[] potenciaMotores(int[] potenciaMax, int potenciaTotalARepartir) {
	// System.out.println("Velocidad a alcanzar: "+potenciaTotalARepartir);
	 
	 int [] potenciaRepartida = new int[potenciaMax.length];
	 
	 //inicializamos los propulsores a 0
	 for (int i=0;i< potenciaMax.length;i++)  potenciaRepartida[i]=0;
	 
	 
	 for( int i=0; i< potenciaMax.length; i++) {

		 /* Si llegamos a un momento que la potencia máxima del propulsor es superior a la que necesitamos
		  * sencillamente le asignamos esa velocidad y retornamos 
		  * 
		  */
		 if (potenciaMax[i] >= potenciaTotalARepartir ) 
		 {
			 potenciaRepartida[i] = potenciaTotalARepartir;
			 //System.out.println("1 velocidad propulsor num : "+i+" es "+potenciaRepartida[i]);

			 return potenciaRepartida;
		 }
		
		 /*
		  * En caso contrario el propulsor irá a máxima velocidad 
		  * y restamos esa velocidad a la potencia a repartir para pasar al siguiente propulsor.
		  */
		 potenciaRepartida[i] = potenciaMax[i];
		 potenciaTotalARepartir-=potenciaMax[i];
		 //System.out.println("2 velocidad propulsor num : "+i+" es "+potenciaRepartida[i]);

	 }
	 return potenciaRepartida;			 
		 
 }
}
