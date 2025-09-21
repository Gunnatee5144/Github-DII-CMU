import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows : ");
        int n_row = input.nextInt();
        System.out.print("Enter column : ");
        int n_column = input.nextInt();

        int[][] data = new int[n_row][n_column];

        // รับค่าใส่ array
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print("Enter number of " + "[" + row + "][" + col + "]" + " : ");
                data[row][col] = input.nextInt();
            }
        }

        // แสดงข้อมูล + คำนวณผลรวมแถว
        int[] colTotals = new int[n_column];
        int grandTotal = 0;

        for (int row_print = 0; row_print < data.length; row_print++) {
            int rowSum = 0;
            for (int col_print = 0; col_print < data[row_print].length; col_print++) {
                int value = data[row_print][col_print];
                System.out.print(value + " ");
                rowSum += value;
                colTotals[col_print] += value; // เก็บผลรวมคอลัมน์
            }
            grandTotal += rowSum;
            System.out.println("| " + rowSum);
        }

        System.out.println("----");

        // แสดงผลรวมคอลัมน์
        for (int c = 0; c < n_column; c++) {
            System.out.print(colTotals[c] + " ");
        }
        System.out.println("| " + grandTotal);
    }
}
