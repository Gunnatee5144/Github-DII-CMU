import java.util.Scanner;

public class Problem01half2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers: ");
        int count = sc.nextInt();

        String evenNumbers = "";
        String primeNumbers = "";
        String primeSum = "";
        int largest = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = sc.nextInt();

            // เลขคู่
            if (num % 2 == 0) {
                evenNumbers += num + " ";
            }

            // จำนวนเฉพาะ
            boolean isPrime = true;
            if (num < 2) {
                isPrime = false;
            } else {
                for (int a = 2; a < num; a++) {
                    if (num % a == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                primeSum = String.format("%d %s", num, primeSum);
            }

            // ค่ามากสุด
            if (num > largest) {
                largest = num;
            }
        }

        // แสดงผลทั้งหมดตอนท้าย
        System.out.println("\nEven numbers: " + evenNumbers.trim());
        System.out.println("Prime numbers: " + primeSum);
        System.out.println("Largest number: " + largest);

        sc.close();
    }
}
