package practice;

public class fibonacci {

    public static void main(String[] args) {
        new fibonacci();
    }

    public fibonacci() {
        fibonacci(29);
    }

    public void fibonacci(int amount) {
        int n1 = 0;
        int n2 = 1;
        int n3;

        for (int k = 0; k < amount; k++) {
            n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
