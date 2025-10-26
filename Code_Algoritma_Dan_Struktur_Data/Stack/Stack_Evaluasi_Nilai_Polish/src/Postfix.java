public class Postfix {
    public static void main(String[] args) {
        StackInt stack = new StackInt(50);

        String ekspresi = "5 1 2 + 4 * + 3 -";
        System.out.println("Hasil = " + stack.eval(ekspresi));
    }
}

class StackInt {
    int[] data;
    int top;

    boolean isEmpty(){
        return (top == -1);
    }

    StackInt(int size) {
        data = new int[size];
        top = -1;
    }

    void push(int val){
        data[++top] = val;
    }

    int pop(){
        return data[top--];
    }

    int eval(String ekspresi){
        String[] token = ekspresi.split(" ");

        for (int i = 0; i < token.length; i++) {
            String t = token[i];

            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = pop();
                int a = pop();
                int hasil = 0;

                if (t.equals("+")) hasil = a + b;
                else if (t.equals("-")) hasil = a - b;
                else if (t.equals("*")) hasil = a * b;
                else if (t.equals("/")) hasil = a / b;

                push(hasil);
            } else {
                push(Integer.parseInt(t));
            }
        }
        return pop();
    }

}
