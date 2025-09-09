import java.util.Scanner;

public class Problem01 {
    public static void main (String[] args) {
        Scanner input_num = new Scanner(System.in);
        int[] num = new int[10];
        for (int x = 0; x <= 9; x++) {
            System.out.print("Input number " + (x+1) + " : ");
            int num_sum = input_num.nextInt();
            num[x] = num_sum;
        }

        System.out.print("Input number to check : ");
        int num_input_check = input_num.nextInt();

        for (int y = 0; y <= 9; y++) {
            if (num_input_check == num[y]) {
                System.out.println("Find same number !");
                break;
            }
        }
    }
}
