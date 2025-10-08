public class Main {
    public static void main(String[] args) {
        StackArray Stack = new StackArray();
        Stack.initialized(10);

        Stack.pushStack(1);
        Stack.pushStack(2);
        Stack.pushStack(3);
        Stack.pushStack(4);
        Stack.pushStack(5);
        Stack.pushStack(6);
        Stack.pushStack(7);

        System.out.println(Stack.peekStack());
        Stack.popStack();
        Stack.popStack();
        System.out.println(Stack.peekStack());
    }
}

class StackArray {
    int top;
    int array_size;
    int stack[];

    StackArray(){
        initialized(5);
    }

    void initialized(int size){
        array_size = size;
        stack = new int[array_size];
        top = 0;
    }

    boolean isEmpty(){
        return (top == 0);
    }

    boolean isFull(){
        return (top == array_size);
    }

    int popStack(){
        if (isEmpty()){
            System.err.println("Stack masih kosong");
            return -1;
        } else
            return stack[--top];
    }

    void pushStack(int data){
        if (isFull()){
            System.err.println("Stacknya penuh -> resize");
            stack = resizing(stack);
        }
        stack[top++] = data;
    }

    int[] resizing(int[] element){
        int[] arrDouble = new int[2 * element.length];
        array_size = arrDouble.length;
        System.arraycopy(element, 0, arrDouble, 0, element.length);
        return arrDouble;
    }

    int peekStack(){
        return stack[top - 1];
    }
}