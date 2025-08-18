import java.util.Scanner;

public class Problem01 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number : ");
        String numInput = input.nextLine();
        int num1 = Integer.parseInt(numInput);
        int mostNum = 0;
        String evenSum = "";
        String primeSum = "";

        for (int i = 1 ; i <= num1; i++) {
            // Even Number
            if (i % 2 == 0) {
                evenSum = String.format("%d %s", i, evenSum);
            }

            // Prime Number
            boolean isPrime = true;
            if (i <= 1 ) {
                isPrime = false;
            } else {
                for (int a = 2; a <= Math.sqrt(i); a++) {
                    if (i % a == 0) {
                        isPrime = false;
                    }
                }
            }

            if (isPrime) {
                primeSum = String.format("%d %s", i, primeSum);
            }

            // Largest Number
            if (i > mostNum) {
                mostNum = i;
            }
        }

        System.out.println("Even Number : " + evenSum);
        System.out.println("Prime Number : " + primeSum);
        System.out.println("Largest Number : " + mostNum);

    }
}
