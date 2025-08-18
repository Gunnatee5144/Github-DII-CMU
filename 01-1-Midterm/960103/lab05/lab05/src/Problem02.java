import java.util.Scanner;

public class Problem02 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number : ");
        String inputNum = input.nextLine();
        int num1 = Integer.parseInt(inputNum);

        for (int i = 1; i <= 12 ; i++) {
            System.out.println(num1 + " x " + i + " = " + (num1 * i));
        }
    }
}
