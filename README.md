# Práctica 06 - Programación Concurrente con Hilos en Java

## Objetivo
Dividir un problema matemático en sub-tareas que se ejecuten en paralelo mediante hilos y combinar los resultados correctamente, evaluando el impacto en el tiempo de ejecución.

## Descripción
El programa calcula la suma definida:



$$
S = \sum_{i=1}^{1000000} f(i), \quad f(i) = i^2 + 3i + 1
$$



Para ello:
- Se utiliza un número configurable de hilos (N).
- Cada hilo calcula un rango específico de la suma.
- Los resultados parciales se almacenan en una estructura compartida segura para evitar condiciones de carrera.
- El hilo principal espera a que todos los hilos terminen, suma los resultados parciales y muestra el resultado final.
- Se mide el tiempo de ejecución con 1, 2, 4 y 8 hilos para comparar la eficiencia.

## Tecnologías utilizadas
- Java
- Eclipse IDE

## Instrucciones de ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/KevinAlanTC/Practica06.git
   ```
2. Verificar la estructura de directorios:

  ```
  Proyecto/
  ├── src/
  │   ├── Main.java
  │   └── SumTask.java
  └── README.txt
  ```

3. Compilar el proyecto desde el directorio raíz:

  ```bash
  javac src/SumTask.java src/Main.java
  ```

4. Ejecutar el programa principal indicando el número de hilos:

  ```bash
  java src/Main 4
  ```

5. Revisar los tiempos de ejecución y el resultado final mostrado en consola.
