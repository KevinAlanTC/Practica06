TORRES CRUZ KEVIN ALAN

# Práctica 06 

## Tabla de tiempos promedio

|  Número  | Primer tiempo |
| de hilos | promedio (ms) |
|----------|---------------|
|    1     |       3       |
|    2     |       4       |
|    4     |       5       |
|    8     |       6       |

### Observación sobre los tiempos y el promedio
Durante las primeras ejecuciones los tiempos fueron más altos (13 ms o 20 ms, por mencionar ejemplos), pero en ejecuciones posteriores se redujeron drásticamente (por ejemplo 1 ms o 2 ms). Según tengo entendido, esto se debe a que el entorno de ejecución de Java necesita cargar clases y preparar recursos en las primeras ejecuciones, mientras que en las siguientes ya aprovecha lo que está inicializado. Por esta razón decidí calcular promedios de varias ejecuciones, ya que reflejan mejor el rendimiento real y evitan que una ejecución inusual altere las conclusiones.

## Reflexión

### ¿Se volvió más rápido el programa?
En este caso no. Con un solo hilo el tiempo fue muy bajo (aproximadamente 3 ms), y al aumentar el número de hilos el tiempo promedio incluso creció ligeramente (aproximadamente 6 ms con 8 hilos). Esto se debe a que el problema no es lo suficientemente grande para que la paralelización compense la sobrecarga de crear y coordinar hilos. Con esto aprendí que usar más hilos no garantiza acelerar un programa, sino que depende del tamaño de la tarea y del costo de sincronización.

### ¿Qué problemas encontraste al manejar datos compartidos?
Uno de los problemas fue evitar condiciones de carrera entre los hilos, para lo cual fue necesario que cada hilo tuvo su propia variable partialResult donde acumulaba su suma parcial. De esta forma, ningún hilo escribía en la misma variable que otro, eliminando así el riesgo de interferencia. Al final, el hilo principal reunió los resultados parciales después de que todos los hilos terminaron, garantizando que la combinación fuera segura.
Otro problema fue validar el número de hilos ingresado por el usuario. Si se le permitían valores absurdos (como 0, negativos o demasiados hilos), el programa podría fallar o volverse ineficiente. Por eso se implementó una verificación que limita el número de hilos a un rango válido según la capacidad del procesador, asegurando estabilidad y rendimiento.

### ¿Qué aprendí sobre los programas que usan más de un hilo?
Aprendí que la paralelización puede mejorar el rendimiento en problemas grandes, pero no siempre de manera proporcional al número de hilos. En mi caso, al sumar hasta un millón, el tiempo con un solo hilo ya era muy bajo, y al aumentar hilos el tiempo incluso creció ligeramente debido a la sobrecarga de crear y coordinar hilos. Esto me enseñó que usar más hilos no garantiza acelerar un programa, sino que depende del tamaño de la tarea y del costo de sincronización.
También comprendí que los tiempos de ejecución varían entre ejecuciones por factores externos como el sistema operativo, la carga del CPU y la memoria, entre otros; haciendo a unas ejecuciones más lentas y a otras más rápidas. Por eso fue importante calcular promedios.
Finalmente, aprendí que manejar datos compartidos requiere cuidado: cada hilo debe trabajar con su propio resultado parcial para evitar condiciones de carrera, y el hilo principal debe reunirlos al final. Además, validar el número de hilos es esencial para evitar valores absurdos que afecten la estabilidad o el rendimiento.

