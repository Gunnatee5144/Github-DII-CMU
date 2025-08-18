import java.util.Scanner;

public class Problem04 {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int lines = sc.nextInt();

        for (int i = 1; i <= lines ; i++) {
            for (int a = 1; a <= lines - i ; a++) {
                System.out.print(" ");
            }

            char ch = 'A';
            for (int j = 1 ; j <= i ; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            ch -= 2;

            for (int k = 1; k < i; k++){
                System.out.print(ch + " ");
                ch--;
            }

            System.out.println();
        }
    }
}
