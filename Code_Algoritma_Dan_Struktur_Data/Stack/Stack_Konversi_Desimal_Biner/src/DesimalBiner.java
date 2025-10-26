public class DesimalBiner {
    public static void main(String[] args) {
        int desimal = 25;
        StackInt stack = new StackInt(32);

        int n = desimal;
        while (n > 0){
            int sisa = n % 2;
            stack.push(sisa);
            n /= 2;
        }

        System.out.print("Biner dari " + desimal + " = ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}

class StackInt {
    int[] data;
    int top;

    StackInt(int size){
        data = new int[size];
        top = -1;
    }

    boolean isEmpty(){
        return (top == -1);
    }

    void push(int val){
        data[++top] = val;
    }

    int pop(){
        return data[top--];
    }
}