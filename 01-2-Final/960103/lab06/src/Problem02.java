import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] num = new int[15];

        for(int x = 0; x < 15 ; x++){
            System.out.print("Enter your number " + (x+1) + " : ");
            int num_input = input.nextInt();
            num[x] = num_input;
        }

        for (int y = 0; y < 15; y++) {
            System.out.println("Your data after change array " + (y+1) + " is " + num[y]);
        }

        System.out.print("Enter your number index in array : ");
        int num_index = input.nextInt();
        num_index = num_index - 1;
        System.out.print("Enter yout number to change : ");
        int num_change = input.nextInt();

        num[num_index] = num_change;

        for (int z = 0; z < 15; z++) {
            System.out.println("Your data after change array " + (z+1) + " is " + num[z]);
        }
    }
}
