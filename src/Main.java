/*
 * @author Kevin Alan Tprres Cruz
 */

import java.util.Scanner;

//Clase principal
public class Main
{
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc = new Scanner(System.in);

	     // Pedir al usuario el número de hilos
	     System.out.print("Ingrese el número de hilos (ej. 1, 2, 4, 8): ");

	     int total = 1_000_000; // límite superior de la suma
	     
	     int maxHilos = Runtime.getRuntime().availableProcessors() * 2;
	     
	     int N = 0;
	     // Validación de entrada
	     while (true) 
	     {
	    	 System.out.print("Ingrese el número de hilos (ej. 1, 2, 4, 8): ");
	    	 if (sc.hasNextInt()) 
	    	 {
                N = sc.nextInt();
                if (N > 0 && N <= maxHilos) 
                    break; // válido
                else
                    System.out.println("Error: el número de hilos debe ser mayor que 0 y menor o igual a " + maxHilos);
	    	 } 
	    	 else 
	    	 {
	    		 System.out.println("Error: debe ingresar un número entero.");
	    		 sc.next(); // limpiar entrada inválida
	    	 }
        }
	     
	     
	    // Número de repeticiones para calcular promedio
        int repeticiones = 5;
        long sumaTiempos = 0;

        for (int r = 1; r <= repeticiones; r++) 
        {
        	// Arreglos para guardar tareas y hilos
   	     	SumTask[] tasks = new SumTask[N];
   	     	Thread[] threads = new Thread[N];
            int rango = total / N; // tamaño de cada bloque

	        // Medición de tiempo
	   	    long inicio = System.currentTimeMillis();

	   	    // Crear y lanzar hilos
            for (int j = 0; j < N; j++) 
            {
                int start = j * rango + 1;
                int end = (j == N - 1) ? total : (j + 1) * rango;
                tasks[j] = new SumTask(start, end);
                threads[j] = new Thread(tasks[j]);
                threads[j].start();
            }

   	     	// Esperar a que terminen y sumar resultados
            long resultado = 0;
            for (int j = 0; j < N; j++) 
            {
                threads[j].join();
                resultado += tasks[j].getPartialResult();
            }

            long fin = System.currentTimeMillis();
            long tiempo = fin - inicio;

            System.out.println("Ejecución " + r + ": Resultado = " + resultado + ", Tiempo = " + tiempo + " ms");
            sumaTiempos += tiempo;
        }

        // Mostrar resultado
        long promedio = sumaTiempos / repeticiones;
        System.out.println("Tiempo promedio con " + N + " hilos: " + promedio + " ms");

	     sc.close();
	}
}