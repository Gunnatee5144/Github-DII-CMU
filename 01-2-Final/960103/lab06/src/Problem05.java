import java.util.Locale;
import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num_input;
        boolean while_program;

        System.out.print("Enter your count : ");
        int count_input = input.nextInt();
        double[] num = new double[count_input];

        for (int x = 0 ; x < count_input; x++) {

            System.out.print("Enter your number " + (x + 1) + " : ");
            num_input = input.nextDouble();
            num[x] = num_input;
            continue;
        }

        for (int x = 0; x < num.length; x++) {
            if (num[x] > num[x + 1]) {
                num[x + 1] = num[x];
            }
        }

        System.out.print("Result : ");
        for (int y = 0; y < num.length; y++) {
            System.out.print(num[y] + " ");
        }

        input.close();
    }
}
