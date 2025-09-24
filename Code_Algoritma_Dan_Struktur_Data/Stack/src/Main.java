// Stack Atau Tumpukan
public class Main {
    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push("A");
        s.print();
        s.push("B");
        s.print();
    }
}

class StackArray {
    final int INITIAL_SIZE = 0;
    Object[] data;
    int top;

    public StackArray() {
        data  = new Object[INITIAL_SIZE];
        top = 1;
    }

    public boolean isEmtpy() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length-1;
    }

    public void arrayDoubling() {
        Object[] newData = new Object[2 * data.length];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
    }

    public void push(Object data) {
        if (isFull()) {
            arrayDoubling();
        }
        data[++top] = data;
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " - ");
        }
    }
}