/*
 * @author Kevin Alan Torres Cruz
 */

// Clase que representa la tarea de cada hilo
public class SumTask implements Runnable
{
	private long start; // inicio del rango
    private long end; // fin del rango
    private long partialResult; // resultado parcial

    // Constructor: recibe el rango que le toca al hilo
    public SumTask(int start, int end) 
    {
        this.start = start;
        this.end = end;
        this.partialResult = 0;
    }

    // Método que ejecuta el cálculo (se corre en paralelo)
    @Override
    public void run() 
    {
        for (long i = start; i <= end; i++)
            partialResult += (i * i + 3 * i + 1);
    }

    // Método para obtener el resultado parcial
    public long getPartialResult() 
    {
        return partialResult;
    }

}
