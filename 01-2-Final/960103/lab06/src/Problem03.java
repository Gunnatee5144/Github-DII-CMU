import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] name = new String[5];
        double[] height = new double[5];
        double height_tem = 0;
        int index_tem = 0;
        for (int x = 0 ; x <= 4; x++) {
            System.out.print("Input student " + (x+1) + " name : ");
            String name_input = input.next();
            name[x] = name_input;
            System.out.print("\nInput student " + (x+1) + " height : ");
            double height_input = input.nextDouble();
            height[x] = height_input;
        }

        for (int y = 0 ; y <= 4; y++) {
            if (height_tem <= height[y]) {
                index_tem = y;
            }
        }

        System.out.println("Student tallest is " + name[index_tem] + " and height :" + height[index_tem]);
    }
}
