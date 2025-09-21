import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students : ");
        int num_stu = input.nextInt();

        String[] name_stu = new String[num_stu];
        double[][] data_stu = new double[num_stu][2];

        for (int x = 0; x < num_stu; x++) {
            System.out.print("\nEnter your information student " + (x + 1) + "\n");
            System.out.print("Name : ");
            name_stu[x] = input.next();

            System.out.print("Height : ");
            data_stu[x][0] = input.nextDouble();

            System.out.print("Weight : ");
            data_stu[x][1] = input.nextDouble();
        }

        System.out.println("----- Summary Information Students -----");
        for (int y = 0; y < num_stu; y++) {
            System.out.println("\nStudent " + (y + 1) + "\nName : " + name_stu[y] + "\nHeight : " + data_stu[y][0] + "\nWeight : " + data_stu[y][1]);
        }

        input.close();
    }
}