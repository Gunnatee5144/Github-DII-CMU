import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a, b, c;

        System.out.print("Enter first positive integer : ");
        a = input.nextInt();
        System.out.print("Enter second positive integer : ");
        b = input.nextInt();
        System.out.print("Enter third positive integer : ");
        c = input.nextInt();

        for (int i = 0; i < 2; i++) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (b > c) {
                int temp = b;
                b = c;
                c = temp;
            }
        }

        System.out.println("Numbers in ascending order: " + a + " " + b + " " + c);
        input.close();

    }

}
