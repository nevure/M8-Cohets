# M8-Cohets

La aplicación crea varios cohetes con diferentes propulsores y potencias.
Luego desde el MAIN lanzamos varios hilos por cohete. Para un mismo cohete se lanza un nuevo hilo si cambia la velocidad, pero la instancia, al ser
la misma nos ayuda a qué los propulsores no cambien de velocidad objetivo a medio camino, sino que lo haga al finalizar el actual cambio. Lo hacemos
con un método sincronizado y esperando la finalización de las llamadas a los propulsores.



Paquetes:

- Vehiculo. Paquete que implementa y describe el dominio del vehículo. Desde tipos de vehículos, hasta usuarios (personas) de los mismos. 
- Vehiculo.Users. Podemos ignorarla ya que al final no se ha utilizado.
- Vehiculo.volador. Paquete que implementa la interfaz del paquete vehiculo para vehículos que específicamente vuelan. Sean a motor o no. Crea una clase abstracta que implementa setters y getters y deja declara como abstractos varios métodos. los más importantes aceleraVehiculoVolador y desaceleraVehiculoVolador. Implementa la clase Rockett que hereda de la clase abstracta comentada y también tenemso una clase que hereda de thread y se ejecuta por cada hilo (por cada propulsor). 
- motor.  Paquete con una interfaz que describe métodos comunes a motores de vehículos voladores; y una clase que la implementa. Esta clase será la responsable de decidir si aumentar o reducir la velocidad del propulsor.
-lanzamientoAPP.  Paquete con la clase Main y otra clase MarchandoCohetes que la utilizamos para lanzar varios cohetes a la vez. Además será la responsable
de llamar al método de la clase Rockett que creará los hilos por propulsor.


-> Clases <-

Hay varias interfaces y una clase abstracta. También hay algún método y variables en las clases que se utilizan para "enriquecer" ésta. Sin ningún objetivo para el problema que se nos plantea.

- VehiculoVolador -> es una clases abstracta que implementa a la vez la interfaz vehiculo. Se declara como abstracta el método más importante "aceleraVehiculoVolador". 
  Es un método sincronizado que se responsabiliza de crear los hilos por cada propulsor que tiene el cohete. Y luego espera a que finalicen antes de acabar .
  Rockett -> implementa los métodos abstractos de VehiculoVolador. Sobretodo implementa el método antes comentado. El resto suele ser getters y setters
  Propulsor -> Clase que implementa la interfaz Motorcohete. El método más importante es cambioPotencia ya que es quien decide si el propulsor debe aumentar o      disminuir su velocidad en función de la velocidad objetivo que se le pasa y teniendo en cuenta la velocidad que lleva actualmente. Esta velocidad se guarda en una variable del objeto velocidadInstantanea.
  ControlVuelo -> Esta clase que hereda de Thread imprime por pantalla cada llamada a "cambioPotencia" de la clase Propulsor. Hay una instancia por cada propulsor. 
  MarchandoCohetes -> Esta clase tiene un método que se ejecuta en un hilo por cohete lanzado. 
  
  Esquema:
  Una instancia de MarchandoCohetes es un hilo con un cohete que llama a aceleraVehiculoVolador. Éste método crea un hilo por objeto ControlVuelo quien recibe un propulsor -> llama a cambioPotencia de Propulsor gestiona si sube o baja la potencia; en imprime por pantalla el estado actual del propuilsor.
  
  
 
