package es.ulpgc.eii.containers.bounded;

public class QueueOfInt {
	protected int[] data;    // Espacio para almacenar los elementos
	protected int front = 0; // Posición del primer elemento
	protected int rear = -1; // Posición del último elemento (-1 == cola vacía)

	/**
	 * Crea una cola con capacidad para bound elementos
	 * @param bound
	 */
	public QueueOfInt(int bound) {
		data = new int[bound];
	}
	
	/**
	 * @return número de elementos alamacenados en la cola this
	 */
	public int count() {
		return rear - front + 1;
	}
	
    /**
     * @return la capacidad de la cola referenciada por this
     */
    public int bound() {
        return data.length;
    }
    
	/**
	 * Inserta element en la cola this. Si this está llena no hace nada.
	 * @param element
	 */
	public void insert(int element) {
		if (count() < data.length) { // Se comprueba si queda espacio
			if (rear == data.length - 1) {
				// Los elementos están al final de la cola y hay espacio al
				// principio. Se desplazan los elementos al principio para
				// que el espacio quede al final y se pueda usar
				System.arraycopy(data, front, data, 0, count());
				rear -= front;
				front = 0;
			}

			// Se inserta el nuevo elemento al final de la cola
			data[++rear] = element;
		}
	}
	
	/**
	 * @return primer elemento de la cola this
	 */
	public int getFirst() {
		return data[front]; // ¡¡ Da error si la cola está vacía !!
	}
	
	/**
	 * Elimina el primer elemento de la cola
	 */
	public void remove() {
		front++;
		
		if (front > rear) { // La cola ha quedado vacía
			front = 0;
			rear = -1;
		}
	}
}

