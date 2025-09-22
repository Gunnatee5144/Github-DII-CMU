import java.util.Scanner;

public class Problem04 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your number student : ");
        int num_stu = input.nextInt();
        double[][] score_stu = new double[num_stu][3];
        double sum_physics = 0;
        double sum_biology = 0;
        double sum_chemistry = 0;
        double average_physics = 0;
        double average_biology = 0;
        double average_chemistry = 0;

        for (int x = 0; x < num_stu; x++) {
            System.out.print("Enter the " + (x + 1) + " student Physics score: ");
            score_stu[x][0] = input.nextDouble();
            System.out.print("Enter the " + (x + 1) + " student Biology score: ");
            score_stu[x][1] = input.nextDouble();
            System.out.print("Enter the " + (x + 1) + " student Chemistry score: ");
            score_stu[x][2] = input.nextDouble();
        }

        System.out.print("Physics, Biology, Chemistry | Total | Average");
        for (int a = 0; a < num_stu; a++) {
            double sum_score_tem = score_stu[a][0] + score_stu[a][1] + score_stu[a][2];
            double average_score_tem = sum_score_tem / 3;
            System.out.print("\nStudent " + (a + 1) + ": " + score_stu[a][0] + " "
                    + score_stu[a][1] + " " + score_stu[a][2] + " | " + sum_score_tem
                    + " | " + String.format("%.2f", average_score_tem));
        }


        System.out.print("\nAverage scores of Physics, Biology, and Chemistry");
        for (int y = 0; y < num_stu; y++) {
            sum_physics += score_stu[y][0];
            sum_biology += score_stu[y][1];
            sum_chemistry += score_stu[y][2];
        }

        average_physics = sum_physics / num_stu;
        average_biology = sum_biology / num_stu;
        average_chemistry = sum_chemistry / num_stu;

        System.out.print("\n" + average_physics + " " + average_biology + " " +
                average_chemistry);

        for (int z = 0; z < num_stu; z++) {
            System.out.print("\nStudent " + (z + 1) + ": ");
            if (score_stu[z][0] > average_physics) {
                System.out.print("Pass ");
            } else {
                System.out.print("No ");
            }
            if (score_stu[z][1] > average_biology) {
                System.out.print("Pass ");
            } else {
                System.out.print("No ");
            }
            if (score_stu[z][2] > average_chemistry) {
                System.out.print("Pass ");
            } else {
                System.out.print("No ");
            }
        }
    }
}