import java.util.EmptyStackException;

public class queue {
    Object[] queue;
    int front, rear;
    int itemCount;

    public static void main(String[] args) {

    }

    public void QueueArray(int size) {
        queue = new Object[size];
        itemCount = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return (itemCount == 0);
    }

    private boolean isFull() {
        return (itemCount == queue.length-1);
    }

    public void makeEmpty() {
        queue = new Object[10];
        front = 0;
        rear = -1;
        itemCount = 0;
    }

    public void enqeue(Object x){
        if (isFull()){
            arrayDoubling();
        }
        itemCount++;
        queue[++rear] = x;
    }

    public void arrayDoubling(){
        Object[] oldArray = queue;
        queue = new Object[oldArray.length * 2];
        System.arraycopy(oldArray, 0, queue, 0, oldArray.length);
    }

    public Object dequeue() throws EmptyStackException {
        if (!isEmpty()){
            Object tmp = queue[front];
            for (int i = 0; i < itemCount; i++){
                queue[i] = queue[i+1];
            }
            queue[itemCount--] = null;
            rear--;
            return tmp;
        } else {
            System.err.println("Queue-nya kosong nih");
            throw new EmptyStackException();
        }
    }

    public Object getFront() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Object x = queue[front];
        return x;
    }
}

