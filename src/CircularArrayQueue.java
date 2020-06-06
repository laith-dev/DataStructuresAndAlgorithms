public class CircularArrayQueue<E> implements Queue<E> {

    private final E[] data;     // generic array used for storage
    private int front;          // index of the front element
    private int rear;           // index of the last element
    private static int size;    // current number of elements

    public CircularArrayQueue(int capacity) {
        front = -1;
        rear = -1;
        size = 0;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == data.length);
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            System.out.println("Nothing to peek. Queue is empty!");
            return null;
        }

        return data[front];
    }

    @Override
    public void enqueue(E e) {

        if (isFull()) {
            System.out.println("Cannot enqueue " + e + ". Queue is full!");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
            data[rear] = e;
            size++;

            return;
        }

        /* Adding in queue done at the rear, so find the rear */
        rear = (front + size) % data.length;
        data[rear] = e;
        size++;

    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            System.out.println("Nothing to remove. Queue is empty!");
            return null;
        }
        // Store front to return it
        E answer = data[front];

        // Dereference to help garbage collection
        data[front] = null;

        // Move front one step forward
        front = (front + 1) % data.length;
        size--;

        return answer;

    }

    @Override
    public void printQueue() {

        if (isEmpty()) {
            System.out.println("Nothing to print. Queue is empty!");
            return;
        }

        /* To traverse the queue:
         * 1- Start from the front
         * 2- Move 'size' times
         * - modular used because queue is circular
         * */
        System.out.print("Queue -> ");
        for (int i = 0; i < size; i++)
            System.out.print(data[(front + i) % data.length] + " ");

    }

}
